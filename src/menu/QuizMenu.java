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
        System.out.println(name);
        System.out.println("1 - Take quiz");
        System.out.println("2 - Scoreboard");
        System.out.println("0 - Back to previous menu");
    }

    @Override
    public void chooseMenuOption(Scanner consoleScanner) {
        switch (consoleScanner.nextLine()) {
            case "1":
                answerQuestion(consoleScanner);
                break;
            case "2":
                // TODO: implement scoreboard stuff
                break;
            case "0":
                return;
            default:
                System.out.println("Please choose a valid option");
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
            System.out.println("Congratulations! You got everything right!");
        } else if (score > 0) {
            System.out.println("Better luck next time!");
        } else {
            System.out.println("Wow, you really suck!");
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
}
