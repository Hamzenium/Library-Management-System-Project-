package UserInterface;
import Users.User;
import javax.swing.*;
import java.awt.event.*;

public class LoginPage extends JFrame implements ActionListener {
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JLabel emailLabel, passwordLabel;
    private User currentUser; // Reference to the current user object

    public LoginPage() {
        setTitle("Library Management System - Login");
        setSize(300, 200);
        setLayout(null);

        emailLabel = new JLabel("Email:");
        emailLabel.setBounds(30, 30, 80, 25);
        add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(100, 30, 160, 25);
        add(emailField);

        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(30, 65, 80, 25);
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(100, 65, 160, 25);
        add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setBounds(100, 100, 80, 25);
        loginButton.addActionListener(this);
        add(loginButton);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Method to handle button click event
    public void actionPerformed(ActionEvent e) {
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());

        try {
            currentUser = new User(email, password); // Creating user object
            System.out.println(currentUser);
            currentUser.login(email, password); // Attempting login
            JOptionPane.showMessageDialog(this, "Login successful!");
            // Here you can proceed with what you want to do after successful login
            // For example, open the main application window
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Login failed: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new LoginPage();
    }
}

