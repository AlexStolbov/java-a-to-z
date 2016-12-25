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
     * Max items in tracker.
     */
    private int maxItems = 10;

    /**
     * Array of items.
     */
    private Item[] items = new Item[this.maxItems];

    /**
     * Create random items id.
     */
    private final Random rN = new Random();

    /**
     * Returm max items in tracker.
     * @return - int
     */
    public int getMaxItems() {
        return maxItems;
    }

    /**
     * Generate new items id.
     * @return new id
     */
    private String generateId() {
        return Integer.toString(rN.nextInt(1000));
    }

    /**
     * Find item by id.
     * @param findId - id
     * @return position of item
     */
    public int findById(String findId) {
        int posItem = -1;
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null && items[i].getId() == findId) {
                posItem = i;
                break;
            }
        }
        return posItem;
    }

    /**
     * Add new item.
     * @param item - new item.
     */
    public void addItem(Item item) {
        if (item != null && !(item.getId() != null && findById(item.getId()) > -1)) {
            item.setId(generateId());
            for (int i = 0; i < items.length; i++) {
                if (items[i] == null) {
                    items[i] = item;
                    break;
                }
            }
        }
    }

    /**
     * Edit item.
     * set new name and description
     * @param editId - id of item to edit
     * @param name - name
     * @param descr - description
     */
    public void editItem(String editId, String name, String descr) {
        int posItem = findById(editId);
        if (posItem > -1) {
            this.items[posItem].setName(name);
            this.items[posItem].setDescription(descr);
        }
    }

    /**
     * Delete item from array this.items.
     * @param deleteId - the id of item to be deleted
     */
    public void deleteItem(String deleteId) {
        int posItem = findById(deleteId);
        if (posItem > -1) {
            this.items[posItem] = null;
        }
    }

    /**
     * Getter for items.
     * @return - this.items
     */
    public Item[] getItems() {
        return this.items;
    }

}
