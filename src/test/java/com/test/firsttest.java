package com.test;

import org.junit.After;
import org.junit.Test;
import org.junit.Before;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.*;

//@RunWith(value = Parameterized.class)
public class firsttest {

//    private String Search;
//    private String FieldForSearch;
//    private String Site;
//
//    @Parameterized.Parameters
//    public static Collection<Object[]> testData() {
//        Object[][] data = new Object[][]{
//                {"google", "input.gsfi", "div.g h3.r a"},
//                {"yandex", "input#text", "li[class*=\"serp-item\"] a[accesskey*=\"1\"]"},
//                {"rambler", "input[type*=\"text\"]", "div.b-serp-item a[onmouseup*=\"title_1'\"]"}
//        };
//        return Arrays.asList(data);
//    }
//
//    public firsttest(String Search, String FieldForSearch, String Site){
//        this.Search = Search;
//        this.FieldForSearch = FieldForSearch;
//        this.Site = Site;
//    }

    @Before
    public void setUp(){
        //Настраиваем Driver
        Setting.getDriver();
        Setting.setTimeWait(10);
    }

    @After
    public void closeDriver(){
        //Закрываем браузер
        //Setting.closeTabOrDriver("quit");
    }

    @Test
    public void google(){
        PageObjectWithPageFactory page = new PageObjectWithPageFactory("https://google.ru");
        page.search("performance lab"); // Ищем Performance Lab
        page.clickSite(); // Переходим на сайт Performance Lab

        page.getUpMenu(); // Раскрываем меню "Услуги"
        page.getClickTesting(); // Переходим в раздел тестирования
        page.getClickAutoTesting(); // Переходим в раздел Автоматизация

        //Сохраняем файл
        Setting.saveFile("/users/oneso/", "google", page.getElementText());
        Setting.closeTabOrDriver("tab");
    }

//    @Test
//    public void yandex(){
//        PageObjectWithPageFactory page = new PageObjectWithPageFactory("https://yandex.ru");
//        page.search("performance lab");
//        page.clickSite();
//
//        page.getUpMenu();
//        page.getClickTesting();
//        page.getClickAutoTesting();
//
//        Setting.saveFile("/users/oneso/", "yandex", page.getElementText());
//        Setting.closeTabOrDriver("tab");
//    }
}
