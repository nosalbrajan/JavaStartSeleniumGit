import driver.DriverManager;
import functions.TableInfo;
import functions.TakeScreenShot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GetInfoAbouTableTest {
    protected WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        driver = DriverManager.getWebDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }


    @Test
    public void GetInfoAboutTable() {
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/tables");
        TableInfo tableInfo = new TableInfo(driver, By.id("table1"));
        System.out.println("Columns: " + tableInfo.getNumberOfColumns() + ", Rows: " + tableInfo.getNumberOfRows() + ", " +
                "sum: " + (tableInfo.getNumberOfColumns() * tableInfo.getNumberOfRows()));
        System.out.println(tableInfo.getLastNameForRow(2).getText());
        System.out.println(tableInfo.getWebSiteForRow(3).getText());
    }

    @AfterMethod
    public void afterMethod() {
        DriverManager.disposeDriver();
    }
}
