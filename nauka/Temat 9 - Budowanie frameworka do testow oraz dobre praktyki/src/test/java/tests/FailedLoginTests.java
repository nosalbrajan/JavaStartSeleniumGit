package tests;


import driver.manager.DriverUtilites;
import navigation.ApplicationURLs;

import org.testng.annotations.Test;
import page.objects.LandingPage;
import page.objects.LoginPage;
import page.objects.TopMenuPage;

import static org.testng.Assert.assertEquals;

public class FailedLoginTests extends TestBase {
    @Test
    public void anUserTryToLoginWithIncorrectUsernameAndPassword() {
        LandingPage landingPage = new LandingPage();
        landingPage
                .clickOnEnterStoreLink()
                .clickOnSingInLink()
                .typeIntoUserNameField("NotExistingLogin")
                .typeIntoPasswordField("NotProperPassword")
                .clickOnLoginButton();

        LoginPage loginPage = new LoginPage();
        assertEquals(loginPage.getWarningMessage(), "Invalid username or password. Signon failed.");
    }
}
