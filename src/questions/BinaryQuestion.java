package questions;

import java.util.Scanner;

public class BinaryQuestion extends AbstractQuestion<Boolean> {

    // public String type = "Binary";

    public BinaryQuestion(int id, String question, Boolean correctAnswer) {
        super(id, question, correctAnswer);
    }

    @Override
    public int checkAnswer(Scanner consoleScanner, int score) {

        String userAnswer = consoleScanner.nextLine();

        boolean boolAnswer;

        if (!userAnswer.equals("1") && !userAnswer.equals("2")) {
            System.out.println("Please choose a valid menu option");
            return checkAnswer(consoleScanner, score);
        }

        boolAnswer = userAnswer.equals("1");

        if (boolAnswer == correctAnswer) {
            System.out.println("Correct!");
            score++;
        } else {
            System.out.println("Wrong!");
        }

        return score;
    }

    @Override
    public void showQuestion() {
        System.out.println(question);
        System.out.println("1 - Yes");
        System.out.println("2 - No");
    }
}
