package tests;

import org.testng.annotations.Test;
import page.objects.*;

import static org.testng.Assert.assertEquals;

public class ShoppingCartTest extends TestBase {

    @Test
    public void asNotLoggedInUserIShallNotProceedToCheckout() {
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
