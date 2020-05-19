package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

    @FindBy(name = "username")
    private WebElement usernameField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(name = "signon")
    private WebElement singOnButton;

    @FindBy(className = "messages")
    private WebElement messageLabel;

    @FindBy(css = "#SidebarContent img[src *='fish']")
    private WebElement fishObject;


    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void typeIntoUserNameField(String username) {
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    public void typeIntoPasswordField(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickOnSignOnButton() {
        singOnButton.click();
    }

    public String getWarningMessage() {
        String warningMessage = messageLabel.getText();
        return warningMessage;
    }

    public void clickOnFishLink(){
        fishObject.click();
    }
}
