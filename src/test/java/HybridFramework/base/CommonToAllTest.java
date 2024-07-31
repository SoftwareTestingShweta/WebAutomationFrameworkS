package HybridFramework.base;

import HybridFramework.driver.DriverManger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class CommonToAllTest {

    // To call the Start the Webdriver
    // Down the WebDriver
    // Start Webdirver start

    @BeforeMethod
    public void setUp(){
        DriverManger.init();
    }

    @AfterMethod
    public void tearDown(){
        DriverManger.down();
    }
}
