package menu;

import database.DatabaseConnector;
import players.CurrentPlayer;
import questions.BinaryQuestion;
import questions.GenericQuestion;
import players.DummyDataScoreboard;
import players.QuizPlayer;

import java.sql.SQLException;
import java.util.*;

public class QuizMenu extends SimpleMenu {

    private final HashSet<GenericQuestion> questionSet;

    public QuizMenu(String name, HashSet<GenericQuestion> questionSet) {
        super(name);
        this.questionSet = questionSet;
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

        if (retrieveRandomQuestion() instanceof BinaryQuestion) {
            if (QuizPlayer.getInstance().getBinScore() < score) {
                QuizPlayer.getInstance().setBinScore(score);
            }
        } else {
            if (QuizPlayer.getInstance().getMcqScore() < score) {
                QuizPlayer.getInstance().setMcqScore(score);
            }
        }
    }

    private GenericQuestion retrieveRandomQuestion() {

        Random random = new Random();

        int randNum = random.nextInt(questionSet.size());

        Iterator<GenericQuestion> iterator = questionSet.iterator();

        int currentIndex = 0;

        GenericQuestion randomQuestion = null;

        while (iterator.hasNext()) {

            randomQuestion = iterator.next();

            if (currentIndex == randNum) return randomQuestion;

            currentIndex++;
        }

        return randomQuestion;
    }

    private void printScoreBoardToConsole() {
        try {
            ArrayList<QuizPlayer> players = DatabaseConnector.retrieveAllPlayers();
            if (retrieveRandomQuestion() instanceof BinaryQuestion) {
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
            System.out.println("Score board not accessible. Database connection failed");
        }
    }
}
