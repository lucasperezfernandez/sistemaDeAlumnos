package dao;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DAOProfessor implements IDAOProfessor {
    private Connection connection;

    public DAOProfessor(){
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


    public void addGrade(int grade, int studentId, int professorId) {
        String query = "UPDATE TUITION SET GRADE = ? WHERE  UID = ? AND C_ID = ? AND GRADE = 0";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, grade);
            statement.setInt(2, studentId);
            statement.setInt(3, professorId);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Grade added successfully!");
                JOptionPane.showMessageDialog(null, "Grade added successfully!", "Add Grade", JOptionPane.INFORMATION_MESSAGE);
            } else {
                System.out.println("Failed to add grade. Please check the student ID and professor ID.");
                JOptionPane.showMessageDialog(null, "Failed to add grade.", "Add Grade", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public void addInfo(String information, int professorId) {
        String query = "UPDATE COURSE SET INFORMATION = ? WHERE PROFESSOR_ID = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, information);
            statement.setInt(2, professorId);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Information added successfully!");
                JOptionPane.showMessageDialog(null, "Information added successfully!", "Add Information", JOptionPane.INFORMATION_MESSAGE);
            } else {
                System.out.println("Failed to add information. Please check the professor ID.");
                JOptionPane.showMessageDialog(null, "Failed to add information. Please check professor ID.", "Add Information", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




}