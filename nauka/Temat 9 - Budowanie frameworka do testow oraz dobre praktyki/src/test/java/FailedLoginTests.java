import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FailedLoginTests {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "D:\\JavaStartSelenium\\chromedriver81.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://przyklady.javastart.pl/jpetstore/");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void anUserTryToLoginWithIncorrectUsernameAndPassword() {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickOnEnterStoreLink();

        TopMenuPage topMenuPage = new TopMenuPage(driver);
        topMenuPage.clickOnSingInLink();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoUserNameField("Login1");
        loginPage.typeIntoPasswordField("Password1");
        loginPage.clickOnSignOnButton();
        loginPage.getWarningMessage();

        assertEquals(loginPage.getWarningMessage(), "Invalid username or password. Signon failed.");
    }

    @AfterMethod
    public void afterMethod() {
        driver.close();
        driver.quit();
    }
}
