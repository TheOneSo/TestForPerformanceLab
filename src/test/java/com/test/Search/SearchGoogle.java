package com.test.Search;

import com.test.BaseClass;
import com.test.Setting;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchGoogle extends BaseClass {

    public SearchGoogle(){
        PageFactory.initElements(Setting.getDriver(), this);
    }

    @FindBy(css = "input.gsfi")
    private WebElement Input;

    @FindBy(css = "div.g h3.r a")
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
