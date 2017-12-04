package com.test;

import org.openqa.selenium.WebDriver;

public class PerformanceLabPage {

    private WebDriver driver;

    public PerformanceLabPage(WebDriver driver){
        this.driver = driver;
    }

    public HomePage getUpMenu(){
        return new HomePage(driver).clickUpMenu();
    }

    public HomePage getClickTesting() {
        return new HomePage(driver).clickTesting();
    }

    public TestingPage getClickAutoTesting(){
        return new TestingPage(driver).clickAutoTesting();
    }

    public String getElementText(){
        return new AutoTestingPage(driver).elementText();
    }

}
