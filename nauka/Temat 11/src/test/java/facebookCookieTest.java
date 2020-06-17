import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.Set;

import static org.testng.Assert.*;

public class facebookCookieTest {

    WebDriver driver;
    private static WebElement facebookEmailField;
    private static WebElement allegroEmailField;
    private final String ALLEGRO_URL="https://allegro.pl/login/form?authorization_uri=https:%2F%2Fallegro.pl%2Fauth%2Foauth%2Fauthorize%3Fclient_id%3Dtb5SFf3cRxEyspDN%26redirect_uri%3Dhttps:%2F%2Fallegro.pl%2Flogin%2Fauth%3Forigin_url%253D%25252F%26response_type%3Dcode%26state%3DOCP4p2&oauth=true";
    private final String FACEBOOK_URL="http://www.facebook.com";

    @Test
    public void login_state_should_be_restored() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");

        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver,10);

        //Facebook->

        driver.get(FACEBOOK_URL);
        driver.findElement(By.id("email")).sendKeys("login");
        driver.findElement(By.id("pass")).sendKeys("password");
        driver.findElement(By.cssSelector("[value='Zaloguj się']")).click();

        Thread.sleep(3000);
        //Before closing the browser, read the cookies
        Set<Cookie> allCookiesFromFB = driver.manage().getCookies();
        System.out.println(allCookiesFromFB.toString());

        driver.manage().deleteAllCookies();

        driver.navigate().refresh();

        //Allegro->
        driver.navigate().to(ALLEGRO_URL);
        Thread.sleep(2000);

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("[data-role='accept-consent']"))));
        driver.findElement(By.cssSelector("[data-role='accept-consent']")).click();

        driver.findElement(By.id("username")).sendKeys("login");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.cssSelector("[id='login-button']")).click();

        driver.navigate().to("https://allegro.pl/");

        Set<Cookie> allCookiesFromAllegro = driver.manage().getCookies();
        System.out.println(allCookiesFromAllegro.toString());


        driver.manage().deleteAllCookies();

        Thread.sleep(5000);

        driver.navigate().to("https://allegro.pl/");

        //restore from FB
        Thread.sleep(3000);

        driver.navigate().to(FACEBOOK_URL);

        for (Cookie cookieFB : allCookiesFromFB) {
            driver.manage().addCookie(cookieFB);
            System.out.println(cookieFB.toString());
        }

        Thread.sleep(2000);

        driver.navigate().refresh();

        try{
            facebookEmailField =wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("email"))));
        } catch(NoSuchElementException e){
            System.out.println(e.getMessage());
        }

        //Login page should not be disaplyed
        assertTrue(facebookEmailField ==null);


        //restore from Allegro
        Thread.sleep(3000);

        driver.navigate().to("https://allegro.pl/");

        for (Cookie cookieAll : allCookiesFromAllegro) {
            driver.manage().addCookie(cookieAll);
            System.out.println(cookieAll.toString());
        }

        Thread.sleep(2000);

        driver.navigate().to(ALLEGRO_URL);

        try{
            allegroEmailField =wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("username"))));
        } catch(NoSuchElementException e){
            System.out.println(e.getMessage());
        }

        //Login page should not be disaplyed
        assertTrue(allegroEmailField ==null);



        driver.close();
    }
}

