package gui.Student;

import entities.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class EnrollWindow extends JFrame {
    private Student student;

    public EnrollWindow(Student student) {
        this.student = student;
        initializeUI();
    }

    private void initializeUI() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Enrollment Window");
        setSize(300, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        JLabel idLabel = new JLabel("Enter Course ID:");
        JTextField idField = new JTextField();
        JButton enrollButton = new JButton("Enroll");
        enrollButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String enteredId = idField.getText();
                int id = 0;
                try {
                    id = Integer.parseInt(enteredId);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(EnrollWindow.this, "Invalid ID. Please enter a valid integer ID.", "Invalid ID", JOptionPane.ERROR_MESSAGE);
                    return;
                }


                student.enroll(id);


                dispose();
            }
        });

        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                dispose();
            }
        });

        panel.add(idLabel);
        panel.add(idField);
        panel.add(enrollButton);
        panel.add(exitButton);

        getContentPane().add(panel);
    }
}
