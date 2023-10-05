package gui.Admin;

import entities.Admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddStudentWindow extends JFrame {
    private Admin admin;

    public AddStudentWindow(Admin admin) {
        this.admin = admin;
        initializeUI();
    }


    private void initializeUI() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Add Student");
        setSize(300, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();
        JLabel firstNameLabel = new JLabel("First Name:");
        JTextField firstNameTextField = new JTextField();
        JLabel lastNameLabel = new JLabel("Last Name:");
        JTextField lastNameTextField = new JTextField();

        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(firstNameLabel);
        panel.add(firstNameTextField);
        panel.add(lastNameLabel);
        panel.add(lastNameTextField);

        JButton addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String password = new String(passwordField.getPassword());
                String firstName = firstNameTextField.getText();
                String lastName = lastNameTextField.getText();

                // Call the addStudent method of the Admin class with the retrieved parameters
                admin.addStudent(password, firstName, lastName);

                // Display a message to indicate that the student has been added
                JOptionPane.showMessageDialog(AddStudentWindow.this, "Student added successfully!");

                // Clear the text fields and password field for the next student entry
                passwordField.setText("");
                firstNameTextField.setText("");
                lastNameTextField.setText("");

                dispose();
            }


        });

        panel.add(addButton);

        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the current window
            }
        });

        panel.add(exitButton);

        getContentPane().add(panel);
    }
}
