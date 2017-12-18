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

import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;

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
    }

    @Test
    public void testPFLBThroughGoogle(){
            SettingDriver.openUrl("https://google.com");
            GooglePage pages = new GooglePage();
            if(!pages.isDisplayedInput())
                throw new NoSuchElementException("Element not found");
            pages.search("performance lab");
            PFLBHomePage home = pages.clickFirstResult();

            if (!home.NamePage.equals(SettingDriver.getChromeDriver().getTitle()))
                throw new IllegalStateException("This is not the PerformanceLab page");
            if(!home.isDisplayedServices())
                throw new NoSuchElementException("Element not found");
            home.moveToServicesInDropdownMenu();

            if(!home.isDisplayedTesting())
                throw new NoSuchElementException("Element not found");
            PFLBTestingPage testingpage = home.clickTesting();
            new SettingDriver().setTimeWait(5);

            if (!testingpage.NamePage.equals(SettingDriver.getChromeDriver().getTitle()))
                throw new IllegalStateException("This is not the testing page");
            if(!testingpage.isDisplayedAutoTesting())
                throw new NoSuchElementException("Element not found");
            PFLBAutoTestingPage autotesting = testingpage.clickAT();

            if (!autotesting.NamePage.equals(SettingDriver.getChromeDriver().getTitle()))
                throw new IllegalStateException("This is not the autotesting page");
            String text = autotesting.getText();

            new FileHandler().saveFile("/users/oneso/", "google", text);
            SettingDriver.closeAllTabsExceptFirst();
    }

    @Test
    public void testPFLBThroughYandex(){
            SettingDriver.openUrl("https://yandex.ru");
            YandexPage page = new YandexPage();
            if(!page.isDisplayedInput())
                throw new NoSuchElementException("Element not found");
            page.search("performance lab");
            PFLBHomePage home = page.clickFirstResult();

            if (!home.NamePage.equals(SettingDriver.getChromeDriver().getTitle()))
                throw new IllegalStateException("This is not the PerformanceLab page");
            if(!home.isDisplayedServices())
                throw new NoSuchElementException("Element not found");
            home.moveToServicesInDropdownMenu();

            if(!home.isDisplayedTesting())
                throw new NoSuchElementException("Element not found");
            PFLBTestingPage testingpage = home.clickTesting();
            new SettingDriver().setTimeWait(5);

            if (!testingpage.NamePage.equals(SettingDriver.getChromeDriver().getTitle()))
                throw new IllegalStateException("This is not the testing page");
            if(!testingpage.isDisplayedAutoTesting())
                throw new NoSuchElementException("Element not found");
            PFLBAutoTestingPage autotesting = testingpage.clickAT();

            if (!autotesting.NamePage.equals(SettingDriver.getChromeDriver().getTitle()))
                throw new IllegalStateException("This is not the autotesting page");
            String text = autotesting.getText();

            new FileHandler().saveFile("/users/oneso/", "yandex", text);
            SettingDriver.closeAllTabsExceptFirst();
    }

    @Test
    public void testPFLBThroughRambler(){
            SettingDriver.openUrl("https://rambler.ru");
            RamblerPage page = new RamblerPage();
            if(!page.isDisplayedInput())
                throw new NoSuchElementException("Element not found");
            page.search("performance lab");
            PFLBHomePage home = page.clickFirstResult();

            if (!home.NamePage.equals(SettingDriver.getChromeDriver().getTitle()))
                throw new IllegalStateException("This is not the PerformanceLab page");
            if(!home.isDisplayedServices())
                throw new NoSuchElementException("Element not found");
            home.moveToServicesInDropdownMenu();

            if(!home.isDisplayedTesting())
                throw new NoSuchElementException("Element not found");
            PFLBTestingPage testingpage = home.clickTesting();
            new SettingDriver().setTimeWait(5);

            if (!testingpage.NamePage.equals(SettingDriver.getChromeDriver().getTitle()))
                throw new IllegalStateException("This is not the testing page");
            if(!testingpage.isDisplayedAutoTesting())
                throw new NoSuchElementException("Element not found");
            PFLBAutoTestingPage autotesting = testingpage.clickAT();

            if (!autotesting.NamePage.equals(SettingDriver.getChromeDriver().getTitle()))
                throw new IllegalStateException("This is not the autotesting page");
            String text = autotesting.getText();

            new FileHandler().saveFile("/users/oneso/", "rambler", text);
            SettingDriver.closeAllTabsExceptFirst();
    }
}
