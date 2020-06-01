package driver.manager;

import io.qameta.allure.Step;

import java.util.concurrent.TimeUnit;

public class DriverUtilites {

    @Step("Maxmizing browser window")
    public static void setInitialConfiguration(){
        DriverManager.getWebDriver().manage().window().maximize();
    }

    @Step("Navigatiing to URL: {pageUrl}")
    public static void navigateToPage(String pageUrl){
        DriverManager.getWebDriver().navigate().to(pageUrl);
    }
}
