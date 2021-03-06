import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

import static org.testng.Assert.assertTrue;


public class CookiesTest {

    private static final String LOGIN_URL = "http://przyklady.javastart.pl/jpetstore/actions/Account.action?signonForm=";
    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();

        driver.navigate().to(LOGIN_URL);
    }

    @Test
    public void cookieExampleUsageTest() throws InterruptedException {

        //Wyszukujemy pole UserName i wpisujemy hasło
        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.clear();
        usernameField.sendKeys("j2ee");

        //Wyszukujemy pole Password i wpisujemy hasło
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.clear();
        passwordField.sendKeys("j2ee");

        //Wyszukujemy przycisk Login oraz klikamy w niego
        WebElement loginButton = driver.findElement(By.name("signon"));
        loginButton.click();


        //Po poprawnym zalogowaniu na dole w stopce dostępne jest logo z psem
        WebElement bannerLogoAfterLogin = driver.findElement(By.cssSelector("#Banner img[src*='dog']"));

        //Sprawdzamy czy logo jest wyświetlone
        assertTrue(bannerLogoAfterLogin.isDisplayed());


        //Pobieramy wszystkie pliki cookie
        Set<Cookie> cookiesSet = driver.manage().getCookies();


        Thread.sleep(2000);

        //Usuwamy wszystkie pliki Cookie
        driver.manage().deleteAllCookies();

        //Przechodzimy ponownie do strony logowania
        driver.navigate().to(LOGIN_URL);

        //Na stronie logowania logo z psem nie jest już dostępne, ponieważ usunęliśmy ciasteczko przechowywujące
        // informację na temat tego czy jesteśmy zalogowani.
        // W bloku try-catch próbujemy wyszukać webelement odpowiadający za logo widoczne po zalogowaniu, niestety
        // logo nie jest dostępne. W związku z czym metoda findElement() rzuca wyjątkiem. By móc dalej pracować
        // musimy ten wyjątek złapać.
        try {
            WebElement bannerLogoAfterClearingCookies = driver.findElement(By.cssSelector("#Banner img[src*='dog']"));
            assertTrue(bannerLogoAfterClearingCookies.isDisplayed());
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("Element Dog banner after log in is not displayed!");
        }

        // Po rzuceniu i złapaniu wyjątku dodajemy z powrotem do przeglądarki ciastko odpowiadające za przechowywanie
        // informacji o zalogowanym użytkowniku j2ee
        for (Cookie cookie : cookiesSet) {
            driver.manage().addCookie(cookie);
        }
        //Przechodzimy z powrotem do strony logowania
        driver.navigate().to(LOGIN_URL);


        //Logo z pasem po zalogowaniu znowu jest dostępne. Wynika to z faktu, że w przeglądarce istnieje znowu
        // ciasteczko przechowywujące informację o zalogowanym użytkowniku
        WebElement bannerLogoAfterAddingCookie = driver.findElement(By.cssSelector("#Banner img[src*='dog']"));
        assertTrue(bannerLogoAfterAddingCookie.isDisplayed());
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }

}