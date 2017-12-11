package com.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public final class Setting {

    private static WebDriver driver;

    private static ChromeOptions driverSetting(){
        System.setProperty("webdriver.chrome.driver", "/users/oneso/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--kiosk");
        return options;
    }

    public static void setTimeWait(long secondTime){
        driver.manage().timeouts().implicitlyWait(secondTime, TimeUnit.SECONDS);
    }

    public static void goSite(String site){
        driver.get(site);
    }

    public static void closeDriver(){
        driver.quit();
    }

    public static void saveFile(String pathToFile, String fileName, String Text){
        try {
            FileWriter file = new FileWriter(pathToFile + fileName + ".txt", false);
            file.write(Text);
            file.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static WebDriver getDriver(){
        if(driver != null)
            return driver;
        driver = new ChromeDriver(driverSetting());
        return driver;
    }

    public static void switchTabToLast(){
        ArrayList tab = new ArrayList(Setting.getDriver().getWindowHandles());
        if(tab.size() > 0)
            Setting.getDriver().switchTo().window((String) tab.get(tab.size() - 1));
    }

    public static void closeAllTabs(){
        ArrayList tabs = new ArrayList(Setting.getDriver().getWindowHandles());
        int count = tabs.size() - 1;
        while (count > 0){
            Setting.getDriver().close();
            count--;
            Setting.getDriver().switchTo().window((String) tabs.get(count));
        }
    }
}
