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

    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "D:\\JavaStartSelenium\\chromedriver81.exe");
        DriverManager.getWebDriver();
        DriverUtilites.setInitialConfiguration();
        DriverUtilites.navigateToPage(APPLICATION_URL);
    }


    @AfterMethod
    public void afterMethod() {
        DriverManager.disposeDriver();
    }
}
