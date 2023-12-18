package gui.Student;

import entities.Student;
import gui.LoginUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class StudentWindow extends JFrame {
    private Student student;

    public StudentWindow(Student student) {
        this.student = student;
        initializeUI();
    }

    private void initializeUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Student Window");
        setSize(300, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel welcomeLabel = new JLabel("Welcome, " + student.getFirstName() + " " + student.getLastName() + "! You are logged in as a Student (UID: " + student.getUid() + ")");
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(welcomeLabel, BorderLayout.NORTH);

        JButton enrollButton = new JButton("Enroll");
        enrollButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open the Enrollment window
                EnrollWindow enrollWindow = new EnrollWindow(student);
                enrollWindow.setVisible(true);
            }
        });


        JButton myInscriptionsButton = new JButton("My Inscriptions");
        myInscriptionsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Call the inscriptionsReport method of the Student class
                student.inscriptionsReport();
            }
        });

        JButton logoffButton = new JButton("Log Off");
        logoffButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                dispose();

                LoginUI loginUI = new LoginUI();
                loginUI.setVisible(true);
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1));
        buttonPanel.add(enrollButton);
        buttonPanel.add(myInscriptionsButton);
        buttonPanel.add(logoffButton);

        panel.add(buttonPanel, BorderLayout.CENTER);

        getContentPane().add(panel);


        panel.add(buttonPanel, BorderLayout.CENTER);

        getContentPane().add(panel);
    }
}