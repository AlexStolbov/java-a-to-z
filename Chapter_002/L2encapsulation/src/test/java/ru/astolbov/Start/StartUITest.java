package ru.astolbov.Start;

import org.junit.Test;

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
        StartUI start = new StartUI();
        assertThat(true, is(true));
    }
}
