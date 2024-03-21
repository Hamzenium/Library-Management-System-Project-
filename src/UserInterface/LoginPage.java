package UserInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginPage extends JPanel {
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private ActionListener actionListener;

    public LoginPage(ActionListener listener) {
        setLayout(new GridLayout(4, 1));
        actionListener = listener;

        JLabel titleLabel = new JLabel("Login Page", SwingConstants.CENTER);
        add(titleLabel);

        JPanel emailPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel emailLabel = new JLabel("Email:");
        emailPanel.add(emailLabel);
        emailField = new JTextField(20);
        emailPanel.add(emailField);
        add(emailPanel);

        JPanel passwordPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel passwordLabel = new JLabel("Password:");
        passwordPanel.add(passwordLabel);
        passwordField = new JPasswordField(20);
        passwordPanel.add(passwordField);
        add(passwordPanel);

        loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Notify ActionListener about successful login with email and password
                actionListener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Login Successful"));
            }
        });
        add(loginButton);
    }

    public String getEmail() {
        return emailField.getText();
    }

    public String getPassword() {
        return new String(passwordField.getPassword());
    }
}
