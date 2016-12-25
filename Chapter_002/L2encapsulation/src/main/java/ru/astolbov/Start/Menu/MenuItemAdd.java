package ru.astolbov.Start.Menu;

import ru.astolbov.Models.Item;
import ru.astolbov.Start.Input.Input;
import ru.astolbov.Start.Tracker;

/**
 * Created by alex on 12/20/16.
 */
public class MenuItemAdd implements MenuItem {

    /**
     * Define name of menu.
     * @return - name of menu
     */
    public String getMenuName() {
        return "Add new item";
    }

    /**
     * Actions that are performed when you select this menu.
     * @param tracker - tracker
     * @param input - input
     */
    public void doCommandMenu(Tracker tracker, Input input) {
        String name = input.ask("Please, enter the task's name ");
        Item item = new Item();
        item.setName(name);
        tracker.addItem(item);

    }
}
