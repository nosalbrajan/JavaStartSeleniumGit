package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AngelFishListPage {
    WebDriver driver;


    @FindBy(css = "a.Button[href*='EST-2']")
    private WebElement AddToCartSmallAngelfish;

    public AngelFishListPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void clickOnAddToCartSmallAngelfish(){
        AddToCartSmallAngelfish.click();
    }


}
