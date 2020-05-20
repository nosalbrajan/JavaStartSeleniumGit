package tests;

import driver.manager.DriverManager;
import driver.manager.DriverUtilites;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {

    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "D:\\JavaStartSelenium\\chromedriver81.exe");
        DriverManager.getWebDriver();
        DriverUtilites.setInitialConfiguration();
        DriverUtilites.navigateToPage("http://przyklady.javastart.pl/jpetstore/");
    }


    @AfterMethod
    public void afterMethod() {
        DriverManager.disposeDriver();
    }
}
