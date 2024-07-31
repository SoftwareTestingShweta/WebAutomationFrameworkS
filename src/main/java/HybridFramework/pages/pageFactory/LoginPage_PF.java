package HybridFramework.pages.pageFactory;

import HybridFramework.base.CommonToAllPage;
import HybridFramework.utils.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileNotFoundException;

public class LoginPage_PF extends CommonToAllPage {

    WebDriver driver;
    public LoginPage_PF(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    // Page Locators

    @FindBy(id = "login-username")
    private WebElement username;

    @FindBy(id = "login-password")
    private WebElement password;

    @FindBy(id = "js-login-btn")
    private WebElement submitButton;

    @FindBy(id = "js-notification-box-msg")
    private WebElement errorMessage;

    //Page Actions


    public String loginToVWOInvalidCred() throws FileNotFoundException {
//        username.sendKeys("admin@123@gmail.com");
//        password.sendKeys("admin@123");
//        submitButton.click();

//        enterInput(username,"admin@admin.com");
//        enterInput(password,"admin@123");

        try {
            enterInput(username,PropertyReader.readKey("invalid_username"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        enterInput(password, PropertyReader.readKey("invalid_password"));
        clickElement(submitButton);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return errorMessage.getText();

    }


}
