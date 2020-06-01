package tests;

import configuration.ConfigurationProperties;
import configuration.PropertiesLoader;
import driver.BrowserType;
import driver.manager.DriverManager;
import driver.manager.DriverUtilites;
import navigation.ApplicationURLs;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import static navigation.ApplicationURLs.*;


import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    protected WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        PropertiesLoader propertiesLoader = new PropertiesLoader();
        Properties propertiesFromFile = propertiesLoader.getPropertiesFromFile("configuration.properties");
        ConfigurationProperties.setProperties(propertiesFromFile);
    }

    @Parameters("browser")
    @BeforeMethod
    public void beforeMethod(@Optional BrowserType browserType) {
        DriverManager.setWebDriver(browserType);
        DriverManager.getWebDriver();
        DriverUtilites.setInitialConfiguration();
    }


    @AfterMethod
    public void afterMethod() {
        DriverManager.disposeDriver();
    }
}
