package zadania;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DropDownTests {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "D:\\JavaStartSelenium\\chromedriver81.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/dropdown");
        sleep();
    }

    @Test
    public void dropDownTest(){
        WebElement options = driver.findElement(By.id("dropdown"));
        Select optionsDropDown = new Select(options);

        assertEquals(optionsDropDown.getFirstSelectedOption().getText(),"Please select an option");
        sleep();

        optionsDropDown.selectByVisibleText("Option 1");
        assertTrue(optionsDropDown.getFirstSelectedOption().getText().equals("Option 1"));

        sleep();
        optionsDropDown.selectByValue("2");
        assertTrue(optionsDropDown.getFirstSelectedOption().getAttribute("value").equals("2"));


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
