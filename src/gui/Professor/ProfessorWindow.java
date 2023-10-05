package gui.Professor;

import entities.Professor;
import gui.LoginUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfessorWindow extends JFrame {
    private Professor professor;

    public ProfessorWindow(Professor professor) {
        this.professor = professor;
        initializeUI();
    }

    private void initializeUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Professor Window");
        setSize(300, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));

        JLabel welcomeLabel = new JLabel("Welcome, " + professor.getFirstName() + " " + professor.getLastName() + "! You are logged in as a Professor");
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(welcomeLabel);

        JButton addInformationButton = new JButton("Add Information");
        addInformationButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CourseInformationWindow courseInformationWindow = new CourseInformationWindow(professor);
                courseInformationWindow.setVisible(true);
            }
        });
        panel.add(addInformationButton);


        JButton addGradesButton = new JButton("Add Grades");
        addGradesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GradesWindow gradesWindow = new GradesWindow(professor);
                gradesWindow.setVisible(true);
            }
        });
        panel.add(addGradesButton);



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
}
