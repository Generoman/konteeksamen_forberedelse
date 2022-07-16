package menu;

import dao.PlayerDao;
import players.CurrentPlayer;
import questions.BinaryQuestion;
import questions.GenericQuestion;
import players.QuizPlayer;

import java.sql.SQLException;
import java.util.*;

public class QuizMenu extends SimpleMenu {

    private final ArrayList<GenericQuestion> questionSet;
    private final PlayerDao playerDao;

    public QuizMenu(String name, ArrayList<GenericQuestion> questionSet, PlayerDao playerDao) {
        super(name);
        this.questionSet = questionSet;
        this.playerDao = playerDao;
    }

    @Override
    public void printMenuToConsole() {
        printMenuHeader();
        System.out.println("1 - Take quiz");
        System.out.println("2 - Scoreboard");
        System.out.println("0 - Back to previous menu");
    }

    @Override
    public ConsoleMenu chooseMenuOption(Scanner consoleScanner) {
        switch (consoleScanner.nextLine()) {
            case "1":
                answerQuestion(consoleScanner);
                return previousMenu.previousMenu;
            case "2":
                printScoreBoardToConsole();
                return this;
            case "0":
                return previousMenu;
            default:
                System.out.println("Please choose a valid option");
                return this;
        }
    }

    private void answerQuestion(Scanner consoleScanner) {

        HashSet<GenericQuestion> randomlyChosenQuestions = new HashSet<>();

        while (randomlyChosenQuestions.size() < 4) {
            randomlyChosenQuestions.add(retrieveRandomQuestion());
        }

        int score = 0;

        for (GenericQuestion question :
                randomlyChosenQuestions) {
            question.showQuestion();
            score = question.checkAnswer(consoleScanner, score);
            System.out.println("Current score: " + score);
        }

        System.out.println("You answered " + score + "/4 correctly");
        if (score == 4) {
            System.out.println("Congratulations! You got everything right!\n");
        } else if (score > 0) {
            System.out.println("Better luck next time!\n");
        } else {
            System.out.println("Wow, you really suck!\n");
        }


        if (CurrentPlayer.get().getBinScore() < score || CurrentPlayer.get().getMcqScore() < score) {
            CurrentPlayer.get().setBinScore(score);
            CurrentPlayer.get().setMcqScore(score);
            updateScoreboard();
        }
    }

    private GenericQuestion retrieveRandomQuestion() {
        int range = questionSet.size();
        int randomNumber = (int) (Math.random() * range);
        return questionSet.get(randomNumber);
    }

    private void printScoreBoardToConsole() {
        try {
            ArrayList<QuizPlayer> players = playerDao.retrieveAll();
            if (questionSet.get(0) instanceof BinaryQuestion) {
                for (QuizPlayer player :
                        players) {
                    System.out.println(player.getName() + " " + player.getBinScore());
                }
            } else {
                for (QuizPlayer player :
                        players) {
                    System.out.println(player.getName() + " " + player.getMcqScore());
                }
            }
            System.out.println();
        } catch (SQLException exception) {
            exception.printStackTrace();
            System.out.println("Database connection failed");
            System.out.println("Scoreboard not accessible");
        }
    }

    private void updateScoreboard() {
        try {
            playerDao.update(CurrentPlayer.get());
        } catch (SQLException exception) {
            System.out.println("Database connection failed");
            System.out.println("Scoreboard cannot be updated");
        }
    }
}
