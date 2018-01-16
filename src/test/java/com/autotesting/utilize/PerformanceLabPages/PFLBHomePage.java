package com.autotesting.utilize.PerformanceLabPages;

import com.autotesting.utilize.BasePage;
import com.autotesting.utilize.Setting.SettingDriver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class PFLBHomePage extends BasePage {

    @FindBy(id = "menu-item-317")
    private WebElement services;

    @FindBy(css = "div.container > li.menu-item-957 > a")
    private WebElement testing;

    public PFLBHomePage(){
        this.namePage = "Перфоманс Лаб - Услуги по тестированию программного обеспечения";
        if(!namePage.equals(SettingDriver.getChromeDriver().getTitle()))
            throw new IllegalStateException("This is not the PerformanceLab page");
    }

    /**
     * Navigate to Services in dropdown menu
     * With using Actions
     */
    public PFLBHomePage moveToServicesInDropdownMenu() throws TimeoutException, NoSuchElementException{
        SettingDriver.setTimeWait(5, services);
        new Actions(SettingDriver.getChromeDriver()).moveToElement(services).build().perform();
        return this;
    }

    /**
     * Click on specific link (Testing)
     */
    public PFLBTestingPage clickTesting() throws TimeoutException, NoSuchElementException{
        SettingDriver.setTimeWait(5, testing);
        testing.click();
        return new PFLBTestingPage();
    }
}
