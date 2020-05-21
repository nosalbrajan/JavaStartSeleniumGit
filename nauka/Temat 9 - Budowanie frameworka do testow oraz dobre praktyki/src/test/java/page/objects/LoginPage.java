package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;


public class LoginPage {
    private Logger logger = LogManager.getLogger();

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

    public LoginPage typeIntoUserNameField(String username) {
        WaitForElement.waitUntilElementIsVisible(usernameField);
        usernameField.clear();
        usernameField.sendKeys(username);
        logger.info("Typed into User Name Field {}", username);
        return this;
    }

    public LoginPage typeIntoPasswordField(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
        logger.info("Typed into Password Field {}", password);
        return this;
    }

    public FooterPage  clickOnLoginButton() {
        loginOnButton.click();
        logger.info("Clicked on Login Button");
        return new FooterPage();
    }

    public String getWarningMessage() {
        WaitForElement.waitUntilElementIsVisible(messageLabel);
        String warningMessage = messageLabel.getText();
        logger.info("Returned warning message was: {}", warningMessage);
        return warningMessage;
    }

    public FishListPage clickOnFishLink() {
        fishLink.click();
        return  new FishListPage();
    }
}
