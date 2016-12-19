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
     * Add new item to tracker.
     * @return added item
     */
    private Item addItem() {
        Item item = new Item();
        tracker.addItem(item);
        return item;
    }

    /**
     * Test add null in tracker.
     */
    @Test
    public void whenAddNullThenTrackerNoAddIt() {
        createTracker();
        tracker.addItem(null);
        assertThat(true, is(true));
    }

    /**
     * Test add item in tracker.
     */
	@Test
	public void whenAddItemThenTrackerGetIt() {
	    createTracker();
        Item[] items = new Item[8];
        for (int i = 0; i < items.length; i++) {
            items[i] = addItem();
        }

        boolean findAllItem = true;
        for (Item currentItem : items) {
            findAllItem = findAllItem & (tracker.findById(currentItem.getId()) > -1);
        }
		assertThat(findAllItem, is(true));
	}

    /**
     * Test add two items in tracker.
     */
    @Test
    public void whenAddTwoItemsThenTheyHaveDifferentId() {
        createTracker();
        Item itemOne = addItem();
        Item itemTwo = addItem();
        assertThat(itemOne.getId() == itemTwo.getId(), is(false));
    }

    /**
     * Test to add one item in the tracker twice.
     */
    @Test
    public void whenAddExistingItemThenTheyNotChangeId() {
        createTracker();
        Item item = addItem();
        String id = item.getId();
        tracker.addItem(item);
        assertThat(id == item.getId(), is(true));
    }

    /**
     * Test edit item in tracker.
     */
    @Test
    public void whenEditItemThenItemHaveNewState() {
        createTracker();
        Item item = addItem();
        String newName = "Get work";
        String newDescription = "time is money";
        tracker.editItem(item.getId(), newName, newDescription);
        assertThat(item.getName().equals(newName) & item.getDescription().equals(newDescription), is(true));
    }

    /**
     * Test find by id.
     */
    @Test
    public void whenFindByIdThenGetPosOnArrayOfItems() {
        createTracker();
        Item item = addItem();
        assertThat(tracker.findById(item.getId()) > -1, is(true));
    }

    /**
     * Test deleting item.
     */
    @Test
    public void whenDeleteItemThenTrackerHasNoIt() {
        createTracker();
        Item item = addItem();
        String id = item.getId();
        tracker.deleteItem(id);
        assertThat(tracker.findById(id) > -1, is(false));
    }

    /**
     * Test getter items.
     */
    @Test
    public void whenGetItemsThenGetNotNullArrayOfItems() {
        createTracker();
        addItem();
        Item[] items = tracker.getItems();
        assertThat(items != null, is(true));
    }
}