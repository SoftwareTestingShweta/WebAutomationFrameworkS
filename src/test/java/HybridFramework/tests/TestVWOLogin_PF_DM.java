package HybridFramework.tests;

import HybridFramework.base.CommonToAllTest;
import HybridFramework.pages.pageFactory.LoginPage_PF;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
//import java.util.logging.Logger;

import static HybridFramework.driver.DriverManger.driver;
import org.apache.logging.log4j.Logger;

public class TestVWOLogin_PF_DM extends CommonToAllTest {

    private static final Logger logger = LogManager.getLogger(TestVWOLogin_PF_DM.class);

    @Test
    public void  testLoginNegativeVWO() throws FileNotFoundException {

        logger.info("Starting Test");
        LoginPage_PF loginPage_pf = new LoginPage_PF(driver);

        logger.info("Opening the URL");
        loginPage_pf.openVWOLoginURL("qa");

        String errorMessage = loginPage_pf.loginToVWOInvalidCred();
        logger.info("Verifying the Result");
        Assert.assertEquals(errorMessage,"Your email, password, IP address or location did not match");
        driver.quit();
    }


}
