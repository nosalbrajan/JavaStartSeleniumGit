import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class SecondAutomatedTest {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "D:\\JavaStartSelenium\\chromedriver81.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://przyklady.javastart.pl/test/full_form.html");
    }

    @Test
    public void testCase1() {
        sleep();
        WebElement inputUsername = driver.findElement(By.name("username"));
        inputUsername.sendKeys("Selenium Start");

        String outputUsernameValue = inputUsername.getAttribute("value");
        assertEquals(outputUsernameValue, "Selenium Start");
        sleep();
    }

    @Test
    public void filePickingTest() {
        sleep();
        WebElement uploadFile = driver.findElement(By.id("upload_file"));
        uploadFile.sendKeys("D:\\zdjecia aut bez resize\\00001.jpg");
        sleep();
        String output = uploadFile.getAttribute("value");
        System.out.println(output);
    }

    @Test
    public void typingAndClearingValueInsideWebElementTest() {
        sleep();
        WebElement inputUsername = driver.findElement(By.name("username"));
        inputUsername.sendKeys("Selenium Start");

        String outputUsernameValue = inputUsername.getAttribute("value");
        assertEquals(outputUsernameValue, "Selenium Start");
        sleep();

        inputUsername.clear();
        sleep();
        String emptyUserNewField = inputUsername.getAttribute("value");
        assertEquals(emptyUserNewField, "");
    }

    @Test
    public void checkRadioButton() {
        sleep();
        WebElement maleRadioButton = driver.findElement(By.cssSelector("input[value='male']"));
        WebElement femaleRadioButton = driver.findElement(By.cssSelector("input[value='female']"));
        femaleRadioButton.click();
        sleep();

        assertTrue(femaleRadioButton.isSelected());
        assertFalse(maleRadioButton.isSelected());
        sleep();

        maleRadioButton.click();
        assertFalse(femaleRadioButton.isSelected());
        assertTrue(maleRadioButton.isSelected());
        sleep();
    }

    @Test
    public void checkboxButtonsTest() {
        sleep();
        WebElement pizzaCheckbox = driver.findElement(By.cssSelector("input[value='pizza']"));
        WebElement spaghettiCheckbox = driver.findElement(By.cssSelector("input[value='spaghetti'"));
        WebElement hamburgerCheckbox = driver.findElement(By.cssSelector("input[value='hamburger'"));

        pizzaCheckbox.click();

        assertTrue(pizzaCheckbox.isSelected());
        assertFalse(spaghettiCheckbox.isSelected());
        assertFalse(hamburgerCheckbox.isSelected());

        sleep();

        pizzaCheckbox.click();
        spaghettiCheckbox.click();
        hamburgerCheckbox.click();

        sleep();

        assertFalse(pizzaCheckbox.isSelected());
        assertTrue(spaghettiCheckbox.isSelected());
        assertTrue(hamburgerCheckbox.isSelected());
    }

    @Test
    public void dropDownListingTest() {
        sleep();
        WebElement countryWebElement = driver.findElement(By.id("country"));
        Select countryDropDown = new Select(countryWebElement);

        List<WebElement> options = countryDropDown.getOptions();
        List<String> optionNames = new ArrayList<String>();

        for (int i = 0; i < options.size(); i++) {
            optionNames.add(options.get(i).getText());
            System.out.println(optionNames.get(i));
        }

        List<String> expectedCountryNames = new ArrayList<String>();
        expectedCountryNames.add("Germany");
        expectedCountryNames.add("Poland");
        expectedCountryNames.add("UK");

        assertEquals(optionNames, expectedCountryNames);

        countryDropDown.selectByValue("pl_PL");
        String actualCountry = countryDropDown.getFirstSelectedOption().getText();
        sleep();

        assertEquals(actualCountry, "Poland");

        countryDropDown.selectByIndex(0);
        assertFalse(countryDropDown.getFirstSelectedOption().getText().equals("Poland"));
        assertEquals(countryDropDown.getFirstSelectedOption().getText(), "Germany");
        sleep();
    }

    @Test
    public void checkElementsOnPageTest() {
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement emailLabel = driver.findElement(By.cssSelector("span[class='help-block'"));

        System.out.println("username is enabled : " + username.isEnabled());
        System.out.println("username is displayed : " + username.isDisplayed());
        System.out.println("password is enabled : " + password.isEnabled());
        System.out.println("password is displayed : " + password.isDisplayed());
        System.out.println("emailLabel is enabled : " + emailLabel.isEnabled());
        System.out.println("emailLabel is displayed : " + emailLabel.isDisplayed());
    }

    @AfterMethod
    public void afterMethod() {
        driver.close();
        driver.quit();
    }

    public void sleep() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
