package com.test;

import com.test.PerformanceLab.AutoTestingPage;
import com.test.PerformanceLab.HomePage;
import com.test.PerformanceLab.TestingPage;
import com.test.Search.SearchGoogle;
import com.test.Search.SearchRambler;
import com.test.Search.SearchYandex;

public class PageObjectWithPageFactory {

    public PageObjectWithPageFactory(String url){
        Setting.goSite(url);
    }

    public void getUpMenu(){
        new HomePage().expandMenu();
    }

    public void getClickTesting() {
        new HomePage().click();
    }

    public void getClickAutoTesting(){
        new TestingPage().click();
    }

    public String getElementText(){
        return new AutoTestingPage().getText();
    }

    public void searchGoogle(String text){ new SearchGoogle().search(text);}

    public void clickGoogle(){ new SearchGoogle().click();}

    public void searchYandex(String text) {new SearchYandex().search(text);}

    public void clickYandex(){ new SearchYandex().click();}

    public void searchRambler(String text) {new SearchRambler().search(text);}

    public void clickRambler(){ new SearchRambler().click();}

}
