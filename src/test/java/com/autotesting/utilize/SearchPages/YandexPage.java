package com.autotesting.utilize.SearchPages;

import com.autotesting.utilize.PerformanceLabPages.PFLBHomePage;
import com.autotesting.utilize.Setting.SettingDriver;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class YandexPage extends SearchPage {

    private final String url = "https://yandex.ru";

    public YandexPage(){
        this.name = "Yandex";
        SettingDriver.openUrl(url);
    }

    @FindBy(id = "text")
    private WebElement input;

    //Первый вариант li.serp-item h2 a
    @FindBy(css = "ul[aria-label*=\"Результаты поиска\"] h2 a")
    private List<WebElement> results;

    /**
     * Search value in Yandex
     */
    @Override
    public YandexPage search(String value) throws TimeoutException{
        SettingDriver.setTimeWait(5, input);
        input.sendKeys(value);
        input.submit();
        return this;
    }

    /**
     * Click on first result in Yandex
     */
    public PFLBHomePage clickResult(int numberResult) throws TimeoutException, NoSuchElementException{
        if(numberResult < 0 || numberResult > results.size())
            throw new IndexOutOfBoundsException("Index out");
        SettingDriver.setTimeWait(5, results.get(0));
        results.get(numberResult - 1).click();
        SettingDriver.switchTabToLast();
        return new PFLBHomePage();
    }
}
