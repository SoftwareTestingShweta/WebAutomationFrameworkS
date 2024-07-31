package HybridFramework.pages.pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage_POM {

    // Contains

    // Page Locators

    WebDriver driver;

    public LoginPage_POM(WebDriver driver){
       this.driver =driver;
    }

    private By username = By.id("login-username");
    private By password = By.id("login-password");
    private By submitButton = By.id("js-login-btn");
    private By errorMessage = By.id("js-notification-box-msg");


    // Page Actions
   //  Login

    public String loginToVWOInvalidCred(String user , String pass){

        driver.get("https://app.vwo.com");
        System.out.println(driver.getTitle());

//        driver.findElement(username).sendKeys("Shwetatelka@gmail.com");
//        driver.findElement(password).sendKeys("1235");

        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(submitButton).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String msg_text = driver.findElement(errorMessage).getText();
        System.out.println(msg_text);


        return msg_text;
    }


}
