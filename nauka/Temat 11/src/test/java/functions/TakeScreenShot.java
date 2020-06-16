package functions;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import driver.DriverManager;

public class TakeScreenShot {


    public static void takeScreenShot() {
        File scrFile = ((TakesScreenshot) DriverManager.getWebDriver()).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(scrFile, new File("Screenshots/selenium_screenshot.png"));
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
