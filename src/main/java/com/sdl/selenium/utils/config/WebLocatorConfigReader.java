package com.sdl.selenium.utils.config;

import com.sdl.selenium.web.SearchType;
import com.sdl.selenium.web.utils.PropertiesReader;

import java.util.Arrays;

public class WebLocatorConfigReader extends PropertiesReader {

    private static final String DEFAULT_CONFIG = ""+
            "\n weblocator.log.containers=true" +
            "\n weblocator.log.useClassName=false" +
            "\n weblocator.log.xPath=true" +
            "\n weblocator.log.suggestions=true" +
            "\n weblocator.highlight=false" +
            "\n weblocator.defaults.renderMillis=3000" +
            "\n #accepted values for searchType: " + Arrays.asList(SearchType.values()) +
            "\n weblocator.defaults.searchType=CONTAINS" +
            "\n weblocator.defaults.labelPosition=//following-sibling::*//" +
            "\n weblocator.min.chars.toType=-1" +
            "\n driver.autoClose=true" +
            "\n driver.implicitlyWait=100";

    public WebLocatorConfigReader() {
        this(null);
    }

    public WebLocatorConfigReader(String resourcePath) {
        super(DEFAULT_CONFIG, resourcePath);
    }
}
