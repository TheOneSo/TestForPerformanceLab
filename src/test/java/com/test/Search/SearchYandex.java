package com.test.Search;

import com.test.BaseClass;
import com.test.Setting;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchYandex extends BaseClass {

    public SearchYandex(){
        PageFactory.initElements(Setting.getDriver(), this);
    }

    @FindBy(css = "input#text")
    private WebElement Input;

    @FindBy(css = "li[class*=\"serp-item\"] a[accesskey*=\"1\"]")
    private WebElement PathToPerformanceSite;

    @Override
    public void search(String text){
        Input.sendKeys(text);
        Input.submit();
    }

    @Override
    public void click(){
        PathToPerformanceSite.click();
        Setting.switchTabToLast();
    }
}
