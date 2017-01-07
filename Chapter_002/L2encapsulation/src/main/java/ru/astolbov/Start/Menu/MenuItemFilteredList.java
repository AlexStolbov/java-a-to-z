package ru.astolbov.Start.Menu;

import ru.astolbov.Models.Item;
import ru.astolbov.Start.Input.Input;
import ru.astolbov.Start.Tracker;

import java.util.ArrayList;

/**
 * Created by alex on 12/21/16.
 */
public class MenuItemFilteredList implements MenuItem {
    /**
     * Define name of menu.
     * @return - name of menu
     */
    public String getMenuName() {
        return "Show items filtered item";
    }

    /**
     * Actions that are performed when you select this menu.
     * @param tracker - tracker
     * @param input - input
     * @return strings - array to show
     */
    public ArrayList<String> doCommandMenu(Tracker tracker, Input input) {

       ArrayList<String> list = new ArrayList<>();

        String filter = input.ask("Please, enter filter ");

        list.add("------- Filtered list of items -----------".concat(System.lineSeparator()));

        for (Item item:tracker.getItems()) {
            if (item != null && item.getName().contains(filter)) {
                list.add(item.toString().concat(System.lineSeparator()));
            }
        }
        if (list.size() == 1) {
            list.add("No found items ".concat(System.lineSeparator()));
        }

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
