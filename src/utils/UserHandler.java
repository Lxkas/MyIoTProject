package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static java.lang.System.exit;

public class UserHandler {
    private static final String USERDB_NAME = ConfigHandler.getConfigProperty("USERDB_NAME");
    private static final String USERDB_USERNAME = ConfigHandler.getConfigProperty("USERDB_USERNAME");
    private static final String USERDB_PASSWORD = ConfigHandler.getConfigProperty("USERDB_PASSWORD");
    private static final String USERDB_PASSWORD_SALT = ConfigHandler.getConfigProperty("USERDB_PASSWORD_SALT");

    public static final DatabaseHandler UserDatabase = new DatabaseHandler(USERDB_NAME, USERDB_USERNAME, USERDB_PASSWORD);

    private static final String passwordSalter(String password) {
        // Basic for now, too laZy (-ω-、)
        return Hashing.sha256Hash(password + USERDB_PASSWORD_SALT);
    }

    public static final boolean login(String username, String password) {
        Connection conn = UserDatabase.getConnection();

        String query = "SELECT username FROM users WHERE username = ? AND password = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, passwordSalter(password));

            ResultSet rs = stmt.executeQuery();

            boolean hasResults = rs.next();

            conn.close();

            return hasResults;
        } catch (Exception e) {
            e.printStackTrace();
            exit(-2);
        }

        return false;
    }
}
