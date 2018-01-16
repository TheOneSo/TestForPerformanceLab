package com.autotesting.utilize.SearchPages;

import com.autotesting.utilize.PerformanceLabPages.PFLBHomePage;
import com.autotesting.utilize.Setting.SettingDriver;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RamblerPage extends SearchPage {

    public final String url = "https://www.rambler.ru";

    public RamblerPage(){
        this.name = "Rambler";
        SettingDriver.openUrl(url);
    }

    @FindBy(css = "input.c07")
    private WebElement input;

    //Первый вариант div.b-serp-item h2 a
    @FindBy(css = "div.l-content__results h2 a")
    private List<WebElement> results;


    /**
     * Search value in Rambler
     * Click 'Enter' emulation
     */
    @Override
    public RamblerPage search(String value) throws TimeoutException, NoSuchElementException{
        SettingDriver.setTimeWait(5, input);
        input.sendKeys(value + "\n");
        //Input.submit();
        return this;
    }

    /**
     * Switch to new tab
     * Click on first result in Rambler
     */
    public PFLBHomePage clickResult(int numberResult) throws TimeoutException, NoSuchElementException{
        SettingDriver.switchTabToLast();
        if(numberResult < 0 || numberResult > results.size())
            throw new IndexOutOfBoundsException("Index out");
        SettingDriver.setTimeWait(5, results.get(0));
        results.get(numberResult - 1).click();
        SettingDriver.switchTabToLast();
        return new PFLBHomePage();
    }
}
