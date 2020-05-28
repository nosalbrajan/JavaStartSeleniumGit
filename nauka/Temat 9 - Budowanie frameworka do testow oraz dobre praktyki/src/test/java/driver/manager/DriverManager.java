package driver.manager;

import configuration.LocalWebDriverProperties;
import configuration.TestRunProperties;
import driver.BrowserFactory;
import driver.BrowserType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static configuration.TestRunProperties.*;
import static driver.BrowserType.FIREFOX;


public class DriverManager {
    private static WebDriver driver;

    private DriverManager() {
    }

    public static WebDriver getWebDriver() {
        if (driver == null) {
            driver = new BrowserFactory(getBrowserToRun(), getIsRemoteRun()).getBrowser();
        }
        return driver;
    }

    public static void disposeDriver() {
        driver.close();
        if (!getBrowserToRun().equals(FIREFOX)) {
            driver.quit();
        }
        driver = null;
    }
}
