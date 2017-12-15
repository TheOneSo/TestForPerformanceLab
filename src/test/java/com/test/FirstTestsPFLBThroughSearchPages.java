package com.test;

import com.data.Logic.FileHandler;
import com.data.PerformanceLabPages.PFLBAutoTestingPage;
import com.data.PerformanceLabPages.PFLBHomePage;
import com.data.PerformanceLabPages.PFLBTestingPage;
import com.data.SearchPages.GooglePage;
import com.data.SearchPages.RamblerPage;
import com.data.SearchPages.YandexPage;
import com.data.Setting.SettingDriver;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

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

        try {
            SettingDriver.openUrl("https://google.com");
            GooglePage pages = new GooglePage();
            if(!pages.isDisplayedInput())
                throw new TimeoutException("Element not found");
            pages.search("performance lab");

            if(!pages.isDisplayedPathToFirstResult())
                throw new TimeoutException("Element not found");
            PFLBHomePage home = pages.clickFirstResult();

            if (!home.NamePage.equals(SettingDriver.getChromeDriver().getTitle()))
                throw new IllegalStateException("This is not the PerformanceLab page");
            if(!home.isDisplayedServices())
                throw new TimeoutException("Element not found");
            home.moveToServicesInDropdownMenu();

            if(!home.isDisplayedTesting())
                throw new TimeoutException("Element not found");
            PFLBTestingPage testingpage = home.clickTesting();

            if (!testingpage.NamePage.equals(SettingDriver.getChromeDriver().getTitle()))
                throw new IllegalStateException("This is not the testing page");
            if(!testingpage.isDisplayedAutoTesting())
                throw new TimeoutException("Element not found");
            PFLBAutoTestingPage autotesting = testingpage.clickAT();

            if (!autotesting.NamePage.equals(SettingDriver.getChromeDriver().getTitle()))
                throw new IllegalStateException("This is not the autotesting page");
            String text = autotesting.getText();

            new FileHandler().saveFile("/users/oneso/", "google", text);
            SettingDriver.closeAllTabsExceptFirst();

            System.out.println("Test PFLBThroughGoogle completed successfully");
        }catch (TimeoutException e){
            System.out.println("Test failed with timeout");
        }
    }

    @Test
    public void testPFLBThroughYandex(){

        try{
            SettingDriver.openUrl("https://yandex.ru");
            YandexPage page = new YandexPage();
            if(!page.isDisplayedInput())
                throw new TimeoutException("Element not found");
            page.search("performance lab");

            if(!page.isDisplayedPathToFirstResult())
                throw new TimeoutException("Element not found");
            PFLBHomePage home = page.clickFirstResult();

            if (!home.NamePage.equals(SettingDriver.getChromeDriver().getTitle()))
                throw new IllegalStateException("This is not the PerformanceLab page");
            if(!home.isDisplayedServices())
                throw new TimeoutException("Element not found");
            home.moveToServicesInDropdownMenu();

            if(!home.isDisplayedTesting())
                throw new TimeoutException("Element not found");
            PFLBTestingPage testingpage = home.clickTesting();

            if (!testingpage.NamePage.equals(SettingDriver.getChromeDriver().getTitle()))
                throw new IllegalStateException("This is not the testing page");
            if(!testingpage.isDisplayedAutoTesting())
                throw new TimeoutException("Element not found");
            PFLBAutoTestingPage autotesting = testingpage.clickAT();

            if (!autotesting.NamePage.equals(SettingDriver.getChromeDriver().getTitle()))
                throw new IllegalStateException("This is not the autotesting page");
            String text = autotesting.getText();

            new FileHandler().saveFile("/users/oneso/", "yandex", text);
            SettingDriver.closeAllTabsExceptFirst();

            System.out.println("Test PFLBThroughYandex completed successfully");
        }catch (TimeoutException e){
            System.out.println("Test failed with timeout");
        }
    }

    @Test
    public void testPFLBThroughRambler(){
        try{
            SettingDriver.openUrl("https://rambler.ru");
            RamblerPage page = new RamblerPage();
            if(!page.isDisplayedInput())
                throw new TimeoutException("Element not found");
            page.search("performance lab");

            //if(!page.isDisplayedPathToFirstResult())
            //    throw new TimeoutException("Element not found");
            PFLBHomePage home = page.clickFirstResult();

            if (!home.NamePage.equals(SettingDriver.getChromeDriver().getTitle()))
                throw new IllegalStateException("This is not the PerformanceLab page");
            if(!home.isDisplayedServices())
                throw new TimeoutException("Element not found");
            home.moveToServicesInDropdownMenu();

            if(!home.isDisplayedTesting())
                throw new TimeoutException("Element not found");
            PFLBTestingPage testingpage = home.clickTesting();

            //if (!testingpage.NamePage.equals(SettingDriver.getChromeDriver().getTitle()))
            //    throw new IllegalStateException("This is not the testing page");
            if(!testingpage.isDisplayedAutoTesting())
                throw new TimeoutException("Element not found");
            PFLBAutoTestingPage autotesting = testingpage.clickAT();

            if (!autotesting.NamePage.equals(SettingDriver.getChromeDriver().getTitle()))
                throw new IllegalStateException("This is not the autotesting page");
            String text = autotesting.getText();

            new FileHandler().saveFile("/users/oneso/", "rambler", text);
            SettingDriver.closeAllTabsExceptFirst();

            System.out.println("Test PFLBThroughRambler completed successfully");
        }catch (TimeoutException e){
            System.out.println("Test failed with timeout");
        }
    }
}
