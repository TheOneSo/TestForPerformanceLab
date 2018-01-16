package com.autotesting.utilize.PerformanceLabPages;

import com.autotesting.utilize.BasePage;
import com.autotesting.utilize.Setting.SettingDriver;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PFLBAutoTestingPage extends BasePage {

    @FindBy(id = "post-124")
    private WebElement elementText;

    public PFLBAutoTestingPage(){
        this.namePage = "Автоматизация тестирования | Перфоманс Лаб";
        if(!namePage.equals(SettingDriver.getChromeDriver().getTitle()))
            throw new IllegalStateException("This is not the autotesting page");
    }

    /**
     * Get text on the page and return
     */
    public String getText() throws TimeoutException{
        SettingDriver.setTimeWait(5, elementText);
        return elementText.getText();
    }
}
