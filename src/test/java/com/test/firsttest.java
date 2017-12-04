package com.test;

import org.junit.After;
import org.junit.Test;
import org.junit.Before;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

import java.util.*;

@RunWith(value = Parameterized.class)
public class firsttest {

    private static WebDriver driver;
    private static Setting setting;
    private String Search;
    private String FieldForSearch;
    private String Site;

    @Parameterized.Parameters
    public static Collection<Object[]> testData() {
        Object[][] data = new Object[][]{
                {"google", "input.gsfi", "div.g h3.r a"},
                {"yandex", "input#text", "li[class*=\"serp-item\"] a[accesskey*=\"1\"]"},
                {"rambler", "input[type*=\"text\"]", "div.b-serp-item a[onmouseup*=\"title_1'\"]"}
        };
        return Arrays.asList(data);
    }

    public firsttest(String Search, String FieldForSearch, String Site){
        this.Search = Search;
        this.FieldForSearch = FieldForSearch;
        this.Site = Site;
    }

    @Before
    public void setUp(){
        //Настраиваем Driver
        setting = new Setting();
        driver = setting.dirverSetting();
        setting.setTimeWait(driver,10);
        setting.goSite(driver, "https://" + Search + ".ru");
    }

    @After
    public void closeDriver(){
        //Закрываем браузер
        setting.closeTabOrDriver(driver);
    }

    @Test
    public void test(){
        //Ищем Перфоманс Лаб в 3-х поисковиках и переходим на него
        SearchPage page = new SearchPage(driver, By.cssSelector(FieldForSearch), By.cssSelector(Site));
        page.typeInput("performance lab");
        page.submitButton();
        page.clickSite();

        //Получаем нужные данные с сайта Перфоманс Лаб
        PerformanceLabPage performance = new PerformanceLabPage(driver);
        performance.getUpMenu();
        performance.getClickTesting();
        performance.getClickAutoTesting();
        String Text = performance.getElementText();

        //Сохраняем файл
        setting.saveFile("/users/oneso/", Search, Text);
    }
}
