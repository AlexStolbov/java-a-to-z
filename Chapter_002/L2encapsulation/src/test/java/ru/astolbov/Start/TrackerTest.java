package ru.astolbov.Start;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import ru.astolbov.Models.Item;

/**
 * Class TrackerTest.
 * Тест класса Tracker
 * @author stolbov
 * @since 15.12.2016
 */

public class TrackerTest {
    /**
     * instance of class Tracker for test.
     */
    private Tracker tracker = null;

    /**
     * Creates test instance.
     */
    private void createTracker() {
        if (tracker == null) {
            tracker = new Tracker();
        }
    }

    /**
     * Test add item in tracker.
     * First add an item to the tracker, then finding it.
     */
	@Test
	public void whenAddItemThenTrackerGetIt() {
	    createTracker();
        Item item = new Item();
        tracker.addItem(item);
        Item[] items = tracker.getItems();
        boolean findItem = false;
        for (Item currentItem : items) {
            if (currentItem.equals(item)) {
                findItem = true;
                break;
            }
        }
		assertThat(findItem, is(true));
	}

    /**
     * Test edit item in tracker.
     */
    @Test
    public void whenEditItemThenItemHaveNewState() {
        createTracker();
        Item item = new Item();
        tracker.addItem(item);
        String newName = "Get work";
        String newDescription = "time is money";
        tracker.editItem(item, newName, newDescription);
        boolean itemIsEdit;
        itemIsEdit = (item.getName().equals(newName) & item.getDescription().equals(newDescription));

        assertThat(itemIsEdit, is(true));
    }

    /**
     * Test deleting item.
     */
    @Test
    public void whenDeleteItemThenTrackerHasNoIt() {
        createTracker();
        Item item = new Item();
        tracker.addItem(item);
        Item[] items = tracker.getItems();
        tracker.deleteItem(item);

        boolean findItem = false;
        for (Item currentItem : items) {
            if (currentItem != null) {
                if (currentItem.equals(item)) {
                    findItem = true;
                    break;
                }
            }
        }
        assertThat(findItem, is(false));
    }

    /**
     * Test getter items.
     */
    public void whenGetItemsThenGetItems() {
        createTracker();
        Item item = new Item();
        tracker.addItem(item);
        Item[] items = tracker.getItems();
        assertThat(items != null, is(true));
    }
}