package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "D:\\JavaStartSelenium\\chromedriver81.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://przyklady.javastart.pl/jpetstore/");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }


    @AfterMethod
    public void afterMethod() {
        driver.close();
        driver.quit();
    }
}
