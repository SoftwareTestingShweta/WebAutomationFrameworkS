package HybridFramework.tests;

import HybridFramework.pages.pageObjectModel.LoginPage_POM;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestVWOLogin_POM {


    @Test
    public void testLoginNegativeVWO(){
        WebDriver driver = new ChromeDriver();
        LoginPage_POM loginPagePom = new LoginPage_POM(driver);
        String msg_text = loginPagePom.loginToVWOInvalidCred("Shwetatelka@gmail.com","12356");
        Assert.assertEquals(msg_text,"Your email, password, IP address or location did not match");
        driver.quit();

    }

    @Test
    public void testLoginNegativeVWO2(){
        WebDriver driver = new ChromeDriver();
        LoginPage_POM loginPagePom = new LoginPage_POM(driver);
        String msg_text = loginPagePom.loginToVWOInvalidCred("admin@gmail.com","admin");
        Assert.assertEquals(msg_text,"Your email, password, IP address or location did not match");
        driver.quit();

    }


}
