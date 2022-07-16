package menu;

import dao.PlayerDao;
import players.CurrentPlayer;
import players.QuizPlayer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class LoginMenu extends SimpleMenu {

    private final PlayerDao playerDao;

    public LoginMenu(ArrayList<SimpleMenu> options, PlayerDao playerDao) {
        super("Login", options);
        this.playerDao = playerDao;
    }

    @Override
    public void printMenuToConsole() {
        System.out.println(name);
        System.out.println("Please enter your name:");
    }

    @Override
    public ConsoleMenu chooseMenuOption(Scanner consoleScanner) {

        String playerName = consoleScanner.nextLine();

        try {
            QuizPlayer existingPlayer = playerDao.retrieveByName(playerName);
            if (existingPlayer == null) throw new SQLException();
            CurrentPlayer.set(existingPlayer);
            System.out.println("Welcome back, " + existingPlayer.getName());
        } catch (SQLException exception) {
            System.out.println("We have a new player!");
            System.out.println("Welcome, " + playerName);
        }

        try {
            QuizPlayer newPlayer = playerDao.save(new QuizPlayer(playerName));
            CurrentPlayer.set(newPlayer);
        } catch (SQLException exception) {
            exception.printStackTrace();
            CurrentPlayer.set(new QuizPlayer(playerName));
            System.out.println("Database connection failed");
            System.out.println("You will not be able to save your score");
        }

        return menuOptions.get(0);
    }
}
