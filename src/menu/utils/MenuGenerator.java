package menu.utils;

import dao.BinaryQuestionDao;
import dao.MultichoiceQuestionDao;
import dao.PlayerDao;
import menu.LoginMenu;
import menu.MainMenu;
import menu.QuizMenu;
import menu.SimpleMenu;
import questions.BinaryQuestion;
import questions.GenericQuestion;
import questions.MultichoiceQuestion;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class MenuGenerator {

    public static SimpleMenu generateFullMenu() {

        BinaryQuestionDao binaryQuestionDao = null;
        MultichoiceQuestionDao multichoiceQuestionDao= null;
        PlayerDao playerDao = null;

        try {
            binaryQuestionDao = new BinaryQuestionDao();
            multichoiceQuestionDao = new MultichoiceQuestionDao();
            playerDao = new PlayerDao();
        } catch (IOException exception) {
            System.out.println("Properties file not found");
            exception.printStackTrace();
        }

        ArrayList<GenericQuestion> binQuestionSet;
        ArrayList<GenericQuestion> mcqQuestionSet;

        if (binaryQuestionDao != null && multichoiceQuestionDao != null && playerDao != null) {
            try {
                binQuestionSet = binaryQuestionDao.retrieveAll();
                mcqQuestionSet = multichoiceQuestionDao.retrieveAll();
            } catch (SQLException exception) {
                System.out.println("Could not connect to database");
                exception.printStackTrace();
                System.out.println("You will be playing this game with hardcoded questions");
                System.out.println("Scoreboard will not be available");
                binQuestionSet = generateDummyBinaryQuestions();
                mcqQuestionSet = generateDummyMultichoiceQuestions();
            }
        } else {
            System.out.println("You will be playing this game with hardcoded questions");
            System.out.println("Scoreboard will not be available");
            binQuestionSet = generateDummyBinaryQuestions();
            mcqQuestionSet = generateDummyMultichoiceQuestions();
        }


        QuizMenu multichoiceQuiz = new QuizMenu("Multichoice Quiz", mcqQuestionSet, playerDao);

        QuizMenu binaryQuiz = new QuizMenu("Binary Quiz", binQuestionSet, playerDao);

        ArrayList<SimpleMenu> quizOptions = new ArrayList<>();
        quizOptions.add(binaryQuiz);
        quizOptions.add(multichoiceQuiz);

        SimpleMenu chooseQuiz = new SimpleMenu("Take a Quiz", quizOptions);
        binaryQuiz.setPreviousMenu(chooseQuiz);
        multichoiceQuiz.setPreviousMenu(chooseQuiz);

        ArrayList<SimpleMenu> mainOptions = new ArrayList<>();
        mainOptions.add(chooseQuiz);

        MainMenu mainMenu = new MainMenu(mainOptions);
        chooseQuiz.setPreviousMenu(mainMenu);

        ArrayList<SimpleMenu> loginOptions = new ArrayList<>();
        loginOptions.add(mainMenu);

        return new LoginMenu(loginOptions, playerDao);
    }

    private static ArrayList<GenericQuestion> generateDummyBinaryQuestions() {

        BinaryQuestion bin1 = new BinaryQuestion(1, "Are we there yet?", false);
        BinaryQuestion bin2 = new BinaryQuestion(2, "Yes or no?", true);
        BinaryQuestion bin3 = new BinaryQuestion(3, "No or yes?", false);
        BinaryQuestion bin4 = new BinaryQuestion(4, "Are you sure?", true);

        ArrayList<GenericQuestion> binQuestionSet = new ArrayList<>();
        binQuestionSet.add(bin1);
        binQuestionSet.add(bin2);
        binQuestionSet.add(bin3);
        binQuestionSet.add(bin4);

        return binQuestionSet;
    }

    private static ArrayList<GenericQuestion> generateDummyMultichoiceQuestions() {

        ArrayList<String> answers = new ArrayList<>();
        answers.add("a");
        answers.add("b");
        answers.add("c");
        answers.add("d");

        MultichoiceQuestion mcq1 = new MultichoiceQuestion(1, "Choose 'a':", 0, answers);
        MultichoiceQuestion mcq2 = new MultichoiceQuestion(2, "Choose 'b':", 1, answers);
        MultichoiceQuestion mcq3 = new MultichoiceQuestion(3, "Choose 'c':", 2, answers);
        MultichoiceQuestion mcq4 = new MultichoiceQuestion(4, "Choose 'd':", 3, answers);

        ArrayList<GenericQuestion> mcqQuestionSet = new ArrayList<>();
        mcqQuestionSet.add(mcq1);
        mcqQuestionSet.add(mcq2);
        mcqQuestionSet.add(mcq3);
        mcqQuestionSet.add(mcq4);

        return mcqQuestionSet;
    }
}
