package dao;

import questions.BinaryQuestion;
import questions.GenericQuestion;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

public class BinaryQuestionDao extends AbstractDao<GenericQuestion>{

    public BinaryQuestionDao() throws IOException {
        super();
        selectAllStatementString = "select * from binary_questions";
    }

    @Override
    public GenericQuestion mapFromResultSet(ResultSet resultSet) throws SQLException {
        return new BinaryQuestion(
                resultSet.getInt("id"),
                resultSet.getString("question"),
                resultSet.getBoolean("correct_answer")
        );
    }
}
