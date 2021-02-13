package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtils {
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(PropertyReader.getProperty("dbdriver"));
            connection = DriverManager.getConnection(
                    "jdbc:mysql://" + PropertyReader.getProperty("host") + ":" +
                            PropertyReader.getProperty("dbport") + "/" +
                            PropertyReader.getProperty("dbname"),
                    PropertyReader.getProperty("username"),
                    PropertyReader.getProperty("dbpassword"));
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
