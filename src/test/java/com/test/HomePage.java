package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage {

    private String Page = "Перфоманс Лаб - Услуги по тестированию программного обеспечения";
    private final WebDriver Driver;

    private WebElement Element;
    private By UpMenu = By.cssSelector("ul#nav li#menu-item-317 a");
    private By Testing = By.cssSelector("div.one_item_menu a[href*=\"ru/software-testing\"]");

    public HomePage(WebDriver driver){
        this.Driver = driver;
        if(!Page.equals(driver.getTitle()))
            throw new IllegalStateException("Это не страница Performance Lab");
    }

    public HomePage clickUpMenu(){
        Actions build = new Actions(Driver);
        Element = Driver.findElement(UpMenu);
        build.moveToElement(Element).build().perform();
        return this;
    }

    public HomePage clickTesting(){
        Element = Driver.findElement(Testing);
        Element.click();
        return this;
    }

    public By getUpMenuElement(){return UpMenu;}
    public By getTestingElement(){return Testing;}
}
