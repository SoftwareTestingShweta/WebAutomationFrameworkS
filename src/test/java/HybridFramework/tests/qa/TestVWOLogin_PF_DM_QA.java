package HybridFramework.tests.qa;

import HybridFramework.base.CommonToAllTest;
import HybridFramework.pages.pageFactory.LoginPage_PF;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

import static HybridFramework.driver.DriverManger.driver;

public class TestVWOLogin_PF_DM_QA extends CommonToAllTest {

    private static final Logger logger = LogManager.getLogger(TestVWOLogin_PF_DM_QA.class);

    @Test
    public void  testLoginNegativeVWO() throws FileNotFoundException {

        logger.info("Starting Test in QA environment");
        LoginPage_PF loginPage_pf = new LoginPage_PF(driver);

        logger.info("Opening the URL");
        loginPage_pf.openVWOLoginURL("qa");

        String errorMessage = loginPage_pf.loginToVWOInvalidCred();
        logger.info("Verifying the Result");
        Assert.assertEquals(errorMessage,"Your email, password, IP address or location did not match");

        // AssertJ

        Assertions.assertThat(errorMessage).isNotBlank().isNotNull();

        driver.quit();
    }


}
