package menu;

import utils.QuizPlayer;

import java.util.ArrayList;
import java.util.Scanner;

public class LoginMenu extends SimpleMenu {

    public LoginMenu(String name, ArrayList<SimpleMenu> options) {
        super(name, options);
    }

    @Override
    public void printMenuToConsole() {
        System.out.println(name);
        System.out.println("Please enter your name:");
    }

    @Override
    public ConsoleMenu chooseMenuOption(Scanner consoleScanner) {

        QuizPlayer.getInstance().setName(consoleScanner.nextLine());

        return options.get(0);
    }
}
