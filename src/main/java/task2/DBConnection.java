package task2;

import lombok.SneakyThrows;

import java.sql.*;

public class DBConnection {
    private static DBConnection dbconnection;
    private Connection connection;

    @SneakyThrows
    private DBConnection() {
        connection = DriverManager.getConnection("jdbc:sqlite:/Users/mskoropad/lab12/SQLite/cache.db");
    }

    @SneakyThrows
    public void executeQuery(String query) {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate(query);
        stmt.close();
    }

    @SneakyThrows
    public int checking(String query) {
        Statement statement = connection.createStatement();
        ResultSet res = statement.executeQuery(query);
        return res.getInt(1);
    }

    @SneakyThrows
    public String getting(String query) {
        Statement statement = connection.createStatement();
        ResultSet res = statement.executeQuery(query);
        return res.getString("parsed");
    }

    public static DBConnection getInstance() {
        if (dbconnection == null) {
            dbconnection = new DBConnection();
        }
        return dbconnection;
    }
}

