import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class FluentWaitTests2 {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod(){
        System.setProperty("webdriver.chrome.driver", "D:\\JavaStartSelenium\\chromedriver81.exe");
        driver=new ChromeDriver();
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/dynamic_loading/2");
    }

    @Test
    public void fluentWaitWithExceptionTest(){
        FluentWait fl = new FluentWait(driver);
        fl.withTimeout(Duration.ofSeconds(10));
        fl.pollingEvery(Duration.ofMillis(250));
        fl.ignoring(NoSuchElementException.class);

        WebElement startButton = driver.findElement(By.xpath("//div[@id='start']/button"));
        startButton.click();

        fl.until(ExpectedConditions.presenceOfElementLocated((By.xpath("//div[@id='finish']/h4"))));
        WebElement helloWorldText = driver.findElement(By.xpath("//div[@id='finish']/h4"));
        assertTrue(helloWorldText.isDisplayed());
    }
}
