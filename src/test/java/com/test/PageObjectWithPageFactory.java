package com.test;

import com.data.Setting.SettingDriver;
import com.data.PerformanceLabPages.PFLBAutoTestingPage;
import com.data.PerformanceLabPages.PFLBHomePage;
import com.data.PerformanceLabPages.PFLBTestingPage;
import com.data.SearchPages.GooglePage;
import com.data.SearchPages.RamblerPage;
import com.data.SearchPages.YandexPage;

public class PageObjectWithPageFactory {

    public PageObjectWithPageFactory(String url){
        SettingDriver.openUrl(url);
    }

    public void getUpMenu(){
        new PFLBHomePage().moveToServicesInDropdownMenu();
    }

    public void getClickTesting() {
        new PFLBHomePage().clickTesting();
    }

    public void getClickAutoTesting(){
        new PFLBTestingPage().clickAT();
    }

    public String getElementText(){
        return new PFLBAutoTestingPage().getText();
    }

    public void searchGoogle(String text){ new GooglePage().search(text);}

    public void clickGoogle(){ new GooglePage().clickFirstResult();}

    public void searchYandex(String text) {new YandexPage().search(text);}

    public void clickYandex(){ new YandexPage().clickFirstResult();}

    public void searchRambler(String text) {new RamblerPage().search(text);}

    public void clickRambler(){ new RamblerPage().clickFirstResult();}

}
