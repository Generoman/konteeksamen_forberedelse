package menu;

import players.CurrentPlayer;
import utils.UtilData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SimpleMenu implements ConsoleMenu {

    // Fields

    protected SimpleMenu previousMenu;
    protected String name;
    protected ArrayList<SimpleMenu> menuOptions;


    // Constructors

    public SimpleMenu(String name, ArrayList<SimpleMenu> options) {
        this.name = name;
        this.menuOptions = options;
    }

    public SimpleMenu(String name) {
        this.name = name;
    }


    // Getters/setters

    public String getName() {
        return name;
    }

    public void setPreviousMenu(SimpleMenu previousMenu) {
        this.previousMenu = previousMenu;
    }


    // Methods

    @Override
    public void printMenuToConsole() {
        printMenuHeader();
        if (menuOptions != null) {
            for (int i = 0; i < menuOptions.size(); i++) {
                System.out.println(i + 1 + " - " + menuOptions.get(i).getName());
            }
        } else {
            System.out.println("No menu options found");
        }
        System.out.println("0 - Back to previous menu");
    }

    @Override
    public ConsoleMenu chooseMenuOption(Scanner consoleScanner) {

        String userChoice = consoleScanner.nextLine();

        if (!Arrays.asList(UtilData.DIGITS).contains(userChoice)) {
            System.out.println("Please choose a valid menu option");
            return this;
        }

        if (userChoice.equals("0")) {
            return previousMenu;
        }

        int indexChoice = Integer.parseInt(userChoice) - 1;

        if (indexChoice >= menuOptions.size()) {
            System.out.println("Please choose a valid menu option");
            return this;
        }

        return menuOptions.get(indexChoice);
    }

    protected void printMenuHeader() {
        System.out.println(name);
        System.out.println("Player: " + CurrentPlayer.get().getName());
    }
}
