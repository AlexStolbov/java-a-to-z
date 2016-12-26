package ru.astolbov.Start;

import ru.astolbov.Start.Input.ConsoleInput;
import ru.astolbov.Start.Input.ConsoleOutput;
import ru.astolbov.Start.Input.Input;
import ru.astolbov.Start.Menu.MenuItem;
import ru.astolbov.Start.Menu.MenuItemAdd;
import ru.astolbov.Start.Menu.MenuItemDelete;
import ru.astolbov.Start.Menu.MenuItemEdit;
import ru.astolbov.Start.Menu.MenuItemList;
import ru.astolbov.Start.Menu.MenuItemFilteredList;
import ru.astolbov.Start.Menu.MenuItemAddComment;
import ru.astolbov.Start.Menu.MenuItemExit;

import java.util.ArrayList;

/**
 * Created by alex on 12/13/16.
 */
public class StartUI {
    /**
     * Line separator.
     */
    public static final String LINESEPARATOR = System.getProperty("line.separator");

    /**
     * Tracker.
     */
    private Tracker tracker;

    /**
     Input source.
     */
    private Input input;

    /**
     * Print string array on console.
     */
    private ConsoleOutput consoleOut;

    /**
     * Menu in console.
     */
    private MenuItem[] menu;

    /**
     * Constructor.
     * @param inputSet - console or array
     */
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

        consoleOut = new ConsoleOutput();

        this.tracker = new Tracker();

    }

    /**
     * Start program.
     * @return - 0
     */
    public int begin() {
        boolean exit;
        do {
            MenuItem selectedMenu = this.showMenuRequestItem();
            if (selectedMenu != null) {
                ArrayList<String> commandResult = selectedMenu.doCommandMenu(tracker, input);
                consoleOut.toConsole(commandResult);
                exit = selectedMenu.goExit();
            } else {
                exit = false;
            }
        } while (!exit);
        return 0;
    }

    /**
     * Показать меню и запросить пункт.
     * @return - selected menu.
     */
    private MenuItem showMenuRequestItem() {
        System.out.println("======== Main menu ===========");
        for (int i = 0; i < this.menu.length; i++) {
            System.out.printf("%s. %s %s", Integer.toString(i + 1), this.menu[i].getMenuName(), LINESEPARATOR);
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
     * @return array of menu items
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
