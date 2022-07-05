package quiz;

public abstract class AbstractQuiz<T> implements GenericQuiz {

    protected int id;
    protected String question;
    protected T correctAnswer;

    public AbstractQuiz(int id, String question, T correctAnswer) {
        this.id = id;
        this.question = question;
        this.correctAnswer = correctAnswer;
    }
}
