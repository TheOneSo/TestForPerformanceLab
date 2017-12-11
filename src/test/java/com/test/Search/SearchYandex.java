package com.test.Search;

import com.test.Setting;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchYandex {

    public SearchYandex(){
        PageFactory.initElements(Setting.getDriver(), this);
    }

    @FindBy(css = "input#text")
    private WebElement Input;

    @FindBy(css = "li[class*=\"serp-item\"] a[accesskey*=\"1\"]")
    private WebElement PathToPerformanceSite;

    public void search(String text){
        Input.sendKeys(text);
        Input.submit();
    }

    public void click(){
        PathToPerformanceSite.click();
        Setting.switchTabToLast();
    }
}
