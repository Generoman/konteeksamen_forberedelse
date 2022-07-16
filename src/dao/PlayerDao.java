package dao;

import players.QuizPlayer;

import java.io.IOException;
import java.sql.*;

public class PlayerDao extends AbstractDao<QuizPlayer> {

    public PlayerDao() throws IOException {
        super();
        selectAllStatementString = "select * from players";
    }


    public QuizPlayer save(QuizPlayer player) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(
                "insert into players (name, binary_score, multichoice_score) values (?, ?, ?)",
                Statement.RETURN_GENERATED_KEYS
        );
        statement.setString(1, player.getName());
        statement.setString(2, Integer.toString(player.getBinScore()));
        statement.setString(3, Integer.toString(player.getMcqScore()));

        int affectedRows = statement.executeUpdate();
        if (affectedRows == 0) throw new SQLException();

        return retrieveByName(player.getName());
    }

    public void update(QuizPlayer player) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(
                "update players set binary_score = ?, multichoice_score = ? where name = ?"
        );
        statement.setString(1, Integer.toString(player.getBinScore()));
        statement.setString(2, Integer.toString(player.getMcqScore()));
        statement.setString(3, player.getName());

        int affectedRows = statement.executeUpdate();
        if (affectedRows == 0) throw new SQLException();
    }

    public QuizPlayer retrieveByName(String name) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(
                "select * from players where name = ?", Statement.RETURN_GENERATED_KEYS
        );
        statement.setString(1, name);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            return mapFromResultSet(resultSet);
        }

        return null;
    }

    @Override
    public QuizPlayer mapFromResultSet(ResultSet resultSet) throws SQLException {
        return new QuizPlayer(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getInt("binary_score"),
                resultSet.getInt("multichoice_score")
        );
    }
}
