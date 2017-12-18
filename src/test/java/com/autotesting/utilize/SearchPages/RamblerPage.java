package com.autotesting.utilize.SearchPages;

import com.autotesting.utilize.PerformanceLabPages.PFLBHomePage;
import com.autotesting.utilize.Setting.SettingDriver;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RamblerPage extends SearchPage {

    public RamblerPage(){
        super();
    }

    @FindBy(css = "input.c07")
    private WebElement Input;

    @FindBy(css = "div.b-serp-item a[onmouseup*=\"title_1'\"]")
    private WebElement PathToFirstResult;


    /**
     * Search value in Rambler
     */
    @Override
    public RamblerPage search(String value){
        Input.sendKeys(value + "\n");
        //Input.submit();
        return this;
    }

    /**
     * Switch to new tab
     * Click on first result in Rambler
     */
    public PFLBHomePage clickFirstResult(){
        SettingDriver.switchTabToLast();
        PathToFirstResult.click();
        SettingDriver.switchTabToLast();
        return new PFLBHomePage();
    }

    public boolean isDisplayedInput() throws TimeoutException{
        new SettingDriver().setTimeWait(3);
        return Input.isDisplayed();
    }
}
