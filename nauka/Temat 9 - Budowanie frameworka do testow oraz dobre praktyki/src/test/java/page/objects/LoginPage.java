package page.objects;

import driver.manager.DriverManager;
<<<<<<< HEAD
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
=======
import org.openqa.selenium.WebDriver;
>>>>>>> parent of a890003... Add exercise 9.3
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

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

    public void typeIntoUserNameField(String username) {
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    public void typeIntoPasswordField(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

<<<<<<< HEAD
    public void clickOnLoginButton() {
        loginOnButton.click();
        logger.info("Clicked on Sing On Button");
=======
    public void clickOnSignOnButton() {
        singOnButton.click();
>>>>>>> parent of a890003... Add exercise 9.3
    }

    public String getWarningMessage() {
        String warningMessage = messageLabel.getText();
        return warningMessage;
    }

    public void clickOnFishLink() {
        fishLink.click();
    }
}
