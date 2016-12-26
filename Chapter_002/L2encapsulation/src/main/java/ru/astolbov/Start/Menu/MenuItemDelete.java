package ru.astolbov.Start.Menu;

import ru.astolbov.Start.Input.Input;
import ru.astolbov.Start.Tracker;

import java.util.ArrayList;

/**
 * Created by alex on 12/21/16.
 */
public class MenuItemDelete implements MenuItem {

    /**
     * Define name of menu.
     * @return - name of menu
     */
    public String getMenuName() {
        return "Delete item";
    }

    /**
     * Actions that are performed when you select this menu.
     * @param tracker - tracker
     * @param input - input
     * @return strings - array to show
     */
    public ArrayList<String> doCommandMenu(Tracker tracker, Input input) {

        ArrayList<String> list = new ArrayList<>();
        list.add("Delete item");
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
