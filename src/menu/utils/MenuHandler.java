package menu.utils;

import menu.ConsoleMenu;

import java.util.Scanner;

public class MenuHandler {

    private ConsoleMenu currentMenu;

    public MenuHandler(ConsoleMenu currentMenu) {
        this.currentMenu = currentMenu;
    }

    public void runMenu(Scanner consoleScanner) {

        while (currentMenu != null) {
            currentMenu.printMenuToConsole();
            currentMenu = currentMenu.chooseMenuOption(consoleScanner);
        }

        System.out.println("We hope to see you again!");
    }
}
