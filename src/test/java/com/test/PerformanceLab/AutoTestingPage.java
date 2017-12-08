package com.test.PerformanceLab;

import com.test.Setting;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AutoTestingPage {

    @FindBy(css = "div#primary article div.entry-main")
    private WebElement ElementText;

    private String Page = "Автоматизация тестирования | Перфоманс Лаб";
    private String Text = null;

    public AutoTestingPage(){
        PageFactory.initElements(Setting.getDriver(), this);
        if(!Page.equals(Setting.getDriver().getTitle()))
            throw new IllegalStateException("Это не страница Автоматизации тестирования");
    }

    public String elementText(){
        return ElementText.getText();
    }
}
