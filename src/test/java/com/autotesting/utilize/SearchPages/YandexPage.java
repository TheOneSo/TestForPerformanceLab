package com.autotesting.utilize.SearchPages;

import com.autotesting.utilize.PerformanceLabPages.PFLBHomePage;
import com.autotesting.utilize.Setting.SettingDriver;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class YandexPage extends SearchPage {

    private final String Url = "https://yandex.ru";

    public YandexPage(){
        super();
        SettingDriver.openUrl(Url);
    }

    @FindBy(id = "text")
    private WebElement Input;

    //Первый вариант li.serp-item h2 a
    @FindBy(css = "ul[aria-label*=\"Результаты поиска\"] h2 a")
    private List<WebElement> Results;

    /**
     * Search value in Yandex
     */
    @Override
    public YandexPage search(String value) throws TimeoutException{
        SettingDriver.setTimeWait(5, Input);
        Input.sendKeys(value);
        Input.submit();
        return this;
    }

    /**
     * Click on first result in Yandex
     */
    public PFLBHomePage clickResult(int numberResult) throws TimeoutException{
        if(numberResult < 0 || numberResult > Results.size())
            throw new IndexOutOfBoundsException("Index out");
        SettingDriver.setTimeWait(5, Results.get(0));
        Results.get(numberResult - 1).click();
        SettingDriver.switchTabToLast();
        return new PFLBHomePage();
    }
}
