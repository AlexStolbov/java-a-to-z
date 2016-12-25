package ru.astolbov.Start;

import ru.astolbov.Start.Input.ConsoleInput;
import ru.astolbov.Start.Input.Input;
import ru.astolbov.Start.Menu.MenuItem;
import ru.astolbov.Start.Menu.MenuItemAdd;
import ru.astolbov.Start.Menu.MenuItemDelete;
import ru.astolbov.Start.Menu.MenuItemEdit;
import ru.astolbov.Start.Menu.MenuItemList;
import ru.astolbov.Start.Menu.MenuItemFilteredList;
import ru.astolbov.Start.Menu.MenuItemAddComment;
import ru.astolbov.Start.Menu.MenuItemExit;

/**
 * Created by alex on 12/13/16.
 */
public class StartUI {
    /**
     * Line separator.
     */
    private String lineseparator = System.getProperty("line.separator");
    /**
     * Tracker
     */
    private Tracker tracker;
    /*

     */
    private Input input;
    private MenuItem[] menu;

    public StartUI(Input inputSet) {
        this.menu = new MenuItem[7];
        this.menu[0] = new MenuItemAdd();
        this.menu[1] = new MenuItemEdit();
        this.menu[2] = new MenuItemDelete();
        this.menu[3] = new MenuItemList();
        this.menu[4] = new MenuItemFilteredList();
        this.menu[5] = new MenuItemAddComment();
        this.menu[6] = new MenuItemExit();

        if (inputSet == null) {
            this.input = new ConsoleInput();
        } else {
            this.input = inputSet;
        }

        this.tracker = new Tracker();
    }

    public int begin() {
        boolean exit;
        MenuItem selectedMenu;
        do {
            selectedMenu = this.showMenu();
            if (selectedMenu != null) {
                exit = selectedMenu.goExit();
                if (!exit) {
                    System.out.println("");
                    selectedMenu.doCommandMenu(tracker, input);
                    System.out.println("");
                }
            } else {
                exit = false;
            }
        } while (!exit);
        System.out.println("---------------------------");
        System.out.println("-------- Goodbye! ---------");
        System.out.println("---------------------------");
        return 0;
    }

    private MenuItem showMenu () {
        System.out.println("======== Main menu ===========");
        for (int i = 0; i < this.menu.length; i++) {
            System.out.printf("%s. %s %s", Integer.toString(i + 1), this.menu[i].getMenuName(), lineseparator);
        }
        String numberMenuItem = input.ask("Please, enter number menu item: ");
        MenuItem selectedMenu;
        if (numberMenuItem.equals("")) {
            selectedMenu = null;
        } else {
            selectedMenu = menu[Integer.parseInt(numberMenuItem) - 1];
        }
        return selectedMenu;
    }

    /**
     * Getter menu.
     * @return
     */

    public MenuItem[] getMenu() {
        return menu;
    }

    /**
     * Main.
     * @param args - line parameters
     */
    public static void main(String[] args) {
        ConsoleInput inputConsole = new ConsoleInput();
        StartUI startui = new StartUI(inputConsole);
        int finishCode = startui.begin();
    }
}
