package tests;

import driver.manager.DriverUtilites;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;
import page.objects.*;

import static navigation.ApplicationURLs.APPLICATION_URL;
import static org.testng.Assert.assertEquals;

public class ShoppingCartTests extends TestBase {

    @TmsLink("ID-3")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    @Description("The goal of this test is do shopping without sign on" +
            "and check if warning message about requirement of sign on is displayed")
    public void asNotLoggedInUserIShallNotProceedToCheckout() {
        DriverUtilites.navigateToPage(APPLICATION_URL);

        LandingPage landingPage = new LandingPage();
        landingPage.clickOnEnterStoreLink();

        LoginPage loginPage = new LoginPage();
        loginPage.clickOnFishLink()
                .clickOnAngelFishIdLink()
                .clickOnAddToCartSmallAngelfish()
                .ClickOnProccedToCheckOutButton();

        assertEquals(loginPage.getWarningMessage(), "You must sign on before attempting to check out. " +
                "Please sign on and try checking out again.");
    }
}
