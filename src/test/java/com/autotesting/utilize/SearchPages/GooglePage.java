package com.autotesting.utilize.SearchPages;

import com.autotesting.utilize.PerformanceLabPages.PFLBHomePage;
import com.autotesting.utilize.Setting.SettingDriver;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GooglePage extends SearchPage {

    private final String Url = "https://google.com";

    public GooglePage(){
        super();
        SettingDriver.openUrl(Url);
    }

    @FindBy(id = "lst-ib")
    private WebElement Input;

    @FindBy(css = "#search h3 a123")
    private List<WebElement> Results;

    /**
     * Search value in Google
     */
    @Override
    public GooglePage search(String value) throws TimeoutException{
        SettingDriver.setTimeWait(5, Input);
        Input.sendKeys(value);
        Input.submit();
        return this;
    }

    /**
     * Click on first result in Google
     */
    public PFLBHomePage clickResult(int NumberResult) throws TimeoutException{
        SettingDriver.setTimeWait(5, Results.get(0));
        Results.get(NumberResult - 1).click();
        SettingDriver.switchTabToLast();
        return new PFLBHomePage();
    }
}
