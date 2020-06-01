package page.objects;

import driver.manager.DriverManager;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCardPage {
    private Logger logger = LogManager.getRootLogger();

    @FindBy(css ="a.Button[href*='newOrderForm']")
    private WebElement proccedToCheckOutButton;

    public ShoppingCardPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    @Step("Click on Procced to Check Out Button")
    public void ClickOnProccedToCheckOutButton(){
        proccedToCheckOutButton.click();
        logger.info("Clicked on Procced To Check Out Button");

    }
}
