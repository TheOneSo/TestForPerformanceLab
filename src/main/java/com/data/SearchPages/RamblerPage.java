package com.data.SearchPages;

import com.data.BasePage;
import com.data.Setting.SettingDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RamblerPage extends BasePage {

    public RamblerPage(){
        super();
    }

    @FindBy(css = "input[type*=\"text\"]")
    private WebElement Input;

    @FindBy(css = "div.b-serp-list a")
    private WebElement PathToFirstResult;


    /**
     * Search value in Rambler
     */
    public void search(String value){
        Input.sendKeys(value);
        Input.submit();
    }

    /**
     * Switch to new tab
     * Click on first result in Rambler
     */
    public void clickFirstResult(){
        SettingDriver.switchTabToLast();
        PathToFirstResult.click();
        SettingDriver.switchTabToLast();
    }
}
