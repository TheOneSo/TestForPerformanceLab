package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestingPage {

    private String Page = "Тестирование программного обеспечения - Перфоманс Лаб";
    private final WebDriver Driver;

    private WebElement Element;
    private By AutoTesting = By.cssSelector("div.col-md-4 li a[href*=\"avtomatizacija\"]");

    public TestingPage(WebDriver driver){
        this.Driver = driver;
        if(!Page.equals(driver.getTitle()))
            throw new IllegalStateException("Это не страница услуги по тестированию");
    }

    public TestingPage clickAutoTesting(){
        Element = Driver.findElement(AutoTesting);
        Element.click();
        return this;
    }

    public By getAutoTestingElement(){return AutoTesting;}
}
