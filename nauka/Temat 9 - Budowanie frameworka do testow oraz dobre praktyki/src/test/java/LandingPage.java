import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
    private WebDriver driver;

    LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnEnterStoreLink() {
        WebElement enterStoreLink = driver.findElement(By.cssSelector("div p a"));
        enterStoreLink.click();
    }
}
