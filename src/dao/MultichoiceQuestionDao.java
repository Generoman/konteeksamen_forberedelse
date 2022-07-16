package dao;

import questions.GenericQuestion;
import questions.MultichoiceQuestion;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MultichoiceQuestionDao extends AbstractDao<GenericQuestion> {

    public MultichoiceQuestionDao() throws IOException {
        super();
        selectAllStatementString = "select * from multichoice_questions";
    }

    @Override
    public GenericQuestion mapFromResultSet(ResultSet resultSet) throws SQLException {

        ArrayList<String> answers = new ArrayList<>();
        answers.add(resultSet.getString("answer_0"));
        answers.add(resultSet.getString("answer_1"));
        answers.add(resultSet.getString("answer_2"));
        answers.add(resultSet.getString("answer_3"));

        return new MultichoiceQuestion(
                resultSet.getInt("id"),
                resultSet.getString("question"),
                resultSet.getInt("correct_answer"),
                answers
        );
    }
}
