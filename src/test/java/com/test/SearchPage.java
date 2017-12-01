package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {

    private final WebDriver Driver;

    private WebElement Element;
    private By Input;
    private By Site;
    private String Rambler = "performance lab — Рамблер/поиск";

    public SearchPage(WebDriver driver, By input, By site){
        this.Driver = driver;
        this.Input = input;
        this.Site = site;
    }

    public SearchPage typeInput(String text){
        Driver.findElement(Input).sendKeys(text);
        return this;
    }

    public SearchPage submitButton(){
        Element = Driver.findElement(Input);
        Element.submit();
        return this;
    }

    public SearchPage clickSite(){
        Element = Driver.findElement(Site);
        Element.click();
        return this;
    }
}
