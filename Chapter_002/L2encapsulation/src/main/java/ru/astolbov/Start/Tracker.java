package ru.astolbov.Start;

import ru.astolbov.Models.Item;
import java.util.Random;

/**
 * Tracker
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
}
