package com.autotesting.utilize.PerformanceLabPages;

import com.autotesting.utilize.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PFLBAutoTestingPage extends BasePage {

    @FindBy(css = "div.entry-main")
    private WebElement ElementText;

    public String NamePage = "Автоматизация тестирования | Перфоманс Лаб";

    public PFLBAutoTestingPage(){
        super();
    }

    /**
     * Get text on the page and return
     */
    public String getText(){
        return ElementText.getText();
    }
}
