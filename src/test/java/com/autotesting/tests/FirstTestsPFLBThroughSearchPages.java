package com.autotesting.tests;

import com.autotesting.utilize.Logic.FileHandler;
import com.autotesting.utilize.PerformanceLabPages.PFLBAutoTestingPage;
import com.autotesting.utilize.PerformanceLabPages.PFLBHomePage;
import com.autotesting.utilize.PerformanceLabPages.PFLBTestingPage;
import com.autotesting.utilize.SearchPages.GooglePage;
import com.autotesting.utilize.SearchPages.RamblerPage;
import com.autotesting.utilize.SearchPages.YandexPage;
import com.autotesting.utilize.Setting.SettingDriver;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.TimeoutException;

public class FirstTestsPFLBThroughSearchPages {

    @BeforeClass
    public static void setUp(){
        System.out.println("Start tests");
        SettingDriver.getChromeDriver();
    }

    @AfterClass
    public static void closeDriver(){
        SettingDriver.closeDriver();
        System.out.println("Tests finished");
    }

    @Test
    public void testPFLBThroughGoogle(){
        try {
            GooglePage pages = new GooglePage();
            pages.search("performance lab");
            PFLBHomePage home = pages.clickResult(1);
            home.moveToServicesInDropdownMenu();
            PFLBTestingPage testingpage = home.clickTesting();
            PFLBAutoTestingPage autotesting = testingpage.clickAT();
            String text = autotesting.getText();
            new FileHandler().saveFile("/users/oneso/", "google", text);
            SettingDriver.closeAllTabsExceptFirst();
        } catch (TimeoutException e){
            System.out.println("test PFLBT through Google - failed");
        }
    }

    @Test
    public void testPFLBThroughYandex(){
        try {
            YandexPage page = new YandexPage();
            page.search("performance lab");
            PFLBHomePage home = page.clickResult(1);
            home.moveToServicesInDropdownMenu();
            PFLBTestingPage testingpage = home.clickTesting();
            PFLBAutoTestingPage autotesting = testingpage.clickAT();
            String text = autotesting.getText();
            new FileHandler().saveFile("/users/oneso/", "yandex", text);
            SettingDriver.closeAllTabsExceptFirst();
        } catch (TimeoutException e){
            System.out.println("test PFLB through Yandex - failed");
        }
    }

    @Test
    public void testPFLBThroughRambler(){
        try {
            RamblerPage page = new RamblerPage();
            page.search("performance lab");
            PFLBHomePage home = page.clickResult(1);
            home.moveToServicesInDropdownMenu();
            PFLBTestingPage testingpage = home.clickTesting();
            PFLBAutoTestingPage autotesting = testingpage.clickAT();
            String text = autotesting.getText();
            new FileHandler().saveFile("/users/oneso/", "rambler", text);
            SettingDriver.closeAllTabsExceptFirst();
        } catch (TimeoutException e){
            System.out.println("test PFLB through Rambler - failed");
        }
    }
}
