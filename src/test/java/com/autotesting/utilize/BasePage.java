package com.autotesting.utilize;

import com.autotesting.utilize.Setting.SettingDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public String namePage = null;

    public BasePage(){
        PageFactory.initElements(SettingDriver.getChromeDriver(), this);
    }
}
