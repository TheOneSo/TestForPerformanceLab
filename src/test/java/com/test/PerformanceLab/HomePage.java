package com.test.PerformanceLab;

import com.test.Setting;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(css = "ul#nav li#menu-item-317 a")
    private WebElement UpMenu;

    @FindBy(css = "div.one_item_menu a[href*=\"ru/software-testing\"]")
    private WebElement Testing;

    private String Page = "Перфоманс Лаб - Услуги по тестированию программного обеспечения";

    public HomePage(){
        PageFactory.initElements(Setting.getDriver(), this);
        if(!Page.equals(Setting.getDriver().getTitle()))
            throw new IllegalStateException("Это не страница Performance Lab");
    }

    public HomePage clickUpMenu(){
        new Actions(Setting.getDriver()).moveToElement(UpMenu).build().perform();
        return this;
    }

    public HomePage clickTesting(){
        Testing.click();
        return this;
    }
}
