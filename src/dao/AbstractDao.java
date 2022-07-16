package dao;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public abstract class AbstractDao<T> {

    protected DataSource dataSource;
    protected String selectAllStatementString;

    public AbstractDao() throws IOException {

        Properties properties = new Properties();
        FileReader fileReader = new FileReader("resources/quiz.properties");
        properties.load(fileReader);

        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL(properties.getProperty("url"));
        dataSource.setUser(properties.getProperty("username"));
        dataSource.setPassword(properties.getProperty("password"));

        this.dataSource = dataSource;
    }

    public ArrayList<T> retrieveAll() throws SQLException {
        Connection connection = dataSource.getConnection();

        PreparedStatement statement = connection.prepareStatement(
                selectAllStatementString, Statement.RETURN_GENERATED_KEYS
        );
        ResultSet resultSet = statement.executeQuery();

        ArrayList<T> retrievedObjects = new ArrayList<>();

        while (resultSet.next()) {
            T object = mapFromResultSet(resultSet);
            retrievedObjects.add(object);
        }

        return retrievedObjects;
    }

    public abstract T mapFromResultSet(ResultSet resultSet) throws SQLException;
}
