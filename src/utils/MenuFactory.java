package utils;

import menu.MainMenu;
import menu.QuizMenu;
import menu.SimpleMenu;
import quiz.BinaryQuestion;
import quiz.GenericQuestion;

import java.util.ArrayList;
import java.util.HashSet;

public class MenuFactory {

    public static MainMenu generateFullMenu() {

        BinaryQuestion bin1 = new BinaryQuestion(1, "Are we there yet?", false);
        BinaryQuestion bin2 = new BinaryQuestion(2, "Yes or no?", true);
        BinaryQuestion bin3 = new BinaryQuestion(3, "No or yes?", false);
        BinaryQuestion bin4 = new BinaryQuestion(4, "Are you sure?", true);

        HashSet<GenericQuestion> binQuestionSet = new HashSet<>();
        binQuestionSet.add(bin1);
        binQuestionSet.add(bin2);
        binQuestionSet.add(bin3);
        binQuestionSet.add(bin4);

        QuizMenu binaryQuiz = new QuizMenu("Binary Quiz", binQuestionSet);

        ArrayList<SimpleMenu> quizOptions = new ArrayList<>();
        quizOptions.add(binaryQuiz);

        SimpleMenu chooseQuiz = new SimpleMenu("Take a Quiz", quizOptions);

        ArrayList<SimpleMenu> mainOptions = new ArrayList<>();
        mainOptions.add(chooseQuiz);

        return new MainMenu(mainOptions);
    }
}
