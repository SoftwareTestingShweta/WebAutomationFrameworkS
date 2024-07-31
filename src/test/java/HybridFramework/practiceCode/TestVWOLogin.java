package HybridFramework.practiceCode;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestVWOLogin {

    @Test
    public void testVWOLoginNegative() throws InterruptedException {

        EdgeOptions options = new EdgeOptions();
        options.addArguments("--guest");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        WebDriver driver = new EdgeDriver(options);
        driver.get("https://app.vwo.com");
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Login - VWO");
        Assert.assertEquals(driver.getCurrentUrl(),"https://app.vwo.com/#/login");

        WebElement emailInputBox = driver.findElement(By.id("login-username"));
        emailInputBox.sendKeys("admin@admin.com");

        Thread.sleep(3000);
        WebElement passwordBox = driver.findElement(By.id("login-password"));
        passwordBox.sendKeys("savi@123");

        WebElement submitButton = driver.findElement(By.id("js-login-btn"));
        submitButton.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement errorMessage = driver.findElement(By.className("notification-box-description"));
        Assert.assertEquals(errorMessage.getText(),"Your email, password, IP address or location did not match");
        System.out.println(errorMessage.getText());

        // By using anchor

//        WebElement freeTrailLink = driver.findElement(By.linkText("Start a free trial"));
//        freeTrailLink.click();

        WebElement freeTrailPartialLink = driver.findElement(By.partialLinkText("Start a"));
        freeTrailPartialLink.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();


    }

}
