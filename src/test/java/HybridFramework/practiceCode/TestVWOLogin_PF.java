package HybridFramework.practiceCode;

import HybridFramework.pages.pageFactory.LoginPage_PF;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class TestVWOLogin_PF {

    @Test
    public void  testLoginNegativeVWO() throws FileNotFoundException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com");
        System.out.println(driver.getTitle());
        LoginPage_PF loginPage_pf = new LoginPage_PF(driver);
        String errorMessage = loginPage_pf.loginToVWOInvalidCred();
        Assert.assertEquals(errorMessage,"Your email, password, IP address or location did not match");
        driver.quit();
    }


}
