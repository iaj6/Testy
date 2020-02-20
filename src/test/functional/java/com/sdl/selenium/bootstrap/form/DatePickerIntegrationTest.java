package functional.java.com.sdl.selenium.bootstrap.form;

import com.sdl.selenium.IDatePicker;
import com.sdl.selenium.InputData;
import com.sdl.selenium.TestBase;
import com.sdl.selenium.utils.TestComponent;
import com.sdl.selenium.utils.TestComponentFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.sdl.selenium.utils.TestComponent.COMPONENTS.BOOTSTRAP;
import static org.testng.Assert.assertTrue;

public class DatePickerIntegrationTest extends TestBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(DatePickerIntegrationTest.class);

    private IDatePicker datePicker;

    @BeforeClass
    public void startTests() {
        TestComponent component = new TestComponent.TestComponentBuilder()
                .setComponent(BOOTSTRAP)
                .setTitle("Form Title")
                .setLabel("dp3")
                .createTestComponent();

        datePicker = TestComponentFactory.getDatePicker(component);

        driver.get(InputData.BOOTSTRAP_URL);
    }


    @Test
    public void selectDate() {
        long startMs = System.currentTimeMillis();
        datePicker.select("19/02/2019");
        long endMs = System.currentTimeMillis();
        LOGGER.info(String.format("selectDate1 took %s ms", endMs - startMs));
        assertTrue("19-02-2019".equals(datePicker.getDate()));

        startMs = System.currentTimeMillis();
        datePicker.select("22/09/2019");
        endMs = System.currentTimeMillis();
        LOGGER.info(String.format("selectDate2 took %s ms", endMs - startMs));
        assertTrue("22-09-2019".equals(datePicker.getDate()));

        startMs = System.currentTimeMillis();
        datePicker.select("12/09/2019");
        endMs = System.currentTimeMillis();
        LOGGER.info(String.format("selectDate3 took %s ms", endMs - startMs));
        assertTrue("12-09-2019".equals(datePicker.getDate()));

        startMs = System.currentTimeMillis();
        datePicker.select("12/09/2019");
        endMs = System.currentTimeMillis();
        LOGGER.info(String.format("selectDate4 took %s ms", endMs - startMs));
        assertTrue("12-09-2019".equals(datePicker.getDate()));

        startMs = System.currentTimeMillis();
        datePicker.select("29/01/2019");
        endMs = System.currentTimeMillis();
        LOGGER.info(String.format("selectDate5 took %s ms", endMs - startMs));
        assertTrue("29-01-2019".equals(datePicker.getDate()));
    }

    @Test
    public void selectOldDate() {
        datePicker.select("11/08/1872");
        assertTrue("11-08-1872".equals(datePicker.getDate()));
    }

    @Test
    public void selectNewDate() {
        datePicker.select("02/08/2052");
        assertTrue("02-08-2052".equals(datePicker.getDate()));
    }
}
