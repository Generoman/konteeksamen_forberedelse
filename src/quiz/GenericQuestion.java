package quiz;

import java.util.Scanner;

public interface GenericQuestion {

    int checkAnswer(Scanner consoleScanner, int score);

    void showQuestion();
}
