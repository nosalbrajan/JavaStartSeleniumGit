package tests;


import driver.manager.DriverUtilites;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.TmsLink;
import navigation.ApplicationURLs;

import org.testng.annotations.Test;
import page.objects.LandingPage;
import page.objects.LoginPage;
import page.objects.TopMenuPage;
import utilis.testng.listeners.RetryAnalyzer;

import static org.testng.Assert.assertEquals;

public class FailedLoginTests extends TestBase {

    @TmsLink("ID-1")
    @Severity(SeverityLevel.NORMAL)
    @Test(retryAnalyzer = RetryAnalyzer.class)
    @Description("The goal of this test is to log in suing not proper username and password" +
            "and check if warning message Invalid username or password is displayed")
    public void anUserTryToLoginWithIncorrectUsernameAndPassword() {
        DriverUtilites.navigateToPage(ApplicationURLs.LOGIN_URL);

        LoginPage loginPage = new LoginPage();
        loginPage
                .typeIntoUserNameField("NotExistingLogin")
                .typeIntoPasswordField("NotProperPassword")
                .clickOnLoginButton();

        loginPage.assertThatWarningIsDisplayed("Invalid username or password. Signon failed.");
    }
}
