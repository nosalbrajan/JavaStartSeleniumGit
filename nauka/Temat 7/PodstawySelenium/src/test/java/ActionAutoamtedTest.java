import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ActionAutoamtedTest {
    WebDriver driver;
    Actions action;

    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "D:\\JavaStartSelenium\\chromedriver81.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://przyklady.javastart.pl/test/hover_mouse.html");
    }

    @Test
    public void firstCase() {
        sleep();
        WebElement icon1 = driver.findElement(By.id("smiley"));
        WebElement icon2 = driver.findElement(By.id("smiley2"));

        action = new Actions(driver);


        action.moveToElement(icon1).moveToElement(icon2).build().perform();
        sleep();
    }

    public void sleep(){
        try{
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void afterMethod() {
        driver.close();
        driver.quit();
    }
}
