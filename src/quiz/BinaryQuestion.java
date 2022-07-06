package quiz;

import java.util.Scanner;

public class BinaryQuestion extends AbstractQuestion<Boolean> {

    public String type = "Binary";

    public BinaryQuestion(int id, String question, Boolean correctAnswer) {
        super(id, question, correctAnswer);
    }

    @Override
    public void checkAnswer(Scanner consoleScanner) {
        String userAnswer = consoleScanner.nextLine();

        boolean boolAnswer;

        if (userAnswer.equals("1")) {
            boolAnswer = true;
        } else {
            boolAnswer = false;
        }

        if (boolAnswer == correctAnswer) {
            System.out.println("Correct!");
        } else {
            System.out.println("Wrong!");
        }
    }

    @Override
    public void showQuestion() {
        System.out.println(question);
        System.out.println("1 - Yes");
        System.out.println("2 - No");
    }
}
