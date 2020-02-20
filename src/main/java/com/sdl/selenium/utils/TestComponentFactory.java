package com.sdl.selenium.utils;

import com.sdl.selenium.IDatePicker;
import com.sdl.selenium.bootstrap.form.Form;
import com.sdl.selenium.web.WebLocator;

/**
 * Factory method for retruning the correct DataPicker object based upon the testing parameters.
 */
public class TestComponentFactory {

    /**
     * The factory method, it takes Builder object built up with the correct items needed to build
     * DatePickers.
     * @param testComponent Builder object that contains needed variouables to build a DatPicker Object
     * @return Concrete object of the IDatePicker interface
     */
    public static IDatePicker getDatePicker(TestComponent testComponent) {

        switch (testComponent.getComponent()) {
            case BOOTSTRAP:
                Form form = new Form(null, testComponent.getTitle());
                return new com.sdl.selenium.bootstrap.form.DatePicker(form, testComponent.getLabel());
            case TOOLSQA:
                WebLocator container = new WebLocator(testComponent.getLocation());
                return new com.sdl.selenium.toolsqa.DatePicker(container, testComponent.getLabel());
            default:
                throw new UnsupportedOperationException("Currently Not Implemented");
        }

    }
}
