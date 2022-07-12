package players;

public class CurrentPlayer {

    private static QuizPlayer INSTANCE;

    public static QuizPlayer getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new QuizPlayer();
        }
        return INSTANCE;
    }
}
