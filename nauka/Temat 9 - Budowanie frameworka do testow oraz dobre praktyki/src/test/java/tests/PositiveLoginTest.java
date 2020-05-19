package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.objects.FooterPage;
import page.objects.LandingPage;
import page.objects.LoginPage;
import page.objects.TopMenuPage;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class PositiveLoginTest extends TestBase {

    @Test
    public void andUserTryToLoginWithValidUsernameAndPassword() {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickOnEnterStoreLink();

        TopMenuPage topMenuPage = new TopMenuPage(driver);
        topMenuPage.clickOnSingInLink();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoUserNameField("j2ee");
        loginPage.typeIntoPasswordField("j2ee");
        loginPage.clickOnSignOnButton();

        FooterPage footerPage = new FooterPage(driver);
        assertTrue(footerPage.isBannerAfterLoginDisplayed());
    }
}
