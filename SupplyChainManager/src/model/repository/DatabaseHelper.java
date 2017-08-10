package model.repository;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;

public class DatabaseHelper {
    private static ConnectionSource connectionSource;
    private static String databaseUrl = "jdbc:sqlite:main.db";

    private DatabaseHelper() {
    }

    public static ConnectionSource getConnectionSource() {
        if (connectionSource == null) {
            try {
                connectionSource = new JdbcConnectionSource(databaseUrl);
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }
        }
        return connectionSource;
    }
}
