import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Selektory {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod(){
        System.setProperty("webdriver.chrome.driver","D:\\JavaStartSelenium\\chromedriver.exe");
        driver= new ChromeDriver();
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/hovers");
    }

    @Test
    public void cssPaths(){
        WebElement fish = driver.findElement(By.xpath("//div[@class='example']//h3"));
        String value = fish.getAttribute("Value");
        String getText=fish.getText();
        System.out.println("value: "+ value+" getText: "+getText);


    }

    @AfterMethod
    public void afterMethod(){
        driver.close();
        driver.quit();
    }
}
