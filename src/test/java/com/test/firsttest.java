package com.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class firsttest {

    @BeforeClass
    public static void setUp(){
        //Настраиваем Driver
        Setting.getDriver();
        Setting.setTimeWait(10);
    }

    @AfterClass
    public static void closeDriver(){
        //Гасим драйвер
        Setting.closeDriver();
    }

    @Test
    public void google(){
        PageObjectWithPageFactory page = new PageObjectWithPageFactory("https://google.ru");
        page.searchGoogle("performance lab"); // Ищем Performance Lab
        page.clickGoogle(); // Переходим на сайт Performance Lab

        page.getUpMenu(); // Раскрываем меню "Услуги"
        page.getClickTesting(); // Переходим в раздел тестирования
        page.getClickAutoTesting(); // Переходим в раздел Автоматизация

        //Сохраняем файл
        Setting.saveFile("/users/oneso/", "google", page.getElementText());
        Setting.closeAllTabs();
    }

    @Test
    public void yandex(){
        PageObjectWithPageFactory page = new PageObjectWithPageFactory("https://yandex.ru");
        page.searchYandex("performance lab");
        page.clickYandex();

        page.getUpMenu();
        page.getClickTesting();
        page.getClickAutoTesting();

        Setting.saveFile("/users/oneso/", "yandex", page.getElementText());
        Setting.closeAllTabs();
    }

    @Test
    public void rambler(){
        PageObjectWithPageFactory page = new PageObjectWithPageFactory("https://rambler.ru");
        page.searchRambler("performance lab");
        page.clickRambler();

        page.getUpMenu();
        page.getClickTesting();
        page.getClickAutoTesting();

        Setting.saveFile("/users/oneso/", "rambler", page.getElementText());
        Setting.closeAllTabs();
    }
}
