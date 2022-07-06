package menu;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class SimpleMenu implements ConsoleMenu {

    // Fields

    protected String name;
    protected ArrayList<SimpleMenu> options;


    // Constructors

    public SimpleMenu(String name, ArrayList<SimpleMenu> options) {
        this.name = name;
        this.options = options;
    }

    public SimpleMenu(String name) {
        this.name = name;
    }


    // Getters/setters

    public String getName() {
        return name;
    }


    // Methods

    @Override
    public void printMenuToConsole() {
        System.out.println(name);
        if (options != null) {
            for (int i = 0; i < options.size(); i++) {
                System.out.println(i + 1 + " - " + options.get(i).getName());
            }
        } else {
            System.out.println("No menu options found");
        }
        System.out.println("0 - Back to previous menu");
    }

    @Override
    public void chooseMenuOption(Scanner consoleScanner) {
        String userChoice = consoleScanner.nextLine();
        if (!Objects.equals(userChoice, "0")) {
            int convertedChoice = Integer.parseInt(userChoice) - 1;
            SimpleMenu sub = options.get(convertedChoice);
            sub.printMenuToConsole();
            sub.chooseMenuOption(consoleScanner);
        }
    }
}
