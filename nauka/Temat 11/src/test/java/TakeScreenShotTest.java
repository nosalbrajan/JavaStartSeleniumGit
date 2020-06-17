import driver.DriverManager;
import functions.TableInfo;
import functions.TakeScreenShot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TakeScreenShotTest {
    protected WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        driver = DriverManager.getWebDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void TakeScreenShot() {
        driver.navigate().to("https://www.google.pl/");
        TakeScreenShot.takeScreenShot();
    }


    @AfterMethod
    public void afterMethod() {
        DriverManager.disposeDriver();
    }
}
