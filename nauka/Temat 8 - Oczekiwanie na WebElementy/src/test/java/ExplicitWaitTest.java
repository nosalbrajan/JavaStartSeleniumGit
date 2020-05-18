import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.*;

public class ExplicitWaitTest {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "D:\\JavaStartSelenium\\chromedriver81.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/dynamic_controls");
    }

    @Test
    public void waitForDisappearingElement() {
        wait = new WebDriverWait(driver, 20);

        WebElement checkbox = driver.findElement(By.xpath("//div[@id='checkbox']"));
        assertTrue(checkbox.isDisplayed());
        assertFalse(checkbox.isSelected());

        WebElement button = driver.findElement(By.xpath("//button[@id='btn']"));
        button.click();


        WebElement message = driver.findElement(By.xpath("//p[@id='message']"));
        assertEquals(message.getText(), "It's gone!");
    }

    @Test
    public void waitForPresenceOfTheElement() {
        WaitUntil waitUntil = new WaitUntil(driver);

        WebElement checkbox = driver.findElement(By.xpath("//div[@id='checkbox']"));
        assertTrue(checkbox.isDisplayed());
        assertFalse(checkbox.isSelected());

        WebElement addAndRemove = driver.findElement(By.xpath("//button[@id='btn']"));
        addAndRemove.click();

        waitUntil.waitUntilElementIsInvisibility(checkbox);

        WebElement message = driver.findElement(By.xpath("//p[@id='message']"));
        assertEquals(message.getText(), "It's gone!");

        addAndRemove.click();

        checkbox = waitUntil.waitUntilPresenceOfElementLocated(By.id("checkbox"));

        assertTrue(checkbox.isDisplayed());
        assertFalse(checkbox.isSelected());
    }

    @AfterMethod
    public void afterMethod() {
        driver.close();
        driver.quit();
    }
}

class WaitUntil {
    WebDriverWait wait;

    WaitUntil(WebDriver driver) {
        wait = new WebDriverWait(driver, 30);
    }

    public void waitUntilElementIsInvisibility(WebElement element) {
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public WebElement waitUntilPresenceOfElementLocated(By by) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }




}
