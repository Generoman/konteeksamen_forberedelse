package menu;

import players.CurrentPlayer;
import players.QuizPlayer;

import java.util.ArrayList;

public class MainMenu extends SimpleMenu {

    public MainMenu(ArrayList<SimpleMenu> options) {
        super("Main Menu", options);
    }

    @Override
    public void printMenuToConsole() {
        System.out.println(name);
        System.out.println("Player: " + CurrentPlayer.getInstance().getName());
        for (int i = 0; i < options.size(); i++) {
            System.out.println(i + 1 + " - " + options.get(i).getName());
        }
        System.out.println("0 - Quit");
    }
}
