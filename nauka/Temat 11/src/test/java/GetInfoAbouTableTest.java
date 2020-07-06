import driver.DriverManager;
import functions.TableInfo;
import functions.TakeScreenShot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class GetInfoAbouTableTest {
    protected WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        driver = DriverManager.getWebDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/tables");
    }


    @Test
    public void GetInfoAboutTable() {
        TableInfo tableInfo = new TableInfo(driver, By.id("table1"));
        System.out.println("Columns: " + tableInfo.getNumberOfColumns() + ", Rows: " + tableInfo.getNumberOfRows() + ", " +
                "sum: " + (tableInfo.getNumberOfColumns() * tableInfo.getNumberOfRows()));
        System.out.println(tableInfo.getLastNameForRow(2).getText());
        System.out.println(tableInfo.getWebSiteForRow(3).getText());
    }

    @Test
    public void traversingTable2() {
        TableInfo tableInfo = new TableInfo(driver, By.id("table2"));

        int numberOfRows = tableInfo.getNumberOfRows();
        int numberOfColumns = tableInfo.getNumberOfColumns();

        int expectedNumberOfRows = 4;
        int expectedNumberOfColumns = 6;

        assertEquals(numberOfRows, expectedNumberOfRows);
        assertEquals(numberOfColumns, expectedNumberOfColumns);

        int firstRowIndex = 0;
        int lastRowInex = numberOfRows - 1;

        WebElement lastNameFirstRow = tableInfo.getLastNameForRow(firstRowIndex);
        WebElement lastNameLastRow = tableInfo.getLastNameForRow(lastRowInex);

        assertEquals(lastNameFirstRow.getText(), "Smith");
        assertEquals(lastNameLastRow.getText(), "Conway");

        WebElement webSiteFirstRow = tableInfo.getWebSiteForRow(firstRowIndex);
        WebElement webSiteLastRow = tableInfo.getWebSiteForRow(lastRowInex);

        assertEquals(webSiteFirstRow.getText(), "http://www.jsmith.com");
        assertEquals(webSiteLastRow.getText(), "http://www.timconway.com");

    }

    @AfterMethod
    public void afterMethod() {
        DriverManager.disposeDriver();
    }
}
