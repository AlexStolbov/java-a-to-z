package ru.astolbov.Start.Menu;

import ru.astolbov.Models.Item;
import ru.astolbov.Start.Input.StubInput;
import ru.astolbov.Start.Tracker;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by alex on 1/6/17.
 */
public class MenuItemEditTest {

    /**
     * Test edit item.
     */
    @Test
    public void whenEditItemThenItemsHaveNewName() {
        Tracker tracker = new Tracker();
        tracker.addItem(new Item());

        String[] answers = new String[2];
        answers[0] = tracker.getItems()[0].getId();
        answers[1] = "new name";

        MenuItemEdit menuItemEdit = new MenuItemEdit();
        ArrayList<String> result = menuItemEdit.doCommandMenu(tracker, new StubInput(answers));

        assertThat(result.get(0), is("Item is edited"));
    }

    /**
     * Test edit comment.
     */
    @Test
    public void whenEditNoExistItemThenDoNothing() {
        Tracker tracker = new Tracker();

        String[] answers = new String[2];
        answers[0] = "-1";
        answers[1] = "new name";

        MenuItemEdit menuItemEdit = new MenuItemEdit();
        ArrayList<String> result = menuItemEdit.doCommandMenu(tracker, new StubInput(answers));

        assertThat(result.get(0), is("Item not found"));
    }
}