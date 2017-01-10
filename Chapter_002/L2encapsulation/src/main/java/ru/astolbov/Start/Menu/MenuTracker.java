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
     * Constructor.
     * @param trackerSet - tracker.
     * @param inputSet - input.
     * @param consoleOutputSet - output.
     */
    public MenuTracker(Tracker trackerSet, Input inputSet, ConsoleOutput consoleOutputSet) {
        this.menu = new MenuItem[7];
        this.menu[0] = new MenuItemAdd();
        this.menu[1] = new MenuItemEdit();
        this.menu[2] = new MenuItemDelete();
        this.menu[3] = new MenuItemList();
        this.menu[4] = new MenuItemFilteredList();
        this.menu[5] = new MenuItemAddComment();
        this.menu[6] = new MenuItemExit();

        this.tracker = trackerSet;
        this.input = inputSet;
        this.consoleOutput = consoleOutputSet;
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
        String numberMenuItem = input.ask("Please, enter number menu item: ");
        MenuItem selectedMenu;
        if (numberMenuItem.equals("")) {
            selectedMenu = null;
        } else {
            selectedMenu = menu[Integer.parseInt(numberMenuItem) - 1];
        }
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
    class MenuItemAdd implements MenuItem {
        /**
         * Define name of menu.
         * @return - name of menu
         */
        public String getMenuName() {
            return "Add new item";
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
        /**
         * Return the flag of the output from the menu.
         * @return -  false
         */
        public boolean goExit() {
            return false;
        }
    }

    /**
     * Created by alex on 12/21/16.
     */
    class MenuItemAddComment implements MenuItem {
        /**
         * Define name of menu.
         *
         * @return - name of menu
         */
        public String getMenuName() {
            return "Add comment";
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

        /**
         * Return the flag of the output from the menu.
         *
         * @return -  false
         */
        public boolean goExit() {
            return false;
        }
    }

    /**
     * Created by alex on 12/21/16.
     */
    class MenuItemDelete implements MenuItem {

        /**
         * Define name of menu.
         * @return - name of menu
         */
        public String getMenuName() {
            return "Delete item";
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

        /**
         * Return the flag of the output from the menu.
         * @return -  false
         */
        public boolean goExit() {
            return false;
        }
    }

    /**
     * Created by alex on 12/20/16.
     */
    class MenuItemEdit implements MenuItem {
        /**
         * Define name of menu.
         * @return - name of menu
         */
        public String getMenuName() {
            return "Edit item";
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

        /**
         * Return the flag of the output from the menu.
         * @return -  false
         */
        public boolean goExit() {
            return false;
        }
    }

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
         * @return strings - array to show
         */
        public ArrayList<String> doCommandMenu() {
            ArrayList<String> list = new ArrayList<>();
            for (Item item:tracker.getItems()) {
                if (item != null) {
                    list.add(item.toString().concat(System.lineSeparator()));
                }
            }
            if (list.size() == 1) {
                list.add("In the tracker there are no items ".concat(System.lineSeparator()));
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

    /**
     * Created by alex on 12/21/16.
     */
    class MenuItemFilteredList implements MenuItem {
        /**
         * Define name of menu.
         * @return - name of menu
         */
        public String getMenuName() {
            return "Show items filtered item";
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

        /**
         * Return the flag of the output from the menu.
         * @return -  false
         */
        public boolean goExit() {
            return false;
        }
    }

    /**
     * Created by alex on 12/21/16.
     */
    class MenuItemExit implements MenuItem {
        /**
         * Define name of menu.
         * @return - name of menu
         */
        public String getMenuName() {
            return "Exit";
        }

        /**
         * Actions that are performed when you select this menu.
         * @return strings - array to show
         */
        public ArrayList<String> doCommandMenu() {
            ArrayList<String> list = new ArrayList<>();
            list.add("-------- Goodbye! ---------");
            return list;
        }

        /**
         * Return the flag of the output from the menu.
         * @return -  true
         */
        public boolean goExit() {
            return true;
        }
    }

}
