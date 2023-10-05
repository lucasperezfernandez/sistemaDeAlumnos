package gui.Admin;

import dao.DAOAdmin;
import entities.Admin;
import gui.LoginUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminWindow extends JFrame {
    private Admin admin;

    public AdminWindow(Admin admin) {
        this.admin = admin;
        initializeUI();
    }

    private void initializeUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Admin Window");
        setSize(300, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));

        JLabel welcomeLabel = new JLabel("Welcome, " + admin.getFirstName() + " " + admin.getLastName() + "! You are logged in as an Admin");
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(welcomeLabel);

        JButton addStudentButton = new JButton("Add Student");
        addStudentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AddStudentWindow addStudentWindow = new AddStudentWindow(admin);
                addStudentWindow.setVisible(true);
            }
        });
        panel.add(addStudentButton);






        JButton addCourseButton = new JButton("Add Course");
        addCourseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AddCourseWindow addCourseWindow = new AddCourseWindow(admin);
                addCourseWindow.setVisible(true);
            }
        });
        panel.add(addCourseButton);






//////////////////////////////////REVEER, POR AHI CREAR OBJETO CURSO PARA SACR LA DATA/////////////////////////////////////////////

        JButton courseReportButton = new JButton("Course Report");
        courseReportButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                admin.courseReport();
            }
        });
        panel.add(courseReportButton);

/////////////////////////////////////////////////////////////////////////////////////////////////////////////








        JButton generalReportButton = new JButton("General Report");
        generalReportButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double semesterIncome = admin.generalReport();
                String message = "Semester total income: $" + semesterIncome;

                JOptionPane.showMessageDialog(AdminWindow.this, message);
            }
        });
        panel.add(generalReportButton);


        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add functionality for the Exit button
                dispose(); // Close the current window
                LoginUI loginUI = new LoginUI();
                loginUI.setVisible(true); // Open the LoginUI window
            }
        });
        panel.add(exitButton);

        getContentPane().add(panel);
    }




    //////////////////////////////////REVEER, POR AHI CREAR OBJETO CURSO PARA SACR LA DATA/////////////////////////////////////////////
//    private void showCourseReportPopup() {
//        JFrame popupFrame = new JFrame("Course Report");
//        popupFrame.setSize(300, 200);
//        popupFrame.setLocationRelativeTo(this);
//
//        JPanel popupPanel = new JPanel();
//        popupPanel.setLayout(new GridLayout(3, 1));
//
//        JTextField courseIdField = new JTextField();
//        popupPanel.add(courseIdField);
//
//        JButton searchButton = new JButton("Search");
//        searchButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                String courseId = courseIdField.getText();
//                DAOAdmin.CourseReportData costSum = admin.courseReport(courseId);
//                JOptionPane.showMessageDialog(popupFrame, "Cost sum for course " + courseId + ": " + costSum);
//            }
//        });
//        popupPanel.add(searchButton);
//
//        JButton exitButton = new JButton("Exit");
//        exitButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                popupFrame.dispose();
//            }
//        });
//        popupPanel.add(exitButton);
//
//        popupFrame.getContentPane().add(popupPanel);
//        popupFrame.setVisible(true);
//    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
