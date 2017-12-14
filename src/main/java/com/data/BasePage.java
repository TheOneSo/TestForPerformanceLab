package com.data;

import com.data.Setting.SettingDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage(){
        PageFactory.initElements(SettingDriver.getChromeDriver(), this);
    }
}
