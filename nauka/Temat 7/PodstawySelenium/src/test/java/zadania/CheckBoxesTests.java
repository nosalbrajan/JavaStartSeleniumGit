package zadania;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class CheckBoxesTests {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "D:\\JavaStartSelenium\\chromedriver81.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/checkboxes");
        sleep();
    }

    @Test
    public void checkBoxesTest() {
        WebElement checkbox1 = driver.findElements(By.cssSelector("input[type='checkbox']")).get(0);
        WebElement checkbox2 = driver.findElements(By.cssSelector("input[type='checkbox']")).get(1);

        assertFalse(checkbox1.isSelected());
        assertTrue(checkbox2.isSelected());
        sleep();

        checkbox1.click();
        checkbox2.click();
        assertTrue(checkbox1.isSelected());
        assertFalse(checkbox2.isSelected());
        sleep();
    }

    @AfterMethod
    public void afterMethod() {
        driver.close();
        driver.quit();
    }

    public void sleep() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
