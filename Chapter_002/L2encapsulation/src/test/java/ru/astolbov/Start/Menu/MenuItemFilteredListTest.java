package ru.astolbov.Start.Menu;

import org.junit.Test;
import ru.astolbov.Models.Item;
import ru.astolbov.Start.Input.ConsoleOutput;
import ru.astolbov.Start.Input.StubInput;
import ru.astolbov.Start.Tracker;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by alex on 1/10/17.
 */
public class MenuItemFilteredListTest {

    /**
     * Test filtered list.
     */
    @Test
    public void whenFilterListThenListContainFilter() {
        Tracker tracker = new Tracker();
        tracker.addItem(new Item());
        tracker.addItem(new Item());
        tracker.addItem(new Item());
        tracker.getItems()[0].setName("test1");
        tracker.getItems()[1].setName("test2");
        tracker.getItems()[2].setName("other");

        String[] answers = new String[1];
        answers[0] = "test";

        MenuTracker menuTracker = new MenuTracker(tracker, new StubInput(answers), new ConsoleOutput());
        MenuTracker.MenuItemFilteredList menuItemFilteredList = menuTracker.new MenuItemFilteredList();

        ArrayList<String> result = menuItemFilteredList.doCommandMenu();

        assertThat(result.size(), is(2));
    }
}