package quiz;

import java.util.Scanner;

public interface GenericQuestion {

    void checkAnswer(Scanner consoleScanner);

    void showQuestion();
}
