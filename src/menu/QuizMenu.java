package menu;

import quiz.GenericQuestion;

import java.util.*;

public class QuizMenu extends SimpleMenu {

    private final HashSet<GenericQuestion> questionSet;

    public QuizMenu(String name, HashSet<GenericQuestion> questionSet) {
        super(name);
        this.questionSet = questionSet;
    }

    @Override
    public void printMenuToConsole() {
        System.out.println("1 - Take quiz");
        System.out.println("2 - Scoreboard");
        System.out.println("0 - Back to previous menu");
    }

    @Override
    public void chooseMenuOption(Scanner consoleScanner) {
        super.chooseMenuOption(consoleScanner);
    }

    private void answerQuesstion() {

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
}
