package com.autotesting.utilize.SearchPages;

import com.autotesting.utilize.BasePage;

import java.util.concurrent.TimeoutException;

public class SearchPage extends BasePage {

    public SearchPage(){
        super();
    }

    public SearchPage search(String value) throws TimeoutException{
        return this;
    }
}
