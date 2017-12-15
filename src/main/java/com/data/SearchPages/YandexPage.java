package com.data.SearchPages;

import com.data.BasePage;
import com.data.PerformanceLabPages.PFLBHomePage;
import com.data.Setting.SettingDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YandexPage extends BasePage {

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
    public void search(String value){
        Input.sendKeys(value);
        Input.submit();
    }

    /**
     * Click on first result in Yandex
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
