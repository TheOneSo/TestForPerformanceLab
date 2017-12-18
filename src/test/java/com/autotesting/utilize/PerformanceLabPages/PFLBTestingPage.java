package com.autotesting.utilize.PerformanceLabPages;

import com.autotesting.utilize.BasePage;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PFLBTestingPage extends BasePage {

    @FindBy(css = "div.col-md-4 a[href*=\"avtomatizacija\"]")
    private WebElement AutoTesting;

    public String NamePage = "Тестирование программного обеспечения - Перфоманс Лаб";

    public PFLBTestingPage(){
        super();
    }

    /**
     * Click on specific link (AT)
     */
    public PFLBAutoTestingPage clickAT(){
        AutoTesting.click();
        return new PFLBAutoTestingPage();
    }

    public boolean isDisplayedAutoTesting() throws TimeoutException{
        return AutoTesting.isDisplayed();
    }
}
