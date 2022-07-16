package players;

public class QuizPlayer {

    private int id;
    private String name;
    private int binScore;
    private int mcqScore;

    public QuizPlayer() {}

    public QuizPlayer(String name) {
        this.name = name;
    }

    public QuizPlayer(int id, String name, int binScore, int mcqScore) {
        this.id = id;
        this.name = name;
        this.binScore = binScore;
        this.mcqScore = mcqScore;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
}
