package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;


public class LoginPage {
    private Logger logger = LogManager.getRootLogger();

    @FindBy(name = "username")
    private WebElement usernameField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(name = "signon")
    private WebElement singOnButton;

    @FindBy(className = "messages")
    private WebElement messageLabel;

    @FindBy(css = "#SidebarContent img[src *='fish']")
    private WebElement fishLink;


    public LoginPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public void typeIntoUserNameField(String username) {
        WaitForElement.waitUntilElementIsVisible(usernameField);
        usernameField.clear();
        usernameField.sendKeys(username);
        logger.info("typed into User Name Field{}");

    }

    public void typeIntoPasswordField(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
        logger.info("Typed into Password Field {}");
    }

    public void clickOnSignOnButton() {
        singOnButton.click();
        logger.info("Clicked on Sing On Button");
    }

    public String getWarningMessage() {
        WaitForElement.waitUntilElementIsVisible(messageLabel);
        String warningMessage = messageLabel.getText();
        logger.info("Returned warning massage is: ", warningMessage);
        return warningMessage;
    }

    public void clickOnFishLink() {
        WaitForElement.waitUntilElementIsClickable(fishLink);
        fishLink.click();
    }
}
