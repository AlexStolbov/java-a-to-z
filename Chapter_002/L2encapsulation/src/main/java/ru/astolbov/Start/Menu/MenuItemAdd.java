package ru.astolbov.Start.Menu;

import ru.astolbov.Models.Item;
import ru.astolbov.Start.Input.Input;
import ru.astolbov.Start.Tracker;

import java.util.ArrayList;

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
     * Add new item in tracker.
     * @param tracker - tracker
     * @param input - input
     * @return strings - array to show in console
     */
    public ArrayList<String> doCommandMenu(Tracker tracker, Input input) {
        String name = input.ask("Please, enter the task's name ");
        String description = input.ask("Please, enter the task's description ");

        Item item = new Item();
        item.setName(name);
        item.setDescription(description);
        tracker.addItem(item);

        ArrayList<String> list = new ArrayList<>();
        list.add("The task is added to the tracker: ".concat(System.lineSeparator()));
        list.add(item.toString().concat(System.lineSeparator()));
        return list;
    }

    /**
     * Return the flag of the output from the menu.
     * @return -  false
     */
    public boolean goExit() {
        return false;
    }
}