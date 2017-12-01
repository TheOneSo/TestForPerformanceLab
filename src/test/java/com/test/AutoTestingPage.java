package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AutoTestingPage {

    private String Page = "Автоматизация тестирования | Перфоманс Лаб";
    private final WebDriver Driver;

    private WebElement Element;
    private By ElementText = By.cssSelector("div#primary article div.entry-main");
    private String Text = null;

    public AutoTestingPage(WebDriver driver){
        this.Driver = driver;
        if(!Page.equals(driver.getTitle()))
            throw new IllegalStateException("Это не страница Автоматизации тестирования");
    }

    public String elementText(){
        Element = Driver.findElement(ElementText);
        Text = Element.getText();
        return Text;
    }

    public By getElementText(){return ElementText;}
}
