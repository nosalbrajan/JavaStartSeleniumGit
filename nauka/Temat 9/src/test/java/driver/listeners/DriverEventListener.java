package driver.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import java.util.Arrays;


public class DriverEventListener implements WebDriverEventListener {

    private static Logger logger = LogManager.getLogger(DriverEventListener.class);

    @Override
    public void beforeAlertAccept(WebDriver webDriver) {
        logger.info("Trying to accept alert");
    }

    @Override
    public void afterAlertAccept(WebDriver webDriver) {
        logger.info("Accepted alert");
    }

    @Override
    public void afterAlertDismiss(WebDriver webDriver) {
        logger.info("Dismissed alert");
    }

    @Override
    public void beforeAlertDismiss(WebDriver webDriver) {
        logger.info("Trying to dismiss alert");
    }

    @Override
    public void beforeNavigateTo(String url, WebDriver webDriver) {
        logger.info("Trying to navigate " + url);
    }

    @Override
    public void afterNavigateTo(String url, WebDriver webDriver) {
        logger.info("Navigated to " + url);
    }

    @Override
    public void beforeNavigateBack(WebDriver webDriver) {
        logger.info("Trying to navigate back for page with URL: " + webDriver.getCurrentUrl());
    }

    @Override
    public void afterNavigateBack(WebDriver webDriver) {
        logger.info("Navigated back for page with URL: " + webDriver.getCurrentUrl());
    }

    @Override
    public void beforeNavigateForward(WebDriver webDriver) {
        logger.info("Trying to navigate for page with URL: " + webDriver.getCurrentUrl());
    }

    @Override
    public void afterNavigateForward(WebDriver webDriver) {
        logger.info("Navigated for page with URL: " + webDriver.getCurrentUrl());
    }

    @Override
    public void beforeNavigateRefresh(WebDriver webDriver) {
        logger.info("Trying to refresh page with URL: " + webDriver.getCurrentUrl());
    }

    @Override
    public void afterNavigateRefresh(WebDriver webDriver) {
        logger.info("Refreshed page with URL: " + webDriver.getCurrentUrl());
    }

    @Override
    public void beforeFindBy(By by, WebElement webElement, WebDriver webDriver) {
        logger.info("Trying to find element with locator " + by.toString());
    }

    @Override
    public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) {
        logger.info("Found element with locator " + by.toString());
    }

    @Override
    public void beforeClickOn(WebElement webElement, WebDriver webDriver) {
        logger.info("Trying to click on element with tag name " + webElement.getTagName());
    }

    @Override
    public void afterClickOn(WebElement webElement, WebDriver webDriver) {
        logger.info("Clicked on element");
    }

    @Override
    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] keysToSend) {
        if (keysToSend == null) {
            logger.info("Trying to enter empty string or clear element " + webElement.getTagName());
        } else {
            logger.info("Trying to type into element " + webElement.getTagName() + " text " + Arrays.toString(keysToSend));
        }
    }

    @Override
    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] keysToSend) {
        if (keysToSend == null) {
            logger.info("Entered empty string or cleared element " + webElement.getTagName());
        } else {
            logger.info("Typed into element " + webElement.getTagName() + " text " + Arrays.toString(keysToSend));
        }
    }

    @Override
    public void beforeScript(String script, WebDriver webDriver) {
        logger.info("Trying to execute JS script: " + script);
    }

    @Override
    public void afterScript(String script, WebDriver webDriver) {
        logger.info("Executed JS script: " + script);
    }

    @Override
    public void beforeSwitchToWindow(String s, WebDriver webDriver) {
        logger.info("Trying to switch to window: " + s);
    }

    @Override
    public void afterSwitchToWindow(String s, WebDriver webDriver) {
        logger.info("Switched to window: " + s);
    }

    @Override
    public void onException(Throwable throwable, WebDriver webDriver) {
        logger.info("There was an exception with message: " + throwable.getMessage());
    }

    @Override
    public <X> void beforeGetScreenshotAs(OutputType<X> outputType) {
        logger.info("Trying to get screenshot");
    }

    @Override
    public <X> void afterGetScreenshotAs(OutputType<X> outputType, X x) {
        logger.info("Done screenshot");
    }

    @Override
    public void beforeGetText(WebElement webElement, WebDriver webDriver) {
        logger.info("Trying to get text for WebElement");
    }

    @Override
    public void afterGetText(WebElement webElement, WebDriver webDriver, String s) {
        logger.info("Taken text fro WebElement. Text was: " + s);
    }
}
