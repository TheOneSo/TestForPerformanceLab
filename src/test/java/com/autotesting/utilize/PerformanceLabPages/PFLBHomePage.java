package com.autotesting.utilize.PerformanceLabPages;

import com.autotesting.utilize.BasePage;
import com.autotesting.utilize.Setting.SettingDriver;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.sql.Time;

public class PFLBHomePage extends BasePage {

    @FindBy(css = "li#menu-item-317 a")
    private WebElement Services;

    @FindBy(css = "div.container > li.menu-item-957 > a")
    private WebElement Testing;

    public String NamePage = "Перфоманс Лаб - Услуги по тестированию программного обеспечения";

    public PFLBHomePage(){
        super();
    }

    /**
     * Navigate to Services in dropdown menu
     * With using Actions
     */
    public PFLBHomePage moveToServicesInDropdownMenu(){
        new Actions(SettingDriver.getChromeDriver()).moveToElement(Services).build().perform();
        return this;
    }

    /**
     * Click on specific link (Testing)
     */
    public PFLBTestingPage clickTesting(){
        Testing.click();
        return new PFLBTestingPage();
    }

    public boolean isDisplayedServices() throws TimeoutException{
        return Services.isDisplayed();
    }

    public boolean isDisplayedTesting() throws TimeoutException{
        return Testing.isDisplayed();
    }
}
