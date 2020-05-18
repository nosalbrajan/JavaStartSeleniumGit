import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TopMenuPage {
    private WebDriver driver;

    TopMenuPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnSingInLink() {
        WebElement singOn = driver.findElement(By.cssSelector("a[href*=signon]"));
        singOn.click();
    }
}
