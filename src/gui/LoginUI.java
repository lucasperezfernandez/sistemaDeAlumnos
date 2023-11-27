package gui;

import dao.DAOUser;
import entities.Admin;
import entities.Professor;
import entities.Student;
import entities.User;
import gui.Admin.AdminWindow;
import gui.Professor.ProfessorWindow;
import gui.Student.StudentWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginUI extends JFrame {
    private JTextField idField;
    private JPasswordField passwordField;

    public LoginUI() {
        initializeUI();
    }

    private void initializeUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Login");
        setSize(300, 200);
        setLocationRelativeTo(null);


        idField = new JTextField();


        passwordField = new JPasswordField();


        JButton loginButton = new JButton("Login");


        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int id = 0;
                try {
                    id = Integer.parseInt(idField.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(LoginUI.this, "Invalid ID. Please enter a valid integer ID.", "Invalid ID", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String password = new String(passwordField.getPassword());

                login(id, password);
            }
        });


        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
        panel.add(new JLabel("ID:"));
        panel.add(idField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);
        panel.add(new JLabel());
        panel.add(loginButton);

        getContentPane().add(panel, BorderLayout.CENTER);
    }

    private void login(int id, String password) {
        DAOUser daoUser = new DAOUser();
        User user = daoUser.validateLogin(id, password);
        if (user != null) {
            System.out.println("Login successful! ROL: " + user.getRol());
            openWindowBasedOnRole(user);

        } else {
            System.out.println("Invalid login credentials. Please try again.");
            JOptionPane.showMessageDialog(LoginUI.this, "Incorrect credentials", "Login Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void openWindowBasedOnRole(User user) {
        if (user instanceof Admin) {

            AdminWindow adminWindow = new AdminWindow((Admin) user);
            adminWindow.setVisible(true);
        } else if (user instanceof Professor) {

            ProfessorWindow professorWindow = new ProfessorWindow((Professor) user);
            professorWindow.setVisible(true);
        } else if (user instanceof Student) {


            StudentWindow studentWindow = new StudentWindow((Student) user);
            studentWindow.setVisible(true);
        } else {
            System.out.println("Unsupported role: " + user.getRol());
        }

        dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LoginUI().setVisible(true);
            }
        });
    }
}