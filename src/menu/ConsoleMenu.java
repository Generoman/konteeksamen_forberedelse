package menu;

import java.util.Scanner;

public interface ConsoleMenu {

    void printMenuToConsole();

    ConsoleMenu chooseMenuOption(Scanner consoleScanner);
}
