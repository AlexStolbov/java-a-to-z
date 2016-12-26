package ru.astolbov.Start.Menu;

import ru.astolbov.Models.Item;
import ru.astolbov.Start.Input.Input;
import ru.astolbov.Start.StartUI;
import ru.astolbov.Start.Tracker;

import java.util.ArrayList;

/**
 * Created by alex on 12/21/16.
 */
public class MenuItemList implements MenuItem {

    /**
     * Define name of menu.
     * @return - name of menu
     */
    public String getMenuName() {
        return "Show items list";
    }

    /**
     * Actions that are performed when you select this menu.
     * @param tracker - tracker
     * @param input - input
     * @return strings - array to show
     */
    public ArrayList<String> doCommandMenu(Tracker tracker, Input input) {
        ArrayList<String> list = new ArrayList<>();
        list.add("------- List of items -----------".concat(StartUI.LINESEPARATOR));

        for (Item item:tracker.getItems()) {
            if (item != null) {
                list.add(item.toString().concat(StartUI.LINESEPARATOR));
            }
        }
        if (list.size() == 1) {
            list.add("In the tracker there are no items ".concat(StartUI.LINESEPARATOR));
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
