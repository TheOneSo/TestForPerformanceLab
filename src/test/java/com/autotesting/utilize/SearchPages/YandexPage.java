package com.autotesting.utilize.SearchPages;

import com.autotesting.utilize.BasePage;
import com.autotesting.utilize.PerformanceLabPages.PFLBHomePage;
import com.autotesting.utilize.Setting.SettingDriver;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YandexPage extends SearchPage {

    public YandexPage(){
        super();
    }

    @FindBy(css = "input#text")
    private WebElement Input;

    @FindBy(css = "div.main__content a")
    private WebElement PathToFirstResult;

    /**
     * Search value in Yandex
     */
    @Override
    public YandexPage search(String value){
        Input.sendKeys(value);
        Input.submit();
        return this;
    }

    /**
     * Click on first result in Yandex
     */
    public PFLBHomePage clickFirstResult(){
        PathToFirstResult.click();
        SettingDriver.switchTabToLast();
        return new PFLBHomePage();
    }

    public boolean isDisplayedInput() throws TimeoutException{
        return Input.isDisplayed();
    }
}
