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

public class FileUploadTests {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "D:\\JavaStartSelenium\\chromedriver81.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/upload");
        sleep();
    }

    @Test
    public void dropDownTest() {
        WebElement fileUpload = driver.findElement(By.id("file-upload"));
        fileUpload.sendKeys("D:\\Projekty JAVA\\PodstawySelenium\\testfile.txt");
        sleep();

        driver.findElement(By.id("file-submit")).click();

        WebElement checkUploadedFile = driver.findElement(By.xpath("//div[@id='uploaded-files']"));
        String uploadedFileName = checkUploadedFile.getText();

        sleep();
        assertEquals(uploadedFileName,"testfile.txt");
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
