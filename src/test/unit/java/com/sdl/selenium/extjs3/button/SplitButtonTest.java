package com.sdl.selenium.extjs3.button;

import com.sdl.selenium.extjs3.ExtJsComponent;
import com.sdl.selenium.web.By;
import com.sdl.selenium.web.SearchType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SplitButtonTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(SplitButtonTest.class);

    public static ExtJsComponent container = new ExtJsComponent(By.classes("container"));
    public static String CONTAINER_PATH = "//*[contains(concat(' ', @class, ' '), ' container ')]";

    @DataProvider
    public static Object[][] testConstructorPathDataProvider() {
        return new Object[][]{
                {new SplitButton(), "//table[contains(concat(' ', @class, ' '), ' x-btn ') and count(ancestor-or-self::*[contains(@style, 'display: none')]) = 0 and count(ancestor-or-self::*[contains(@class, 'x-hide-display')]) = 0 and not(contains(@class, 'x-item-disabled'))]"},
                {new SplitButton().setClasses("ButtonClass"), "//table[contains(concat(' ', @class, ' '), ' x-btn ') and contains(concat(' ', @class, ' '), ' ButtonClass ') and count(ancestor-or-self::*[contains(@style, 'display: none')]) = 0 and count(ancestor-or-self::*[contains(@class, 'x-hide-display')]) = 0 and not(contains(@class, 'x-item-disabled'))]"},
                {new SplitButton(container), CONTAINER_PATH + "//table[contains(concat(' ', @class, ' '), ' x-btn ') and count(ancestor-or-self::*[contains(@style, 'display: none')]) = 0 and count(ancestor-or-self::*[contains(@class, 'x-hide-display')]) = 0 and not(contains(@class, 'x-item-disabled'))]"},
                {new SplitButton(container, "ButtonText"), CONTAINER_PATH + "//table[contains(concat(' ', @class, ' '), ' x-btn ') and count(*//text()[.='ButtonText']) > 0 and count(ancestor-or-self::*[contains(@style, 'display: none')]) = 0 and count(ancestor-or-self::*[contains(@class, 'x-hide-display')]) = 0 and not(contains(@class, 'x-item-disabled'))]"},
                {new SplitButton(container, "ButtonText").setSearchTextType(SearchType.CONTAINS), CONTAINER_PATH + "//table[contains(concat(' ', @class, ' '), ' x-btn ') and count(*//text()[contains(.,'ButtonText')]) > 0 and count(ancestor-or-self::*[contains(@style, 'display: none')]) = 0 and count(ancestor-or-self::*[contains(@class, 'x-hide-display')]) = 0 and not(contains(@class, 'x-item-disabled'))]"},
                {new SplitButton(container, "Text").setIconCls("x-tbar-loading"), CONTAINER_PATH + "//table[contains(concat(' ', @class, ' '), ' x-btn ') and count(.//*[contains(@class, 'x-tbar-loading')]) > 0 and count(*//text()[.='Text']) > 0 and count(ancestor-or-self::*[contains(@style, 'display: none')]) = 0 and count(ancestor-or-self::*[contains(@class, 'x-hide-display')]) = 0 and not(contains(@class, 'x-item-disabled'))]"},
                {new SplitButton(container).setId("ID"), CONTAINER_PATH + "//table[@id='ID' and contains(concat(' ', @class, ' '), ' x-btn ') and count(ancestor-or-self::*[contains(@style, 'display: none')]) = 0 and count(ancestor-or-self::*[contains(@class, 'x-hide-display')]) = 0 and not(contains(@class, 'x-item-disabled'))]"},

                {new SplitButton(By.classes("ButtonClass")), "//table[contains(concat(' ', @class, ' '), ' x-btn ') and contains(concat(' ', @class, ' '), ' ButtonClass ') and count(ancestor-or-self::*[contains(@style, 'display: none')]) = 0 and count(ancestor-or-self::*[contains(@class, 'x-hide-display')]) = 0 and not(contains(@class, 'x-item-disabled'))]"},
                {new SplitButton(By.container(container)), CONTAINER_PATH + "//table[contains(concat(' ', @class, ' '), ' x-btn ') and count(ancestor-or-self::*[contains(@style, 'display: none')]) = 0 and count(ancestor-or-self::*[contains(@class, 'x-hide-display')]) = 0 and not(contains(@class, 'x-item-disabled'))]"},
                {new SplitButton(By.container(container), By.text("ButtonText")), CONTAINER_PATH + "//table[contains(concat(' ', @class, ' '), ' x-btn ') and count(*//text()[.='ButtonText']) > 0 and count(ancestor-or-self::*[contains(@style, 'display: none')]) = 0 and count(ancestor-or-self::*[contains(@class, 'x-hide-display')]) = 0 and not(contains(@class, 'x-item-disabled'))]"},
                {new SplitButton(By.container(container), By.text("ButtonText", SearchType.CONTAINS)), CONTAINER_PATH + "//table[contains(concat(' ', @class, ' '), ' x-btn ') and count(*//text()[contains(.,'ButtonText')]) > 0 and count(ancestor-or-self::*[contains(@style, 'display: none')]) = 0 and count(ancestor-or-self::*[contains(@class, 'x-hide-display')]) = 0 and not(contains(@class, 'x-item-disabled'))]"},
                {new SplitButton(By.container(container), By.text("Text")).setIconCls("x-tbar-loading"), CONTAINER_PATH + "//table[contains(concat(' ', @class, ' '), ' x-btn ') and count(.//*[contains(@class, 'x-tbar-loading')]) > 0 and count(*//text()[.='Text']) > 0 and count(ancestor-or-self::*[contains(@style, 'display: none')]) = 0 and count(ancestor-or-self::*[contains(@class, 'x-hide-display')]) = 0 and not(contains(@class, 'x-item-disabled'))]"},
                {new SplitButton(By.container(container), By.id("ID")), CONTAINER_PATH + "//table[@id='ID' and contains(concat(' ', @class, ' '), ' x-btn ') and count(ancestor-or-self::*[contains(@style, 'display: none')]) = 0 and count(ancestor-or-self::*[contains(@class, 'x-hide-display')]) = 0 and not(contains(@class, 'x-item-disabled'))]"},
        };
    }

    @Test(dataProvider = "testConstructorPathDataProvider")
    public void getPathSelectorCorrectlyFromConstructors(SplitButton splitButton, String expectedXpath) {
        assertEquals(splitButton.getPath(), expectedXpath);
    }

    @Test
    public void resetSearchTextType() {
        SplitButton locator = new SplitButton(By.text("text", SearchType.STARTS_WITH));
        assertEquals(locator.getPath(), "//table[contains(concat(' ', @class, ' '), ' x-btn ') and count(*//text()[starts-with(.,'text')]) > 0 and count(ancestor-or-self::*[contains(@style, 'display: none')]) = 0 and count(ancestor-or-self::*[contains(@class, 'x-hide-display')]) = 0 and not(contains(@class, 'x-item-disabled'))]");
        locator.getPathBuilder().setSearchTextType(null);
        assertEquals(locator.getPath(), "//table[contains(concat(' ', @class, ' '), ' x-btn ') and count(*//text()[contains(.,'text')]) > 0 and count(ancestor-or-self::*[contains(@style, 'display: none')]) = 0 and count(ancestor-or-self::*[contains(@class, 'x-hide-display')]) = 0 and not(contains(@class, 'x-item-disabled'))]");
    }
}