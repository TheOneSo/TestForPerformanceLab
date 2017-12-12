package com.test;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class BaseClass {

    WebElement element;

    public BaseClass(){
        PageFactory.initElements(Setting.getDriver(), this);
    }

    public void click(){
        element.click();
    }

    public void search(String text){
        element.sendKeys(text);
    }

    public String getText(){
        return element.getText();
    }
}
