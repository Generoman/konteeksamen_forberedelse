package questions;

import java.util.Objects;

public abstract class AbstractQuestion<T> implements GenericQuestion {

    protected int id;
    protected String question;
    protected T correctAnswer;

    public AbstractQuestion(int id, String question, T correctAnswer) {
        this.id = id;
        this.question = question;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractQuestion<?> that = (AbstractQuestion<?>) o;
        return question.equals(that.question);
    }

    @Override
    public int hashCode() {
        return Objects.hash(question);
    }
}
