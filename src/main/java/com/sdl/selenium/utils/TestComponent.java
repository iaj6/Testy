package com.sdl.selenium.utils;

/**
 * Wrapper class for the needed parameters to build a DatePicker Object
 */
public class TestComponent {
    public enum  COMPONENTS {
        TOOLSQA, BOOTSTRAP;
    }

    private COMPONENTS component;
    private String location;
    private String label;
    private String title;

    private TestComponent (COMPONENTS component, String location, String label, String title) {
        this.component = component;
        this.location = location;
        this.label = label;
        this.title = title;
    }

    public COMPONENTS getComponent() {
        return component;
    }

    public String getLocation() {
        return location;
    }

    public String getLabel() {
        return label;
    }

    public String getTitle() {
        return title;
    }

    public static class TestComponentBuilder {
        private COMPONENTS component;
        private String label;
        private String location;
        private String title;

        public TestComponentBuilder setComponent(final COMPONENTS component) {
            this.component = component;
            return this;
        }

        public TestComponentBuilder setLabel(final String label) {
            this.label = label;
            return this;
        }

        public TestComponentBuilder setLocation(final String location) {
            this.location = location;
            return this;
        }

        public TestComponentBuilder setTitle(final String title) {
            this.title = title;
            return this;
        }

        public TestComponent createTestComponent() {
            return new TestComponent(component, location, label, title);
        }
    }

}
