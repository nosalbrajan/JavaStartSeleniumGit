package tests;

import driver.manager.DriverUtilites;
import navigation.ApplicationURLs;
import org.testng.annotations.Test;
import page.objects.FooterPage;
import page.objects.LoginPage;

import static org.testng.Assert.assertTrue;

public class PositiveLoginTest extends TestBase {

    @Test
    public void andUserTryToLoginWithValidUsernameAndPassword() {
        DriverUtilites.navigateToPage(ApplicationURLs.LOGIN_URL);

        LoginPage loginPage = new LoginPage();
        loginPage.typeIntoUserNameField("j2ee");
        loginPage.typeIntoPasswordField("j2ee");
        loginPage.clickOnLoginButton();

        FooterPage footerPage = new FooterPage();
        assertTrue(footerPage.isBannerAfterLoginDisplayed());
    }
}
