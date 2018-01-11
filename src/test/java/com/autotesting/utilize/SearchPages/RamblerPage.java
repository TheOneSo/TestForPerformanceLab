package com.autotesting.utilize.SearchPages;

import com.autotesting.utilize.PerformanceLabPages.PFLBHomePage;
import com.autotesting.utilize.Setting.SettingDriver;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RamblerPage extends SearchPage {

    public final String Url = "https://rambler.ru";

    public RamblerPage(){
        super();
        SettingDriver.openUrl(Url);
    }

    @FindBy(css = "input.c07")
    private WebElement Input;

    //Первый вариант div.b-serp-item h2 a
    @FindBy(css = "div.l-content__results h2 a")
    private List<WebElement> Results;


    /**
     * Search value in Rambler
     * Click 'Enter' emulation
     */
    @Override
    public RamblerPage search(String value) throws TimeoutException{
        SettingDriver.setTimeWait(5, Input);
        Input.sendKeys(value + "\n");
        //Input.submit();
        return this;
    }

    /**
     * Switch to new tab
     * Click on first result in Rambler
     */
    public PFLBHomePage clickResult(int numberResult) throws TimeoutException{
        SettingDriver.switchTabToLast();
        SettingDriver.setTimeWait(5, Results.get(0));
        Results.get(numberResult - 1).click();
        SettingDriver.switchTabToLast();
        return new PFLBHomePage();
    }
}
