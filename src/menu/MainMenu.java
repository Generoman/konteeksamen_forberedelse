package menu;

import java.util.ArrayList;

public class MainMenu extends SimpleMenu {

    public MainMenu(ArrayList<SimpleMenu> options) {
        super("Main Menu", options);
    }

    @Override
    public void printMenuToConsole() {
        printMenuHeader();
        for (int i = 0; i < menuOptions.size(); i++) {
            System.out.println(i + 1 + " - " + menuOptions.get(i).getName());
        }
        System.out.println("0 - Quit");
    }
}
