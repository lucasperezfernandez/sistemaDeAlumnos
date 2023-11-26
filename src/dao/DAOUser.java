package dao;

import entities.Admin;
import entities.Professor;
import entities.Student;
import entities.User;

import java.sql.*;

public class DAOUser implements IDAOUser {
    private Connection connection;

    public DAOUser() {
        establishConnection();
    }

    private void establishConnection() {
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

    public void closeConnection() {
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

    public User validateLogin(int id, String password) {
        String rol = null;
        String firstName = null;
        String lastName = null;
        String query = "SELECT ROL, FIRST_NAME, LAST_NAME FROM USERS WHERE UID = ? AND PASSWORD = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                rol = resultSet.getString("ROL");
                firstName = resultSet.getString("FIRST_NAME");
                lastName = resultSet.getString("LAST_NAME");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        User user = null;
        if (rol != null) {
            if (rol.equalsIgnoreCase("Admin")) {
                Admin admin = new Admin();
                admin.setUid(id);
                admin.setPassword(password);
                admin.setRol(rol);
                admin.setFirstName(firstName);
                admin.setLastName(lastName);
                user = admin;
            } else if (rol.equalsIgnoreCase("Professor")) {
                Professor professor = new Professor();
                professor.setUid(id);
                professor.setPassword(password);
                professor.setRol(rol);
                professor.setFirstName(firstName);
                professor.setLastName(lastName);
                user = professor;
            } else if (rol.equalsIgnoreCase("Student")) {
                Student student = new Student();
                student.setUid(id);
                student.setPassword(password);
                student.setRol(rol);
                student.setFirstName(firstName);
                student.setLastName(lastName);
                user = student;
            }
        }
        return user;
    }

}
