package zadania;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HoverTests {
    WebDriver driver;

    @BeforeMethod
    public void BeforeMethod(){
        System.setProperty("webdriver.chrome.driver","D:\\JavaStartSelenium\\chromedriver81.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/hovers");
        sleep();
    }

    @Test
    public void hoverTest(){
        WebElement firstPhoto = driver.findElements(By.className("figure")).get(0);
        WebElement secondPhoto = driver.findElements(By.className("figure")).get(1);
        WebElement thirdPhoto = driver.findElements(By.className("figure")).get(2);

        WebElement firstUserCaption = driver.findElement(By.xpath("//div[@id='content']/div/div[1]/div/h5"));
        WebElement secondUserCaption = driver.findElement(By.xpath("//div[@id='content']/div/div[2]/div/h5"));
        WebElement thirdUserCaption = driver.findElement(By.xpath("//div[@id='content']/div/div[3]/div/h5"));

        Actions action = new Actions(driver);

        action.moveToElement(firstPhoto).perform();
        sleep();

        assertEquals(firstUserCaption.getText(),"name: user1");
        assertEquals(secondUserCaption.getText(),"");
        assertEquals(thirdUserCaption.getText(),"");
        sleep();

        action.moveToElement(thirdPhoto).perform();
        sleep();

        assertEquals(firstUserCaption.getText(),"");
        assertEquals(secondUserCaption.getText(),"");
        assertEquals(thirdUserCaption.getText(),"name: user3");
        sleep();
    }

    @AfterMethod
    public void afterMethod(){
        driver.close();
        driver.quit();
    }

    public void sleep(){
        try{
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
