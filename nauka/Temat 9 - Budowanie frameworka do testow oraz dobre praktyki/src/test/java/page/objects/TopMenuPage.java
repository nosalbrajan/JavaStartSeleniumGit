package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class TopMenuPage {
    Logger logger = LogManager.getRootLogger();


    @FindBy(css = "a[href*=signon]")
    private WebElement singOnLink;

    public TopMenuPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public void clickOnSingInLink() {
        WaitForElement.waitUntilElementIsClickable(singOnLink);
        singOnLink.click();
        logger.info("Clicked on Sing On Link");
    }
}
