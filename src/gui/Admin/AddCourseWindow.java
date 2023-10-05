package gui.Admin;

import entities.Admin;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCourseWindow extends JFrame {
    private Admin admin;

    public AddCourseWindow(Admin admin) {
        this.admin = admin;
        initializeUI();
    }

    private void initializeUI() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Add Course");
        setSize(300, 300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2));

        JLabel courseIdLabel = new JLabel("Course ID:");
        JTextField courseIdField = new JTextField();
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();
        JLabel capacityLabel = new JLabel("Capacity:");
        JTextField capacityField = new JTextField();
        JLabel costLabel = new JLabel("Cost:");
        JTextField costField = new JTextField();
        JLabel passingGradeLabel = new JLabel("Passing Grade:");
        JTextField passingGradeField = new JTextField();
        JLabel professorIdLabel = new JLabel("Professor ID:");
        JTextField professorIdField = new JTextField();

        panel.add(courseIdLabel);
        panel.add(courseIdField);
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(capacityLabel);
        panel.add(capacityField);
        panel.add(costLabel);
        panel.add(costField);
        panel.add(passingGradeLabel);
        panel.add(passingGradeField);
        panel.add(professorIdLabel);
        panel.add(professorIdField);

        JButton addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int courseId = Integer.parseInt(courseIdField.getText());
                String name = nameField.getText();
                int capacity = Integer.parseInt(capacityField.getText());
                int cost = Integer.parseInt(costField.getText());
                int passingGrade = Integer.parseInt(passingGradeField.getText());
                int professorId = Integer.parseInt(professorIdField.getText());

                admin.addCourse(courseId, name, capacity, cost, passingGrade, professorId);

                // Display success message
                JOptionPane.showMessageDialog(AddCourseWindow.this, "Request taken");

                // Clear the form fields
                courseIdField.setText("");
                nameField.setText("");
                capacityField.setText("");
                costField.setText("");
                passingGradeField.setText("");
                professorIdField.setText("");
            }
        });

        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        panel.add(addButton);
        panel.add(exitButton);

        getContentPane().add(panel);
    }
}
