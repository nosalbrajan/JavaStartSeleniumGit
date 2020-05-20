package waits;

import driver.manager.DriverManager;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitForElement {
    private static WebDriverWait webDriverWait;

    private static WebDriverWait getwebDriverWait() {
        return new WebDriverWait(DriverManager.getWebDriver(), 10);
    }

    public static void waitUntilElementIsVisible(WebElement element) {
        WebDriverWait webDriverWait = getwebDriverWait();
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitUntilElementIsClickable(WebElement element) {
        WebDriverWait webDriverWait = getwebDriverWait();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
