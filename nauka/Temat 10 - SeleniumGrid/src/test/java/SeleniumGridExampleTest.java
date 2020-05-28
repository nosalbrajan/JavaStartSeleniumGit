import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.Assert.assertTrue;

public class SeleniumGridExampleTest {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() throws MalformedURLException {
        InternetExplorerOptions IEOptions = new InternetExplorerOptions();
        IEOptions.enablePersistentHovering();
        IEOptions.ignoreZoomSettings();
        IEOptions.setCapability("version","8");
        driver = new RemoteWebDriver(new URL("http://169.254.57.70:4444/wd/hub"), IEOptions);
    }

    @Test
    public void searchQueryInGoogle() throws InterruptedException {
        driver.navigate().to("http://google.pl");

        driver.findElement(By.name("q")).sendKeys("JavaStart");
        driver.findElement(By.name("q")).submit();

        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);


        assertTrue(pageTitle.contains("JavaStart"));
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
    }
}