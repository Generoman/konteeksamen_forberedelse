package players;

public class CurrentPlayer {

    private static QuizPlayer PLAYER_INSTANCE;

    public static QuizPlayer get() {
        if (PLAYER_INSTANCE == null) {
            PLAYER_INSTANCE = new QuizPlayer();
        }
        return PLAYER_INSTANCE;
    }

    public static void set(QuizPlayer player) {
        PLAYER_INSTANCE = player;
    }
}
