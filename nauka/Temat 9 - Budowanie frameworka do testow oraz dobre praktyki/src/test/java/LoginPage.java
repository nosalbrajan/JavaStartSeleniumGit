import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage {
    @FindBy
     

    private WebDriver driver;

    LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void typeIntoUserNameField(String login) {
        WebElement loginInput = driver.findElement(By.name("username"));
        loginInput.sendKeys(login);
    }

    public void typeIntoPasswordField(String password) {
        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys(password);
    }

    public void clickOnSignOnButton() {
        WebElement signOnButton = driver.findElement(By.cssSelector("input[name=signon]"));
        signOnButton.click();
    }

    public String getWarningMessage() {
        WebElement messageLabel = driver.findElement(By.cssSelector("ul li"));
        String warningMessage = messageLabel.getText();
        return warningMessage;
    }
}
