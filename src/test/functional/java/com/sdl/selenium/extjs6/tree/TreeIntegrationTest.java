package com.sdl.selenium.extjs6.tree;

import com.sdl.selenium.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class TreeIntegrationTest extends TestBase {

    private Tree tree = new Tree().setVisibility(true);

    @BeforeClass
    public void startTests() {
        driver.get("http://examples.sencha.com/extjs/6.0.2/examples/kitchensink/#check-tree");
        tree.ready(20);
    }

    @Test
    void treeTest() {
        boolean selected = tree.select("Grocery List", "Energy foods", "Coffee");
        assertThat(selected, is(true));
    }
}
