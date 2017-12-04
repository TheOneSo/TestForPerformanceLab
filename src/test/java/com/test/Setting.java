package com.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileWriter;
import java.util.concurrent.TimeUnit;

public class Setting {

    private WebDriver driver;

    public void dirverSetting(){
        System.setProperty("webdriver.chrome.driver", "/users/oneso/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--kiosk");
        driver = new ChromeDriver(options);
    }

    public void setTimeWait(long secondTime){
        driver.manage().timeouts().implicitlyWait(secondTime, TimeUnit.SECONDS);
    }

    public void goSite(String site){
        driver.get(site);
    }

    public void closeTabOrDriver(){
        driver.quit();
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

    public WebDriver getDriver() { return driver; }
}
