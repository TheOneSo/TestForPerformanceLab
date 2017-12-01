package com.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Setting {

    public WebDriver dirverSetting(){
        System.setProperty("webdriver.chrome.driver", "/users/oneso/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--kiosk");
        return new ChromeDriver(options);
    }

    public void setTimeWait(WebDriver driver,long secondTime){
        driver.manage().timeouts().implicitlyWait(secondTime, TimeUnit.SECONDS);
    }

    public void goSite(WebDriver driver,String site){
        driver.get(site);
    }

    public void closeTabOrDriver(WebDriver driver){
        driver.quit();
    }

    public void switchToLast(WebDriver driver){
        ArrayList tab = new ArrayList(driver.getWindowHandles());
        if(tab.size() > 0)
            driver.switchTo().window((String) tab.get(tab.size() - 1));
        else
            return;
    }

    public void saveFile(String pathToFile, String fileName, String Text){
        try {
            FileWriter file = new FileWriter(pathToFile + fileName + ".txt", false);
            file.write(Text);
            file.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
