package com.data.PerformanceLabPages;

import com.data.BasePage;
import com.data.Setting.SettingDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class PFLBHomePage extends BasePage {

    @FindBy(css = "li#menu-item-317 a")
    private WebElement Services;

    @FindBy(css = "div.one_item_menu a[href*=\"ru/software-testing\"]")
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

    public boolean isDisplayedServices(){
        return Services.isDisplayed();
    }

    public boolean isDisplayedTesting(){
        return Testing.isDisplayed();
    }
}
