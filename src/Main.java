import menu.MainMenu;
import menu.SimpleMenu;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        SimpleMenu sub1 = new SimpleMenu("sub1");
        SimpleMenu sub2 = new SimpleMenu("sub2");

        ArrayList<SimpleMenu> menuOptions = new ArrayList<>();
        menuOptions.add(sub1);
        menuOptions.add(sub2);

        MainMenu sup = new MainMenu(menuOptions);

        Scanner consoleScanner = new Scanner(System.in);

        while (sup.isRunning) {
            sup.printMenuToConsole();
            sup.chooseMenuOption(consoleScanner);
        }

        System.out.println("We hope to see you again!");
    }
}
