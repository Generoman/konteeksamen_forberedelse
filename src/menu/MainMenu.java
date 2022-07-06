package menu;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class MainMenu extends SimpleMenu {

    public boolean isRunning = true;

    public MainMenu(ArrayList<SimpleMenu> options) {
        super("Main Menu", options);
    }

    @Override
    public void printMenuToConsole() {
        System.out.println(name);
        for (int i = 0; i < options.size(); i++) {
            System.out.println(i + 1 + " - " + options.get(i).getName());
        }
        System.out.println("0 - Quit");
    }

    @Override
    public void chooseMenuOption(Scanner consoleScanner) {
        String userChoice = consoleScanner.nextLine();
        if (Objects.equals(userChoice, "0")) {
            isRunning = false;
        } else {
            int convertedChoice = Integer.parseInt(userChoice) - 1;
            SimpleMenu sub = options.get(convertedChoice);
            sub.printMenuToConsole();
            sub.chooseMenuOption(consoleScanner);
        }
    }
}
