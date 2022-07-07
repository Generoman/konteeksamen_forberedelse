package utils;

import quiz.BinaryQuestion;
import quiz.GenericQuestion;

public class DummyDataScoreboard {

    public static void printScoreboardToConsole(GenericQuestion question) {

        if (question instanceof BinaryQuestion) {
            System.out.println(
                    """
                            Player: Roman
                            Binary Quiz Score: 3
                            
                            Player: Marie
                            Binary Quiz Score: 4
                            """
            );
        } else {
            System.out.println(
                    """
                            Player: Roman
                            Multichoice Quiz Score: 3
                            
                            Player: Marie
                            Multichoice Quiz Score: 4
                            """
            );
        }
    }
}
