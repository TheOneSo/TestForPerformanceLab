package com.autotesting.utilize.SearchPages;

import com.autotesting.utilize.BasePage;
import com.autotesting.utilize.PerformanceLabPages.PFLBHomePage;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;

public abstract class SearchPage extends BasePage {

    public String name = null;

    public SearchPage(){
        super();
    }

    public abstract SearchPage search(String value) throws TimeoutException, NoSuchElementException;

    public abstract PFLBHomePage clickResult(int numberResult) throws TimeoutException, NoSuchElementException;
}
