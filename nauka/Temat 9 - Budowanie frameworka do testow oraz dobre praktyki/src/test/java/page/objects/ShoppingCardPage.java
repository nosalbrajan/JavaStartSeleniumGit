package page.objects;

import driver.manager.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class ShoppingCardPage {

    @FindBy(css ="a.Button[href*='newOrderForm']")
    private WebElement procedToCheckOutButton;

    public ShoppingCardPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public void ClickOnProccedToCheckOutButton(){
        WaitForElement.waitUntilElementIsClickable(procedToCheckOutButton);
        procedToCheckOutButton.click();
    }
}
