package page.objects;

import driver.manager.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCardPage {

    @FindBy(css ="a.Button[href*='newOrderForm']")
    private WebElement proccedToCheckOutButton;

    public ShoppingCardPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public void ClickOnProccedToCheckOutButton(){
        proccedToCheckOutButton.click();
    }
}
