package ru.astolbov.Start.Menu;

import ru.astolbov.Models.Item;
import ru.astolbov.Start.Input.Input;
import ru.astolbov.Start.Tracker;

/**
 * Created by alex on 12/21/16.
 */
public class MenuItemList implements MenuItem {

    /**
     * Line separator.
     */
    private final String lineseparator = System.getProperty("line.separator");

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
     */
    public void doCommandMenu(Tracker tracker, Input input) {
        int showItems = 0;
        System.out.printf("%s %s", "------- List of items -----------", lineseparator);
        for (Item item:tracker.getItems()) {
            if (item != null) {
                System.out.printf("%s %s", item.toString(), lineseparator);
                showItems++;
            }
        }
        if (showItems == 0) {
            System.out.printf("%s %s", "In the tracker there are no items ", lineseparator);
        }
    }
}
