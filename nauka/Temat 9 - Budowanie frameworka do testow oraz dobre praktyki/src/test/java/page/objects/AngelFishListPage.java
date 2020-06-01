package page.objects;

import driver.manager.DriverManager;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AngelFishListPage {

    private Logger logger= LogManager.getRootLogger();


    @FindBy(css = "a.Button[href*='EST-2']")
    private WebElement AddToCartSmallAngelfish;

    public AngelFishListPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    @Step("Clic on Add to Cart Small Angelfish")
    public ShoppingCardPage clickOnAddToCartSmallAngelfish(){
        AddToCartSmallAngelfish.click();
        logger.info("Clicked on Add To Cart Small Angelfish");
        return new ShoppingCardPage();
    }


}
