package utils;

import menu.LoginMenu;
import menu.MainMenu;
import menu.QuizMenu;
import menu.SimpleMenu;
import quiz.BinaryQuestion;
import quiz.GenericQuestion;
import quiz.MultichoiceQuestion;

import java.util.ArrayList;
import java.util.HashSet;

public class MenuFactory {

    public static SimpleMenu generateFullMenu() {

        BinaryQuestion bin1 = new BinaryQuestion(1, "Are we there yet?", false);
        BinaryQuestion bin2 = new BinaryQuestion(2, "Yes or no?", true);
        BinaryQuestion bin3 = new BinaryQuestion(3, "No or yes?", false);
        BinaryQuestion bin4 = new BinaryQuestion(4, "Are you sure?", true);

        HashSet<GenericQuestion> binQuestionSet = new HashSet<>();
        binQuestionSet.add(bin1);
        binQuestionSet.add(bin2);
        binQuestionSet.add(bin3);
        binQuestionSet.add(bin4);

        ArrayList<String> answers = new ArrayList<>();
        answers.add("a");
        answers.add("b");
        answers.add("c");
        answers.add("d");

        MultichoiceQuestion mcq1 = new MultichoiceQuestion(1, "Choose 'a':", 0, answers);
        MultichoiceQuestion mcq2 = new MultichoiceQuestion(2, "Choose 'b':", 1, answers);
        MultichoiceQuestion mcq3 = new MultichoiceQuestion(3, "Choose 'c':", 2, answers);
        MultichoiceQuestion mcq4 = new MultichoiceQuestion(4, "Choose 'd':", 3, answers);

        HashSet<GenericQuestion> mcqQuestionSet = new HashSet<>();
        mcqQuestionSet.add(mcq1);
        mcqQuestionSet.add(mcq2);
        mcqQuestionSet.add(mcq3);
        mcqQuestionSet.add(mcq4);

        QuizMenu multichoiceQuiz = new QuizMenu("Multichoice Quiz", mcqQuestionSet);

        QuizMenu binaryQuiz = new QuizMenu("Binary Quiz", binQuestionSet);

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

        return new LoginMenu("Login", loginOptions);
    }
}
