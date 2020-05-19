package tests;

import org.testng.annotations.Test;
import page.objects.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ShoppingCartTest extends TestBase {
    @Test
    public void asNotLoggedInUserIShallNotProceedToCheckout() {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickOnEnterStoreLink();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnFishLink();

        FishListPage fishListPage = new FishListPage(driver);
        fishListPage.clickOnAngelFishList();

        AngelFishListPage angelFishLIstPage = new AngelFishListPage(driver);
        angelFishLIstPage.clickOnAddToCartSmallAngelfish();

        ShoppingCardPage shoppingCardPage = new ShoppingCardPage(driver);
        shoppingCardPage.ClickOnProccedToCheckOutButton();

        assertEquals(loginPage.getWarningMessage(), "You must sign on before attempting to check out. " +
                "Please sign on and try checking out again.");
    }
}
