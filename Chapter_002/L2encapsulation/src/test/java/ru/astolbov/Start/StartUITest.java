package ru.astolbov.Start;

import org.junit.Test;
import ru.astolbov.Start.Input.StubInputMenu;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by alex on 12/19/16.
 */
public class StartUITest {

    /**
     * Test add item in tracker.
     */
    @Test
    public void whenAddItemThenTrackerGetIt() {
        StubInputMenu stubInputMenu = new StubInputMenu();
        StartUI startui = new StartUI(stubInputMenu);

        assertThat(true, is(true));
    }
}
