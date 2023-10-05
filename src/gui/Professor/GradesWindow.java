package gui.Professor;

import entities.Professor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GradesWindow extends JFrame {
    private Professor professor;
    private JTextField uidField;
    private JTextField gradeField;

    public GradesWindow(Professor professor) {
        this.professor = professor;
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Grades");
        setSize(300, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        JLabel uidLabel = new JLabel("UID:");
        panel.add(uidLabel);

        uidField = new JTextField();
        panel.add(uidField);

        JLabel gradeLabel = new JLabel("Grade:");
        panel.add(gradeLabel);

        gradeField = new JTextField();
        panel.add(gradeField);

        JButton addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addGrade();
                dispose();
            }
        });
        panel.add(addButton);

        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        panel.add(exitButton);

        getContentPane().add(panel, BorderLayout.CENTER);
    }

    private void addGrade() {
        try {
            int uid = Integer.parseInt(uidField.getText());
            int grade = Integer.parseInt(gradeField.getText());

            if (grade < 1 || grade > 10) {
                JOptionPane.showMessageDialog(this, "Invalid grade. Grade must be between 1 and 10.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            } else {
                professor.addGrade(grade, uid);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid UID or grade. Please enter valid integer values.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        }
    }
}
