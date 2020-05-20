package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class ShoppingCardPage {
    private Logger logger = LogManager.getRootLogger();

    @FindBy(css ="a.Button[href*='newOrderForm']")
    private WebElement proccedToCheckOutButton;

    public ShoppingCardPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public void ClickOnProccedToCheckOutButton(){
        WaitForElement.waitUntilElementIsClickable(proccedToCheckOutButton);
        proccedToCheckOutButton.click();
        logger.info("Clicked on Procced To Check Out Button");
    }
}
