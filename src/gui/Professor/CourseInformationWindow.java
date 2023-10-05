package gui.Professor;

import entities.Professor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CourseInformationWindow extends JFrame {
    private Professor professor;
    private JTextField informationField;

    public CourseInformationWindow(Professor professor) {
        this.professor = professor;
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Course Information");
        setSize(300, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel informationLabel = new JLabel("Information:");
        panel.add(informationLabel);

        informationField = new JTextField();
        panel.add(informationField);

        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sendInformation();
                dispose();
            }
        });
        panel.add(sendButton);

        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        panel.add(exitButton);

        getContentPane().add(panel, BorderLayout.CENTER);
    }

    private void sendInformation() {
        String information = informationField.getText();
        professor.addInfo(information);
    }
}
