package database;

import com.mysql.cj.jdbc.MysqlDataSource;
import questions.BinaryQuestion;
import questions.GenericQuestion;
import questions.MultichoiceQuestion;
import players.QuizPlayer;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;

public class DatabaseConnector {

    private static MysqlDataSource dataSource;

    private static DataSource getDataSource() {

        if (dataSource == null) {
            dataSource = new MysqlDataSource();
            dataSource.setURL("jdbc:mysql://localhost:3306/quizgame");
            dataSource.setUser(SecretConnectionData.username); // brukernavn fra en klasse som ikke er med i Git
            dataSource.setPassword(SecretConnectionData.password); // passord fra en klasse som ikke er med i Git
        }

        return dataSource;
    }

    public static ArrayList<QuizPlayer> retrieveAllPlayers() throws SQLException {

        Connection connection = getDataSource().getConnection();
        PreparedStatement statement = connection.prepareStatement(
                "select * from quizgame.players", Statement.RETURN_GENERATED_KEYS
        );
        ResultSet resultSet = statement.executeQuery();

        ArrayList<QuizPlayer> playerList = new ArrayList<>();

        while (resultSet.next()) {
            QuizPlayer player = new QuizPlayer(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getInt("binary_score"),
                    resultSet.getInt("multichoice_score")
            );

            playerList.add(player);
        }

        return playerList;
    }

    public static void saveNewPlayer(QuizPlayer player) {

    }

    public static QuizPlayer retrievePlayerByName(String name) throws SQLException {
        Connection connection = getDataSource().getConnection();
        PreparedStatement statement = connection.prepareStatement(
                "select * from quizgame.players where name = ?", Statement.RETURN_GENERATED_KEYS
        );
        statement.setString(1, name);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            return new QuizPlayer(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getInt("binary_score"),
                    resultSet.getInt("multichoice_score")
                );
        }

        return null;
    }

    public static void updatePlayer(QuizPlayer player) {

    }

    public static HashSet<GenericQuestion> retrieveAllBinaryQuestions() throws SQLException {

        Connection connection = getDataSource().getConnection();
        PreparedStatement statement = connection.prepareStatement(
                "select * from quizgame.binary_questions", Statement.RETURN_GENERATED_KEYS
        );
        ResultSet resultSet = statement.executeQuery();

        HashSet<GenericQuestion> binaryQuestions = new HashSet<>();

        while (resultSet.next()) {
            GenericQuestion question = new BinaryQuestion(
                    resultSet.getInt("id"),
                    resultSet.getString("question"),
                    resultSet.getBoolean("correct_answer")
            );

            binaryQuestions.add(question);
        }

        return binaryQuestions;
    }

    public static HashSet<GenericQuestion> retrieveAllMultichoiceQuestions() {

        try {
            Connection connection = getDataSource().getConnection();
            PreparedStatement statement = connection.prepareStatement(
                    "select * from quizgame.multichoice_questions", Statement.RETURN_GENERATED_KEYS
            );
            ResultSet resultSet = statement.executeQuery();

            HashSet<GenericQuestion> multichoiceQuestions = new HashSet<>();

            while (resultSet.next()) {

                ArrayList<String> answers = new ArrayList<>();
                answers.add(resultSet.getString("answer_0"));
                answers.add(resultSet.getString("answer_1"));
                answers.add(resultSet.getString("answer_2"));
                answers.add(resultSet.getString("answer_3"));

                GenericQuestion question = new MultichoiceQuestion(
                        resultSet.getInt("id"),
                        resultSet.getString("question"),
                        resultSet.getInt("correct_answer"),
                        answers
                );

                multichoiceQuestions.add(question);
            }

            return multichoiceQuestions;

        } catch (SQLException exception) {
            System.out.println("Multichoice question retrieval failed");
            exception.printStackTrace();
        }

        return null;
    }
}
