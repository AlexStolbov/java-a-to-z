package ru.astolbov.Start.Menu;

import org.junit.Test;
import ru.astolbov.Start.Tracker;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by alex on 12/30/16.
 */
public class MenuItemAddTest {

    /**
     * Test menu name.
     */
    @Test
    public void whenGetMenuNameThenGetIt() {
        MenuItemAdd menuAdd = new MenuItemAdd();
        Tracker tracker = new Tracker();

        assertThat(menuAdd.getMenuName(), is("Add new item"));
    }
}