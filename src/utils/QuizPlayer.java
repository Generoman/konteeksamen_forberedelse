package utils;

public class QuizPlayer {

    private String name;
    private int binScore;
    private int mcqScore;

    private static QuizPlayer INSTANCE;

    private QuizPlayer() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBinScore() {
        return binScore;
    }

    public void setBinScore(int binScore) {
        this.binScore = binScore;
    }

    public int getMcqScore() {
        return mcqScore;
    }

    public void setMcqScore(int mcqScore) {
        this.mcqScore = mcqScore;
    }

    public static QuizPlayer getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new QuizPlayer();
        }
        return INSTANCE;
    }
}
