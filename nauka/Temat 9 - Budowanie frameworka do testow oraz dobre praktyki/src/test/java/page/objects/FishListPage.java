package page.objects;

import driver.manager.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class FishListPage {

    @FindBy(css = "a[href*='FI-SW-01']")
    private WebElement angelFishIdLink;


    public FishListPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public void clickOnAngelFishIdLink(){
        WaitForElement.waitUntilElementIsClickable(angelFishIdLink);
        angelFishIdLink.click();
    }

}
