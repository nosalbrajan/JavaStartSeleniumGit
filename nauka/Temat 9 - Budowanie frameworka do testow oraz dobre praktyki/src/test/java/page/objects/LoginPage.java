package page.objects;

import driver.manager.DriverManager;
import generic.assertions.AssertWebElement;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;


public class LoginPage extends BasePage {

    @FindBy(name = "username")
    private WebElement usernameField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(name = "signon")
    private WebElement loginOnButton;

    @FindBy(className = "messages")
    private WebElement messageLabel;

    @FindBy(css = "#SidebarContent img[src *='fish']")
    private WebElement fishLink;


    public LoginPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    @Step("Type into User Name Field: {username}")
    public LoginPage typeIntoUserNameField(String username) {
        WaitForElement.waitUntilElementIsVisible(usernameField);
        usernameField.clear();
        usernameField.sendKeys(username);
        log().info("Typed into User Name Field {}", username);
        return this;
    }

    @Step("Type into Password Field: {password}")
    public LoginPage typeIntoPasswordField(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
        log().info("Typed into Password Field {}", password);
        return this;
    }

    @Step("Click on Login Button")
    public FooterPage clickOnLoginButton() {
        loginOnButton.click();
        log().info("Clicked on Login Button");
        return new FooterPage();
    }

    @Step("Assert that warning message {warningMessage} is displayed")
    public LoginPage assertThatWarningIsDisplayed(String warningMessage) {
        log().info("Checking if warning message {} is displayed", warningMessage);
        WaitForElement.waitUntilElementIsVisible(messageLabel);
        AssertWebElement.assertThat(messageLabel).isDisplayed().hasText(warningMessage);
        return this;
    }

    public FishListPage clickOnFishLink() {
        fishLink.click();
        return new FishListPage();
    }
}
