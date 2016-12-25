package ru.astolbov.Start.Menu;

import ru.astolbov.Start.Input.Input;
import ru.astolbov.Start.Tracker;

/**
 * Created by alex on 12/20/16.
 */
public interface MenuItem {
    /**
     * Define name of menu.
     * @return - name of menu
     */
    String getMenuName();

    /**
     * Actions that are performed when you select this menu.
     * @param tracker - tracker
     * @param input - input
     */
    void doCommandMenu(Tracker tracker, Input input);

    /**
     * Return the flag of the output from the menu.
     * @return -  flag "Exit"
     */
    default boolean goExit() {
        return false;
    }
}
