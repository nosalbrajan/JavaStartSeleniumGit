package page.objects;

import driver.manager.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AngelFishListPage {


    @FindBy(css = "a.Button[href*='EST-2']")
    private WebElement AddToCartSmallAngelfish;

    public AngelFishListPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }


    public void clickOnAddToCartSmallAngelfish(){
        AddToCartSmallAngelfish.click();
    }


}
