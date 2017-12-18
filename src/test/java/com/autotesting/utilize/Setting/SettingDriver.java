package com.autotesting.utilize.Setting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public final class SettingDriver {

    private static WebDriver driver;
    private WebDriverWait Wait;

    /**
     * Create or return ChromeDriver
     */
    public static WebDriver getChromeDriver(){
        if(driver != null)
            return driver;
        System.setProperty("webdriver.chrome.driver", "/users/oneso/chromedriver");
        driver = new ChromeDriver(getChromeOptions());
        return driver;
    }

    /**
     * Setting full screen browser
     */
    private static ChromeOptions getChromeOptions(){
        return new ChromeOptions().addArguments("--kiosk");
    }

    /**
     * Set global time wait in second
     */
    public static void setGlobalTimeWait(long secondTime){
        getChromeDriver().manage().timeouts().implicitlyWait(secondTime, TimeUnit.SECONDS);
    }

    /**
     * Open first page in browser
     */
    public static void openUrl(String url){
        getChromeDriver().get(url);
    }

    /**
     * Close browser and driver
     */
    public static void closeDriver(){
        getChromeDriver().quit();
    }

    /**
     * Set Time wait in second
     */
    public void setTimeWait(long secondTime){
        Wait = new WebDriverWait(getChromeDriver(), secondTime);
    }

    /**
     * Switch tab to last tab
     */
    public static void switchTabToLast(){
        ArrayList tab = new ArrayList(SettingDriver.getChromeDriver().getWindowHandles());
        if(tab.size() > 0)
            SettingDriver.getChromeDriver().switchTo().window((String) tab.get(tab.size() - 1));
    }

    /**
     * Close all tabs except first tab
     */
    public static void closeAllTabsExceptFirst(){
        ArrayList tabs = new ArrayList(SettingDriver.getChromeDriver().getWindowHandles());
        int count = tabs.size() - 1;
        while (count > 0){
            SettingDriver.getChromeDriver().close();
            count--;
            SettingDriver.getChromeDriver().switchTo().window((String) tabs.get(count));
        }
    }
}
