package menu;

import database.DatabaseConnector;
import players.CurrentPlayer;
import players.QuizPlayer;

import java.sql.SQLException;
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

        CurrentPlayer.getInstance().setName(consoleScanner.nextLine());

        try {

            QuizPlayer existingPlayer = DatabaseConnector.retrievePlayerByName(CurrentPlayer.getInstance().getName());

            if (existingPlayer == null) {
                DatabaseConnector.saveNewPlayer(CurrentPlayer.getInstance());
                System.out.println("Ooh, NEW BLOOD! Welcome, " + CurrentPlayer.getInstance().getName());
            } else {
                CurrentPlayer.getInstance().setId(existingPlayer.getId());
                CurrentPlayer.getInstance().setBinScore(existingPlayer.getBinScore());
                CurrentPlayer.getInstance().setMcqScore(existingPlayer.getMcqScore());
                System.out.println("Welcome back, " + existingPlayer.getName());
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Database connection failed. You will not be able to save your score.");
        }

        return options.get(0);
    }
}
