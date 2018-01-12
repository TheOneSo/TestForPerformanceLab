package com.autotesting.tests;

import com.autotesting.utilize.Logic.FileHandler;
import com.autotesting.utilize.PerformanceLabPages.PFLBAutoTestingPage;
import com.autotesting.utilize.PerformanceLabPages.PFLBHomePage;
import com.autotesting.utilize.PerformanceLabPages.PFLBTestingPage;
import com.autotesting.utilize.SearchPages.GooglePage;
import com.autotesting.utilize.SearchPages.RamblerPage;
import com.autotesting.utilize.SearchPages.SearchPage;
import com.autotesting.utilize.SearchPages.YandexPage;
import com.autotesting.utilize.Setting.SettingDriver;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import org.openqa.selenium.NoSuchElementException;
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
    public void testThroughGoogle(){
        try{
            process(new GooglePage());
        } catch (TimeoutException e){
            System.out.println(e.getMessage());
        } catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testThroughYandex(){
        try{
            process(new YandexPage());
        } catch (TimeoutException e){
            System.out.println(e.getMessage());
        } catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testThroughRambler(){
        try{
            process(new RamblerPage());
        } catch (TimeoutException e){
            System.out.println(e.getMessage());
        } catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }
    }

    private void process(SearchPage page) throws TimeoutException, NoSuchElementException{
        try {
            PFLBHomePage home = page.search("performance lab").clickResult(1);
            home.moveToServicesInDropdownMenu();
            PFLBTestingPage testingpage = home.clickTesting();
            PFLBAutoTestingPage autotesting = testingpage.clickAT();
            String text = autotesting.getText();
            new FileHandler().saveFile("/users/oneso/", page.name, text);
            SettingDriver.closeAllTabsExceptFirst();
        } catch (NoSuchElementException e){
            throw new NoSuchElementException(String.format("Error in %s page \n %s", page.name, e.getMessage()), e);
        } catch (TimeoutException e){
            throw new TimeoutException(String.format("Error in %s page \n %s", page.name, e.getMessage()), e);
        }
    }
}
