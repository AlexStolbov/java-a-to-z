package ru.astolbov.Start.Menu;

import ru.astolbov.Start.Input.Input;
import ru.astolbov.Start.Tracker;

/**
 * Created by alex on 12/20/16.
 */
public class MenuItemEdit implements MenuItem {
    /**
     * Define name of menu.
     * @return - name of menu
     */
    public String getMenuName() {
        return "Edit item";
    }

    /**
     * Actions that are performed when you select this menu.
     * @param tracker - tracker
     * @param input - input
     */
    public void doCommandMenu(Tracker tracker, Input input) {
        System.out.println(">>>>>>>>>>>>>>>> do edit menu ");
    }
}
