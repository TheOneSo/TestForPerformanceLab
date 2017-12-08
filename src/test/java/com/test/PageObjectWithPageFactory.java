package com.test;

import com.test.PerformanceLab.AutoTestingPage;
import com.test.PerformanceLab.HomePage;
import com.test.PerformanceLab.TestingPage;
import com.test.Search.SearchGoogle;

public class PageObjectWithPageFactory {

    public PageObjectWithPageFactory(String url){
        Setting.goSite(url);
    }

    public void getUpMenu(){
        new HomePage().clickUpMenu();
    }

    public void getClickTesting() {
        new HomePage().clickTesting();
    }

    public void getClickAutoTesting(){
        new TestingPage().clickAutoTesting();
    }

    public String getElementText(){
        return new AutoTestingPage().elementText();
    }

    public void search(String text){ new SearchGoogle().search(text);}

    public void clickSite(){ new SearchGoogle().clickSite();}

}
