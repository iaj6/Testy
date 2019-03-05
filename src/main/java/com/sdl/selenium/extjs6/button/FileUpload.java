package com.sdl.selenium.extjs6.button;

import com.sdl.selenium.bootstrap.button.Upload;
import com.sdl.selenium.web.SearchType;
import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.form.TextField;

public class FileUpload extends TextField implements Upload {

    public FileUpload() {
        setClassName("FileUpload");
        setType("file");
    }

    public FileUpload(WebLocator container) {
        this();
        setContainer(container);
    }

    public FileUpload(WebLocator container, String label, SearchType... searchTypes) {
        this(container);
        if (searchTypes.length == 0) {
            searchTypes = new SearchType[]{SearchType.DEEP_CHILD_NODE_OR_SELF};
        }
        setLabel(label, searchTypes);
    }

    /**
     * Upload file with AutoIT.
     * Use only this: button.upload("C:\\text.txt");
     *
     * @param filePath e.g. "C:\\text.txt"
     * @return true | false
     */
    @Override
    public boolean upload(String filePath) {
        return upload(this, filePath);
    }

    /**
     * Upload file with AutoIT.
     * Use only this: button.upload(this, "C:\\text.txt");
     *
     * @param el       the item that you click to open upload window
     * @param filePath e.g. "C:\\text.txt"
     * @return true | false
     */
    private boolean upload(WebLocator el, String filePath) {
        return executor.browse(el) && executor.upload(filePath);
    }
}