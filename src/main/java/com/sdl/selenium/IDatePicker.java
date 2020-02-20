package com.sdl.selenium;

/**
 * An interface that represents the common items of a DatePicker object
 */
public interface IDatePicker {

    public boolean select(String date);

    public String getDate();

    public boolean setValue(String date);
}
