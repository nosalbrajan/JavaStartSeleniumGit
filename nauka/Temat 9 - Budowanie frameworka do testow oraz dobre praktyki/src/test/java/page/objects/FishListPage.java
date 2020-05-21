package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class FishListPage {
    private Logger logger =  LogManager.getRootLogger();

    @FindBy(css = "a[href*='FI-SW-01']")
    private WebElement angelFishIdLink;


    public FishListPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public AngelFishListPage clickOnAngelFishIdLink(){
        angelFishIdLink.click();
        logger.info("Clicked on Angelfish ID link");
        return new AngelFishListPage();
    }

}
