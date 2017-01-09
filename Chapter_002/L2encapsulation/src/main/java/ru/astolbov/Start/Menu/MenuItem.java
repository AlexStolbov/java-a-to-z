package ru.astolbov.Start.Menu;

import ru.astolbov.Start.Input.Input;
import ru.astolbov.Start.Tracker;

import java.util.ArrayList;

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
     * @return strings - array to show
     */
    ArrayList<String> doCommandMenu();

    /**
     * Return the flag of the output from the menu.
     * @return -  flag "Exit"
     */
    boolean goExit();
}
