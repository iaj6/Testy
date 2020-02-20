package com.sdl.selenium.utils;

import org.testng.annotations.Test;

import static com.sdl.selenium.utils.TestComponent.COMPONENTS.BOOTSTRAP;
import static org.testng.Assert.*;

public class TestComponentTest {

    @Test
    public static void testFieldsSetCorrectly() {
        TestComponent component = new TestComponent.TestComponentBuilder()
                .setComponent(BOOTSTRAP)
                .setLabel("label")
                .setLocation("location")
                .setTitle("title")
                .createTestComponent();


        assertEquals(BOOTSTRAP, component.getComponent());
        assertEquals("label", component.getLabel());
        assertEquals("location", component.getLocation());
        assertEquals("title", component.getTitle());
    }

}