package ru.astolbov.Start.Menu;

import ru.astolbov.Start.Input.Input;
import ru.astolbov.Start.Tracker;

/**
 * Created by alex on 12/21/16.
 */
public class MenuItemExit implements MenuItem {
    /**
     * Define name of menu.
     * @return - name of menu
     */
    public String getMenuName() {
        return "Exit";
    }

    /**
     * Actions that are performed when you select this menu.
     * @param tracker - tracker
     * @param input - input
     */
    public void doCommandMenu(Tracker tracker, Input input) {
    }

    /**
     * Return the flag of the output from the menu.
     * @return -  true
     */
    public boolean goExit() {
        return true;
    }
}
