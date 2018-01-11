package com.autotesting.utilize.PerformanceLabPages;

import com.autotesting.utilize.BasePage;
import com.autotesting.utilize.Setting.SettingDriver;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PFLBTestingPage extends BasePage {

    @FindBy(css = "div.col-md-4 a[href*=\"avtomatizacija\"]")
    private WebElement AutoTesting;

    public String NamePage = "Тестирование программного обеспечения - Перфоманс Лаб";

    public PFLBTestingPage(){
        super();
        if(!NamePage.equals(SettingDriver.getChromeDriver().getTitle()))
            throw new IllegalStateException("This is not the testing page");
    }

    /**
     * Click on specific link (AT)
     */
    public PFLBAutoTestingPage clickAT() throws TimeoutException{
        SettingDriver.setTimeWait(5, AutoTesting);
        AutoTesting.click();
        return new PFLBAutoTestingPage();
    }
}
