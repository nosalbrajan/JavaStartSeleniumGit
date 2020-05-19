package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCardPage {
    WebDriver driver;

    @FindBy(css ="a.Button[href*='newOrderForm']")
    private WebElement proccedToCheckOutButton;

    public ShoppingCardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void ClickOnProccedToCheckOutButton(){
        proccedToCheckOutButton.click();
    }
}
