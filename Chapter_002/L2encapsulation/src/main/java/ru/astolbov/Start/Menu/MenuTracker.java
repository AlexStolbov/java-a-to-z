package ru.astolbov.Start.Menu;

import ru.astolbov.Models.Item;
import ru.astolbov.Start.Input.ConsoleOutput;
import ru.astolbov.Start.Input.Input;
import ru.astolbov.Start.Tracker;

import java.util.ArrayList;

/**
 * Created by alex on 1/9/17.
 */
public class MenuTracker {
    /**
     * Main menu.
    */
    private MenuItem[] menu;

    /**
     * Tracker.
     */
    private Tracker tracker;

    /**
     * Input method.
     */
    private Input input;

    /**
     * Output.
     */
    private ConsoleOutput consoleOutput;

    /**
     * Position of new menu.
     */
    private int newMenuPosition = 0;

    /**
     * Constructor.
     * @param trackerSet - tracker.
     * @param inputSet - input.
     * @param consoleOutputSet - output.
     */
    public MenuTracker(Tracker trackerSet, Input inputSet, ConsoleOutput consoleOutputSet) {
        this.menu = new MenuItem[7];
        this.menu[newMenuPosition++] = new MenuItemAdd();
        this.menu[newMenuPosition++] = new MenuItemEdit();
        this.menu[newMenuPosition++] = new MenuItemDelete();
        this.menu[newMenuPosition++] = new MenuItemList();
        this.menu[newMenuPosition++] = new MenuItemFilteredList();
        this.menu[newMenuPosition++] = new MenuItemAddComment();

        this.tracker = trackerSet;
        this.input = inputSet;
        this.consoleOutput = consoleOutputSet;
    }

    /**
     * Add new item.
     * @param menuItem - new item.
     */
    public void addItem(MenuItem menuItem) {
        this.menu[newMenuPosition++] = menuItem;
    }

    /**
     * Показать меню и запросить пункт.
     * @return - selected menu.
     */
    public boolean showMenuRequestItem() {
        System.out.println("======== Main menu ===========");
        for (int i = 0; i < this.menu.length; i++) {
            System.out.printf("%s. %s %s", Integer.toString(i + 1), this.menu[i].getMenuName(), System.lineSeparator());
        }

        int numberMenuItem = input.ask("Please, enter number menu item: ", this.menu.length);
        MenuItem selectedMenu = menu[--numberMenuItem];

        boolean exit;
        if (selectedMenu != null) {
            ArrayList<String> commandResult = selectedMenu.doCommandMenu();
            consoleOutput.toConsole(commandResult);
            exit = selectedMenu.goExit();
        } else {
            exit = false;
        }
        return exit;
    }

    /**
     * Created by alex on 12/20/16.
     */
    class MenuItemAdd extends BaseItem {
        /**
         * Set name and exit flag of item.
         */
        MenuItemAdd() {
            super("Add new item", false);
        }

        /**
         * Add new item in tracker.
         * @return strings - array to show in console
         */
        public ArrayList<String> doCommandMenu() {
            String name = input.ask("Please, enter the task's name ");
            String description = input.ask("Please, enter the task's description ");

            Item item = new Item();
            item.setName(name);
            item.setDescription(description);
            tracker.addItem(item);

            ArrayList<String> list = new ArrayList<>();
            list.add("The task is added to the tracker: ".concat(System.lineSeparator()));
            list.add(item.toString().concat(System.lineSeparator()));
            return list;
        }
    }

    /**
     * Created by alex on 12/21/16.
     */
    class MenuItemAddComment extends BaseItem {

        /**
         * Set name and exit flag of item.
         */
        MenuItemAddComment() {
            super("Add comment", false);
        }

        /**
         * Add comment to item.
         * @return strings - array to show
         */
        public ArrayList<String> doCommandMenu() {
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
    }

    /**
     * Created by alex on 12/21/16.
     */
    class MenuItemDelete extends BaseItem {

        /**
         * Set name and exit flag of item.
         */
        MenuItemDelete() {
            super("Delete item", false);
        }

        /**
         * Actions that are performed when you select this menu.
         * @return strings - array to show
         */
        public ArrayList<String> doCommandMenu() {
            ArrayList<String> list = new ArrayList<>();
            String itemsID = input.ask("Please, enter items ID ");
            int posItem = tracker.findById(itemsID);
            if (posItem > -1) {
                tracker.deleteItem(itemsID);
                list.add("items deleted");
            } else {
                list.add("Item not found");
            }
            return list;
        }
    }

    /**
     * Created by alex on 12/20/16.
     */
    class MenuItemEdit extends BaseItem {
        /**
         * Set name and exit flag of item.
         */
        MenuItemEdit() {
            super("Edit item", false);
        }

        /**
         * Actions that are performed when you select this menu.
         * @return strings - array to show
         */
        public ArrayList<String> doCommandMenu() {
            ArrayList<String> list = new ArrayList<>();
            String itemsID = input.ask("Please, enter items ID ");
            int posItem = tracker.findById(itemsID);
            if (posItem > -1) {
                Item item = tracker.getItems()[posItem];
                String newName = input.ask("Please, new name ");
                item.setName(newName);
                list.add("Item is edited");
            } else {
                list.add("Item not found");
            }
            return list;
        }
    }

    /**
     * Created by alex on 12/21/16.
     */
    public class MenuItemList extends BaseItem {
        /**
         * Set name and exit flag of item.
         */
        MenuItemList() {
            super("Items list", false);
        }

        /**
         * Actions that are performed when you select this menu.
         * @return strings - array to show
         */
        public ArrayList<String> doCommandMenu() {
            ArrayList<String> list = new ArrayList<>();
            for (Item item:tracker.getItems()) {
                if (item != null) {
                    list.add(item.toString().concat(System.lineSeparator()));
                }
            }
            if (list.size() == 0) {
                list.add("No items in the tracker ".concat(System.lineSeparator()));
            }
            return list;
        }
    }

    /**
     * Created by alex on 12/21/16.
     */
    class MenuItemFilteredList extends BaseItem {
        /**
         * Set name and exit flag of item.
         */
        MenuItemFilteredList() {
            super("Show items filtered item", false);
        }

        /**
         * Actions that are performed when you select this menu.
         * @return strings - array to show
         */
        public ArrayList<String> doCommandMenu() {
            ArrayList<String> list = new ArrayList<>();
            String filter = input.ask("Please, enter filter ");
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
    }
}
