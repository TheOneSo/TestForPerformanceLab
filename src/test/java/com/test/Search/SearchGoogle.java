package com.test.Search;

import com.test.Setting;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchGoogle {

    public SearchGoogle(){
        PageFactory.initElements(Setting.getDriver(), this);
    }

    @FindBy(css = "input.gsfi")
    private WebElement Input;

    @FindBy(css = "div.g h3.r a")
    private WebElement PathToPerformanceSite;

    public void search(String text){
        Input.sendKeys(text);
        Input.submit();
    }

    public void clickSite(){
        Setting.switchTabToLast();
        PathToPerformanceSite.click();
        Setting.switchTabToLast();
    }
}
