package tests;


import driver.manager.DriverUtilites;
import navigation.ApplicationURLs;

import org.testng.annotations.Test;
import page.objects.LoginPage;

import static org.testng.Assert.assertEquals;

public class FailedLoginTests extends TestBase {
    @Test
    public void anUserTryToLoginWithIncorrectUsernameAndPassword() {
        DriverUtilites.navigateToPage(ApplicationURLs.LOGIN_URL);

        LoginPage loginPage = new LoginPage();
        loginPage.typeIntoUserNameField("NotExistingLogin");
        loginPage.typeIntoPasswordField("NotProperPassword");
        loginPage.clickOnLoginButton();


        assertEquals(loginPage.getWarningMessage(), "Invalid username or password. Signon failed.");
    }
}
