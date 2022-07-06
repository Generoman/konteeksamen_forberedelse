package quiz;

import java.util.ArrayList;
import java.util.Scanner;

public class MultichoiceQuestion extends AbstractQuestion<Integer> {

    private ArrayList<String> answers;

    public MultichoiceQuestion(int id, String question, Integer correctAnswer, ArrayList<String> answers) {
        super(id, question, correctAnswer);
        this.answers = answers;
    }

    @Override
    public void checkAnswer(Scanner consoleScanner) {
        String userAnswer = consoleScanner.nextLine();

        int convertedUserAnswer = Integer.parseInt(userAnswer) -1;

        if (convertedUserAnswer == correctAnswer) {
            System.out.println("Correct!");
        } else {
            System.out.println("Wrong!");
        }
    }

    @Override
    public void showQuestion() {
        System.out.println(question);
        for (int i = 0; i < answers.size(); i++) {
            System.out.println(i+1 + " - " + answers.get(i));
        }
    }
}
