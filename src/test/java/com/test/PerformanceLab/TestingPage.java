package com.test.PerformanceLab;

import com.test.BaseClass;
import com.test.Setting;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestingPage extends BaseClass {

    @FindBy(css = "div.col-md-4 li a[href*=\"avtomatizacija\"]")
    private WebElement AutoTesting;

    private String Page = "Тестирование программного обеспечения - Перфоманс Лаб";

    public TestingPage(){
        PageFactory.initElements(Setting.getDriver(), this);
        if(!Page.equals(Setting.getDriver().getTitle()))
            throw new IllegalStateException("Это не страница услуги по тестированию");
    }

    @Override
    public void click(){
        AutoTesting.click();
    }
}
