package com.test;

import com.data.Logic.FileHandler;
import com.data.PerformanceLabPages.PFLBAutoTestingPage;
import com.data.PerformanceLabPages.PFLBHomePage;
import com.data.PerformanceLabPages.PFLBTestingPage;
import com.data.SearchPages.GooglePage;
import com.data.Setting.SettingDriver;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class FirstTestsPFLBThroughSearchPages {

    @BeforeClass
    public static void setUp(){
        System.out.println("Start tests");
        SettingDriver.getChromeDriver();
        SettingDriver.setGlobalTimeWait(10);
    }

    @AfterClass
    public static void closeDriver(){
        SettingDriver.closeDriver();
        System.out.println("Tests completed successfully");
    }

    @Test
    public void testPFLBThroughGoogle(){
        SettingDriver.openUrl("https://google.com");
        GooglePage pages = new GooglePage();
        pages.search("performance lab");

        PFLBHomePage home = pages.clickFirstResult();
        if(!home.NamePage.equals(SettingDriver.getChromeDriver().getTitle()))
            throw new IllegalStateException("This is not the PerformanceLab page");
        home.moveToServicesInDropdownMenu();

        PFLBTestingPage testingpage = home.clickTesting();
        if(!testingpage.NamePage.equals(SettingDriver.getChromeDriver().getTitle()))
            throw new IllegalStateException("This is not the testing page");

        PFLBAutoTestingPage autotesting = testingpage.clickAT();
        if(!autotesting.NamePage.equals(SettingDriver.getChromeDriver().getTitle()))
            throw new IllegalStateException("This is not the autotesting page");
        String text = autotesting.getText();


        new FileHandler().saveFile("/users/oneso/", "google", text);
        SettingDriver.closeAllTabsExceptFirst();
    }

    @Test
    public void testPFLBThroughYandex(){
        PageObjectWithPageFactory page = new PageObjectWithPageFactory("https://yandex.ru");
        page.searchYandex("performance lab");
        page.clickYandex();

        page.getUpMenu();
        page.getClickTesting();
        page.getClickAutoTesting();

        new FileHandler().saveFile("/users/oneso/", "yandex", page.getElementText());
        SettingDriver.closeAllTabsExceptFirst();
    }

    @Test
    public void testPFLBThroughRambler(){
        PageObjectWithPageFactory page = new PageObjectWithPageFactory("https://rambler.ru");
        page.searchRambler("performance lab");
        page.clickRambler();

        page.getUpMenu();
        page.getClickTesting();
        page.getClickAutoTesting();

        new FileHandler().saveFile("/users/oneso/", "rambler", page.getElementText());
        SettingDriver.closeAllTabsExceptFirst();
    }
}
