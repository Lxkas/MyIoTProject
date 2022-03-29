package utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseHandler {
    private final String databaseName;

    private final String username;
    private final String password;

    public DatabaseHandler(String databaseName, String username, String password) {
        this.databaseName = databaseName;

        this.username = username;
        this.password = password;
    }

    public Connection getConnection() {
        try {
            String formattedDatabaseString = String.format("jdbc:mysql://localhost:3306/%s", this.databaseName);
            return DriverManager.getConnection(formattedDatabaseString, this.username, this.password);
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }
}
