package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection != null) {
            return connection;
        } else {
            establishConnection();
            return connection;
        }
    }

    public static void refreshConnection() {
        closeConnection();
        establishConnection();
    }

    private static void establishConnection() {
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/Desktop/UP/Labo 1/SistemaDeAlumnos", "admin", "admin");
            System.out.println("Connected to the database successfully!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
                System.out.println("Connection closed successfully!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}