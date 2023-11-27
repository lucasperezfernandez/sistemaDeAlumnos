package dao;

import javax.swing.*;
import java.sql.*;

public class DAOStudent implements IDAOStudent {
    private Connection connection;

    public DAOStudent() {
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


    public void enroll(int courseId, int uid) {
        String selectCourseCapacityQuery = "SELECT CAPACITY FROM COURSE WHERE C_ID = ?";
        String selectStudentEnrollmentsQuery = "SELECT COUNT(T_ID) FROM TUITION WHERE Uid = ? AND GRADE = 0";
        String selectStudentGradeQuery = "SELECT GRADE FROM TUITION WHERE Uid = ? AND C_ID = ?";
        String insertTuitionQuery = "INSERT INTO TUITION (T_ID, Uid, C_ID, GRADE) VALUES (?, ?, ?, 0)";

        try (PreparedStatement selectCapacityStatement = connection.prepareStatement(selectCourseCapacityQuery);
             PreparedStatement selectEnrollmentsStatement = connection.prepareStatement(selectStudentEnrollmentsQuery);
             PreparedStatement selectGradeStatement = connection.prepareStatement(selectStudentGradeQuery);
             PreparedStatement insertTuitionStatement = connection.prepareStatement(insertTuitionQuery)) {

            // Condicion 1, que el usuario no este inscripto en 3 cursos
            selectEnrollmentsStatement.setInt(1, uid);
            ResultSet enrollmentsResult = selectEnrollmentsStatement.executeQuery();
            if (enrollmentsResult.next()) {
                int enrollmentsCount = enrollmentsResult.getInt(1);
                if (enrollmentsCount >= 3) {
                    System.out.println("Enrollment failed. You have already enrolled in the maximum number of courses");
                    JOptionPane.showMessageDialog(null, "Enrollment failed. You have already enrolled in the maximum number of courses", "Enrollment", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }


            // Condicion 2: Si el usuario ya esta registrado en el curso ingresado, la nota tienen que ser distinta de 0 o menor a la nota para pasar (Recurso)
            selectGradeStatement.setInt(1, uid);
            selectGradeStatement.setInt(2, courseId);
            ResultSet gradeResult = selectGradeStatement.executeQuery();
            if (gradeResult.next()) {
                int grade = gradeResult.getInt(1);
                if (grade >= 0) {
                    System.out.println("Enrollment failed. You have already passed this course or have a grade of 0.");
                    JOptionPane.showMessageDialog(null, "Enrollment failed. You have already passed this course or have a grade of 0.", "Enrollment", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }


            // Condicion 3: Revisar que el curso no haya llegado a su capacidad maxima de alumnos.
            selectCapacityStatement.setInt(1, courseId);
            ResultSet capacityResult = selectCapacityStatement.executeQuery();
            if (capacityResult.next()) {
                int capacity = capacityResult.getInt(1);
                if (enrollmentsResult.getInt(1) >= capacity) {
                    System.out.println("Enrollment failed. Course capacity has been reached.");
                    JOptionPane.showMessageDialog(null, "Enrollment failed. Course capacity has been reached.", "Enrollment", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            
            String selectMaxTuitionIdQuery = "SELECT MAX(T_ID) FROM TUITION";
            PreparedStatement selectMaxTuitionIdStatement = connection.prepareStatement(selectMaxTuitionIdQuery);
            ResultSet maxTuitionIdResult = selectMaxTuitionIdStatement.executeQuery();
            int maxTuitionId = 1;
            if (maxTuitionIdResult.next()) {
                maxTuitionId = maxTuitionIdResult.getInt(1) + 1;
            }

            insertTuitionStatement.setInt(1, maxTuitionId);
            insertTuitionStatement.setInt(2, uid);
            insertTuitionStatement.setInt(3, courseId);
            insertTuitionStatement.executeUpdate();

            System.out.println("Enrollment successful!");
            JOptionPane.showMessageDialog(null, "Enrollment successful!", "Enrollment", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            if (e.getSQLState().equals("23506")) {
                System.out.println("Referential integrity constraint violation. Make sure the course ID exists.");
            } else {
                e.printStackTrace();
            }
        }
    }
}
