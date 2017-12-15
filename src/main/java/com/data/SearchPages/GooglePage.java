package com.data.SearchPages;

import com.data.BasePage;
import com.data.PerformanceLabPages.PFLBHomePage;
import com.data.Setting.SettingDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GooglePage extends BasePage {

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

    public boolean isDisplayedInput(){
        return Input.isDisplayed();
    }

    public boolean isDisplayedPathToFirstResult(){
        return PathToFirstResult.isDisplayed();
    }
}
