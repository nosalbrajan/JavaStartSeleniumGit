package driver.manager;

import driver.BrowserType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.session.InternetExplorerFilter;

public class BrowserFactory {
    public static WebDriver getBrowser(BrowserType browserType) {
        switch (browserType) {
            case CHROME:
                System.setProperty("webdriver.chrome.driver", "D:\\JavaStartSelenium\\chromedriver81.exe");
                return new ChromeDriver();
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", "D:\\JavaStartSelenium\\geckodriver.exe");
                return new FirefoxDriver();
            case IE:
                System.setProperty("webdriver.ie.driver", "D:\\JavaStartSelenium\\IEDriverServer.exe");
                return new InternetExplorerDriver();
            default:
                throw new IllegalStateException("Unknown browser type! Please check your configuration");
        }
    }
}
