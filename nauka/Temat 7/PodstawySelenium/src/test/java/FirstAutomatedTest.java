import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class FirstAutomatedTest {
    WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "D:\\JavaStartSelenium\\chromedriver81.exe");
        driver = new ChromeDriver();
    }


    @Test
    public void testCase1() {
        driver.navigate().to("http://google.pl");

        WebElement query = driver.findElement(By.name("q"));
        query.sendKeys("JavaStart");
        query.submit();

        String pageTitle=driver.getTitle();

        assertTrue(pageTitle.contains("JavaStart"));
    }
}
