    package dao;

    import java.sql.*;
    import java.util.ArrayList;
    import java.util.List;

    import entities.Course;


    import dao.DatabaseConnection;

    import javax.swing.*;

    public class DAOAdmin {
        private Connection connection;

        public DAOAdmin() {
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

        public void addStudent(String password, String firstName, String lastName) {
            // Generate UID for the new student
            int uid = generateUID();

            // Capitalize first name and last name
            String capitalizedFirstName = capitalizeString(firstName);
            String capitalizedLastName = capitalizeString(lastName);

            // Prepare SQL statement
            String query = "INSERT INTO USERS (UID, PASSWORD, FIRST_NAME, LAST_NAME, ROL) VALUES (?, ?, ?, ?, 'STUDENT')";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, uid);
                statement.setString(2, password.toUpperCase());
                statement.setString(3, capitalizedFirstName.toUpperCase());
                statement.setString(4, capitalizedLastName.toUpperCase());

                // Execute the SQL statement
                statement.executeUpdate();
                System.out.println("Student added successfully!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        private int generateUID() {
            int uid = 0;
            String query = "SELECT MAX(UID) FROM USERS";
            try (PreparedStatement statement = connection.prepareStatement(query);
                 ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    uid = resultSet.getInt(1) + 1;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return uid;
        }

        private String capitalizeString(String str) {
            return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
        }




        public double generalReport() {
            double sum = 0;

            // Prepare SQL statement
            String query = "SELECT SUM(C.COST) FROM COURSE C JOIN TUITION T ON C.C_ID = T.C_ID WHERE T.GRADE = 0";
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(query)) {
                if (resultSet.next()) {
                    sum = resultSet.getDouble(1);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return sum;
        }

        public void addCourse(int courseId, String name, int capacity, int cost, int passingGrade, int professorId) {
            String query = "INSERT INTO COURSE (C_ID, NAME, CAPACITY, COST, PASSING_GRADE, INFORMATION, PROFESSOR_ID) " +
                    "SELECT ?, ?, ?, ?, ?, '', ? " +
                    "FROM USERS " +
                    "WHERE UID = ? AND ROL = 'PROFESSOR'";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, courseId);
                statement.setString(2, name);
                statement.setInt(3, capacity);
                statement.setInt(4, cost);
                statement.setInt(5, passingGrade);
                statement.setInt(6, professorId);
                statement.setInt(7, professorId);

                int rowsAffected = statement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Course added successfully!");
                } else {
                    System.out.println("Invalid professor ID or role. Course not added.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }





    //////////////////////////////////REVEER, POR AHI CREAR OBJETO CURSO PARA SACR LA DATA/////////////////////////////////////////////
    public void courseReport() {
        List<Course> courses = new ArrayList<>();

        String query = "SELECT C.C_ID, C.NAME, COUNT(T.T_ID), SUM(C.COST) " +
                "FROM COURSE C LEFT JOIN TUITION T ON C.C_ID = T.C_ID AND T.GRADE = 0 " +
                "GROUP BY C.C_ID, C.NAME";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                int cId = resultSet.getInt(1);
                String name = resultSet.getString(2);
                int cant = resultSet.getInt(3);
                int income = resultSet.getInt(4);

                Course course = new Course(cId, name, cant, income);
                courses.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Prepare the course report message
        StringBuilder messageBuilder = new StringBuilder();
        for (Course course : courses) {
            messageBuilder.append("Course ID: ").append(course.getC_ID()).append("\n");
            messageBuilder.append("Course name: ").append(course.getName()).append("\n");
            messageBuilder.append("Students enrolled: ").append(course.getCapacity()).append("\n");
            messageBuilder.append("Course income: ").append(course.getIncome()).append("\n");
            messageBuilder.append("------------------------------").append("\n");
        }

        // Show the course report in a popup message
        JOptionPane.showMessageDialog(null, messageBuilder.toString(), "Course Report", JOptionPane.INFORMATION_MESSAGE);
    }

        // Define a custom class to hold the course report data


    ///////////////////////////////////////////////////////////////////////////////




    }
