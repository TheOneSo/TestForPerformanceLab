package com.autotesting.utilize.SearchPages;

import com.autotesting.utilize.PerformanceLabPages.PFLBHomePage;
import com.autotesting.utilize.Setting.SettingDriver;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GooglePage extends SearchPage {

    private final String url = "https://google.com";

    public GooglePage(){
        SettingDriver.openUrl(url);
        this.name = "Google";
    }

    @FindBy(id = "lst-ib")
    private WebElement input;

    @FindBy(css = "#search h3 a")
    private List<WebElement> results;

    /**
     * Search value in Google
     */
    @Override
    public GooglePage search(String value) throws TimeoutException, NoSuchElementException{
            SettingDriver.setTimeWait(5, input);
            input.sendKeys(value);
            input.submit();
            return this;
    }

    /**
     * Click on first result in Google
     */
    @Override
    public PFLBHomePage clickResult(int numberResult) throws TimeoutException, NoSuchElementException{
            if(numberResult < 0 || numberResult > results.size())
                throw new IndexOutOfBoundsException("Index out");
            SettingDriver.setTimeWait(5, results.get(0));
            results.get(numberResult - 1).click();
            SettingDriver.switchTabToLast();
            return new PFLBHomePage();
    }
}
