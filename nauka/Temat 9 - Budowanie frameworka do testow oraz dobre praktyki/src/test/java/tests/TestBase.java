package tests;

import driver.manager.DriverManager;
import driver.manager.DriverUtilites;
import navigation.ApplicationURLs;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import static navigation.ApplicationURLs.*;


import java.util.concurrent.TimeUnit;

public class TestBase {
    protected WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        DriverManager.getWebDriver();
        DriverUtilites.setInitialConfiguration();
    }


    @AfterMethod
    public void afterMethod() {
        DriverManager.disposeDriver();
    }
}
