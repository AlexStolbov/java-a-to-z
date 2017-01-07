package ru.astolbov.Start.Menu;

import ru.astolbov.Models.Item;
import ru.astolbov.Start.Input.Input;
import ru.astolbov.Start.Tracker;

import java.util.ArrayList;

/**
 * Created by alex on 12/21/16.
 */
public class MenuItemAddComment implements MenuItem {
    /**
     * Define name of menu.
     * @return - name of menu
     */
    public String getMenuName() {
        return "Add comment";
    }

    /**
     * Add comment to item.
     * @param tracker - tracker
     * @param input - input
     * @return strings - array to show
     */
    public ArrayList<String> doCommandMenu(Tracker tracker, Input input) {
        ArrayList<String> list = new ArrayList<>();
        String itemsID = input.ask("Please, enter items ID ");
        int posItem = tracker.findById(itemsID);
        if (posItem > -1) {
            Item item = tracker.getItems()[posItem];
            String comment = input.ask("Please, enter comment ");
            item.addComment(comment);
            list.add("comment is added");
        } else {
            list.add("Item not found");
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
