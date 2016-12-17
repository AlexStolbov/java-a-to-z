package ru.astolbov.Start;

import ru.astolbov.Models.Item;
import java.util.Random;

/**
 * Tracker.
 * Выполняет роль базы для задач
 * Created by alex on 12/13/16.
 */
public class Tracker {
    /**
     * Array of items.
     */
    private Item[] items = new Item[10];

    /**
     * Last added position in this.items.
     */
    private int lastItemsPos = 0;

    /**
     * Create random items id.
     */
    private final Random rN = new Random();

    /**
     * Add new item.
     * @param item - new item.
     */
    public void addItem(Item item) {
        item.setId(generateId());
        items[lastItemsPos] = item;
        lastItemsPos++;
    }

    /**
     * Generate new items id.
     * @return new id
     */
    private String generateId() {
        return Integer.toString(rN.nextInt(100000));
    }

    /**
     * Edit item.
     * set new name and description
     * @param item - item
     * @param name - name
     * @param descr - description
     */
    public void editItem(Item item, String name, String descr) {
        item.setName(name);
        item.setDescription(descr);
    }

    /**
     * Delete item from array this.items.
     * @param item - the item to be deleted
     */
    public void deleteItem(Item item) {
        for (int i = 0; i < lastItemsPos; i++) {
            if (items[i] != null) {
                if (items[i].equals(item)) {
                    items[i] = null;
                    if (lastItemsPos == i + 1) {
                        lastItemsPos--;
                    }
                }
            }
        }
    }

    /**
     * Getter for items.
     * @return - this.items
     */
    public Item[] getItems() {
        return items;
    }

}
