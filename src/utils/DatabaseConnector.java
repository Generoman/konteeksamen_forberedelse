package utils;

import com.mysql.cj.jdbc.MysqlDataSource;
import quiz.BinaryQuestion;
import quiz.MultichoiceQuestion;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;

public class DatabaseConnector {

    private MysqlDataSource dataSource;

    private DataSource getDataSource() {

        if (dataSource == null) {
            dataSource = new MysqlDataSource();
            dataSource.setURL("jdbc:mysql://localhost:3306/quizgame");
            dataSource.setUser(SecretConnectionData.username); // brukernavn fra en klasse som ikke er med i Git
            dataSource.setPassword(SecretConnectionData.password); // passord fra en klasse som ikke er med i Git
        }

        return dataSource;
    }

    public ArrayList<QuizPlayer> retrieveAllPlayers() throws SQLException {

        Connection connection = getDataSource().getConnection();
        PreparedStatement statement = connection.prepareStatement(
                "select * from quizgame.players", Statement.RETURN_GENERATED_KEYS
        );
        ResultSet resultSet = statement.executeQuery();

        ArrayList<QuizPlayer> playerList = new ArrayList<>();

        while (resultSet.next()) {
            QuizPlayer player = new QuizPlayer();
            player.setId(resultSet.getInt("id"));
            player.setName(resultSet.getString("name"));
            player.setBinScore(resultSet.getInt("binary_score"));
            player.setMcqScore(resultSet.getInt("multichoice_score"));

            playerList.add(player);
        }

        return playerList;
    }

    public void saveNewPlayer(QuizPlayer player) {

    }

    public void updatePlayer(QuizPlayer player) {

    }

    public HashSet<BinaryQuestion> retrieveAllBinaryQuestions() {
        return null;
    }

    public HashSet<MultichoiceQuestion> retrieveAllMultichoiceQuestions() {
        return null;
    }
}
