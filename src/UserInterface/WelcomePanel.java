package UserInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WelcomePanel extends JPanel {
    private JButton loginButton, signUpButton;

    public WelcomePanel(ActionListener listener) {
        setLayout(new BorderLayout());

        JLabel welcomeLabel = new JLabel("Welcome to York's Library Management System", SwingConstants.CENTER);
        add(welcomeLabel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        loginButton = new JButton("Login");
        loginButton.addActionListener(listener);
        buttonPanel.add(loginButton);

        signUpButton = new JButton("Sign Up");
        signUpButton.addActionListener(listener);
        buttonPanel.add(signUpButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }
}
