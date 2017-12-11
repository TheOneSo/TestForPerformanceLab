package com.test.Search;

import com.test.Setting;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchRambler {

    public SearchRambler(){
        PageFactory.initElements(Setting.getDriver(), this);
    }

    @FindBy(css = "input[type*=\"text\"]")
    private WebElement Input;

    @FindBy(css = "div.b-serp-item a[onmouseup*=\"title_1'\"]")
    private WebElement PathToPerformanceLab;

    public void search(String text){
        Input.sendKeys(text);
        Input.submit();
    }

    public void click(){
        Setting.switchTabToLast();
        PathToPerformanceLab.click();
        Setting.switchTabToLast();
    }
}
