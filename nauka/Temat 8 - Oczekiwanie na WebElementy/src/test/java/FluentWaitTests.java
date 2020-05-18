import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.time.Duration;

import static org.testng.Assert.*;

public class FluentWaitTests {
    WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "D:\\JavaStartSelenium\\chromedriver81.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void fluentWaitTest(){
        FluentWait fw = new FluentWait(driver);
        fw.withTimeout(Duration.ofSeconds(20));
        fw.pollingEvery(Duration.ofMillis(250));

        driver.navigate().to("http://theinternet.przyklady.javastart.pl/dynamic_loading/1");
        WebElement helloWorld = driver.findElement(By.xpath("//div[@id='finish']/h4"));
        assertFalse(helloWorld.isDisplayed());

        WebElement button = driver.findElement(By.xpath("//div[@id='start']/button"));
        button.click();

        fw.until(ExpectedConditions.visibilityOf(helloWorld));
        assertTrue(helloWorld.isDisplayed());


    }

    @AfterMethod
    public void afterMethod() {
        driver.close();
        driver.quit();
    }
}
