package page.objects;

import driver.manager.DriverManager;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class TopMenuPage extends BasePage {

    @FindBy(css = "a[href*=signon]")
    private WebElement singOnLink;

    public TopMenuPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    @Step("Click on Sing In Link")
    public LoginPage clickOnSingInLink() {
        WaitForElement.waitUntilElementIsClickable(singOnLink);
        singOnLink.click();
        log().info("Clicked on Sing On Link");
        return new LoginPage();
    }
}
