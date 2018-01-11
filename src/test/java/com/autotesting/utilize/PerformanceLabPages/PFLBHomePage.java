package com.autotesting.utilize.PerformanceLabPages;

import com.autotesting.utilize.BasePage;
import com.autotesting.utilize.Setting.SettingDriver;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class PFLBHomePage extends BasePage {

    @FindBy(id = "menu-item-317")
    private WebElement Services;

    @FindBy(css = "div.container > li.menu-item-957 > a")
    private WebElement Testing;

    public String NamePage = "Перфоманс Лаб - Услуги по тестированию программного обеспечения";

    public PFLBHomePage(){
        super();
        if(!NamePage.equals(SettingDriver.getChromeDriver().getTitle()))
            throw new IllegalStateException("This is not the PerformanceLab page");
    }

    /**
     * Navigate to Services in dropdown menu
     * With using Actions
     */
    public PFLBHomePage moveToServicesInDropdownMenu() throws TimeoutException{
        SettingDriver.setTimeWait(5, Services);
        new Actions(SettingDriver.getChromeDriver()).moveToElement(Services).build().perform();
        return this;
    }

    /**
     * Click on specific link (Testing)
     */
    public PFLBTestingPage clickTesting() throws TimeoutException{
        SettingDriver.setTimeWait(5, Testing);
        Testing.click();
        return new PFLBTestingPage();
    }
}
