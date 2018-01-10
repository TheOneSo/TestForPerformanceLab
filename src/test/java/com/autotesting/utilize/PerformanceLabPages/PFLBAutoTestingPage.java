package com.autotesting.utilize.PerformanceLabPages;

import com.autotesting.utilize.BasePage;
import com.autotesting.utilize.Setting.SettingDriver;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PFLBAutoTestingPage extends BasePage {

    @FindBy(css = "div.entry-main")
    private WebElement ElementText;

    public String NamePage = "Автоматизация тестирования | Перфоманс Лаб";

    public PFLBAutoTestingPage(){
        super();
        if(!NamePage.equals(SettingDriver.getChromeDriver().getTitle()))
            throw new IllegalStateException("This is not the autotesting page");
    }

    /**
     * Get text on the page and return
     */
    public String getText() throws TimeoutException{
        return ElementText.getText();
    }
}
