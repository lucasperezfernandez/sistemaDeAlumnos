package gui.Admin;

import entities.Admin;
import entities.Form;

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


                Form newForm = new Form(password, firstName, lastName, 1, "x", 1, 1, 1, 1);

                // llamo el metodo de Admin
                admin.addStudent(newForm);


                JOptionPane.showMessageDialog(AddStudentWindow.this, "Student added successfully");

                // Limpio los fields
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
                dispose(); // Cerrar la ventana actual
            }
        });

        panel.add(exitButton);

        getContentPane().add(panel);
    }
}
