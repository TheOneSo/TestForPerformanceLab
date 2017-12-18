package com.autotesting.utilize.SearchPages;

import com.autotesting.utilize.PerformanceLabPages.PFLBHomePage;
import com.autotesting.utilize.Setting.SettingDriver;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GooglePage extends SearchPage {

    public GooglePage(){
        super();
    }

    @FindBy(css = "input.gsfi")
    private WebElement Input;

    @FindBy(css = "div#ires a")
    private WebElement PathToFirstResult;

    /**
     * Search value in Google
     */
    @Override
    public GooglePage search(String value){
        Input.sendKeys(value);
        Input.submit();
        return this;
    }

    /**
     * Click on first result in Google
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
