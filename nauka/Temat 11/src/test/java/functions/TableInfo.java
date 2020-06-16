package functions;
import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TableInfo {
    private WebElement table;

    private List<WebElement> rows;
    private List<WebElement> columns;

    public TableInfo(WebDriver driver, By tableLocator){
        table=driver.findElement(tableLocator);

        columns=table.findElements(By.xpath("thead//span"));

        rows=table.findElements(By.xpath("tbody/tr"));
    }

    public int getNumberOfRows(){
    return rows.size();
    }

    public int getNumberOfColumns(){
        return columns.size();
    }

    public WebElement getLastNameForRow (int rowIndex){
        WebElement lastNameRow = rows.get(rowIndex).findElement(By.xpath("td[1]")); //(By.xpath("td[1]")) - dla kolumny 1
        return lastNameRow;
    }

    public WebElement getWebSiteForRow(int rowIndex){
        WebElement webSiteRow=rows.get(rowIndex).findElement(By.xpath("td[5]"));
        return webSiteRow;
    }
}
