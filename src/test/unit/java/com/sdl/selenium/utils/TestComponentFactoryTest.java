package com.sdl.selenium.utils;

import com.sdl.selenium.IDatePicker;
import org.testng.annotations.Test;

import static com.sdl.selenium.utils.TestComponent.COMPONENTS.BOOTSTRAP;
import static com.sdl.selenium.utils.TestComponent.COMPONENTS.TOOLSQA;
import static org.testng.AssertJUnit.assertTrue;

public class TestComponentFactoryTest {

    @Test
    public static void testInstanceOfBootStrap() {
        TestComponent component = new TestComponent.TestComponentBuilder()
                .setComponent(BOOTSTRAP)
                .setLabel("Date:")
                .setLocation("demo-frame")
                .createTestComponent();
        IDatePicker picker = TestComponentFactory.getDatePicker(component);

        assertTrue(picker instanceof com.sdl.selenium.bootstrap.form.DatePicker);
    }

    @Test
    public static void testInstanceOfToolsQA() {
        TestComponent component = new TestComponent.TestComponentBuilder()
                .setComponent(TOOLSQA)
                .setLabel("Date:")
                .setLocation("demo-frame")
                .createTestComponent();
        IDatePicker picker = TestComponentFactory.getDatePicker(component);

        assertTrue(picker instanceof com.sdl.selenium.toolsqa.DatePicker);
    }
}