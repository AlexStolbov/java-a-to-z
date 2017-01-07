package ru.astolbov.Start.Menu;

import org.junit.Test;
import ru.astolbov.Models.Item;
import ru.astolbov.Start.Input.StubInput;
import ru.astolbov.Start.Tracker;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by alex on 1/5/17.
 */
public class MenuItemDeleteTest {

    /**
     * Test delete item.
     */
    @Test
    public void whenDeleteItemThenReturnOneElement() {
        Tracker tracker = new Tracker();
        tracker.addItem(new Item());

        String[] answers = new String[1];
        answers[0] = tracker.getItems()[0].getId();

        MenuItemDelete menuItemDelete = new MenuItemDelete();
        ArrayList<String> result = menuItemDelete.doCommandMenu(tracker, new StubInput(answers));

        assertThat(result.get(0), is("items deleted"));
    }

    /**
     * Test delete item.
     */
    @Test
    public void whenDeleteNoExistItemThenReturnOneElement() {
        Tracker tracker = new Tracker();

        String[] answers = new String[1];
        answers[0] = "-1";

        MenuItemDelete menuItemDelete = new MenuItemDelete();
        ArrayList<String> result = menuItemDelete.doCommandMenu(tracker, new StubInput(answers));

        assertThat(result.get(0), is("Item not found"));
    }
}