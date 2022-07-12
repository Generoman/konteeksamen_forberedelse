package questions;

import utils.UtilData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MultichoiceQuestion extends AbstractQuestion<Integer> {

    private ArrayList<String> answers;

    public MultichoiceQuestion(int id, String question, Integer correctAnswer, ArrayList<String> answers) {
        super(id, question, correctAnswer);
        this.answers = answers;
    }

    @Override
    public int checkAnswer(Scanner consoleScanner, int score) {

        String userAnswer = consoleScanner.nextLine();

        if (!Arrays.asList(UtilData.DIGITS).contains(userAnswer) || userAnswer.equals("0")) {
            System.out.println("Please choose a valid menu option");
            return checkAnswer(consoleScanner, score);
        }

        int convertedUserAnswer = Integer.parseInt(userAnswer) -1;

        if (convertedUserAnswer >= answers.size()) {
            System.out.println("Please choose a valid menu option");
            return checkAnswer(consoleScanner, score);
        }

        if (convertedUserAnswer == correctAnswer) {
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
        for (int i = 0; i < answers.size(); i++) {
            System.out.println(i+1 + " - " + answers.get(i));
        }
    }
}
