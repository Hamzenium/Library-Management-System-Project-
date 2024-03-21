 package UserInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Users.User;

public class LibraryManagementSystem extends JFrame implements ActionListener {
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private WelcomePanel welcomePanel;
    private LoginPage loginPage;
    private SignUpPage signUpPage;
    private DashboardPage dashboardPage;
    private User currentUser; // Reference to the current user object

    public LibraryManagementSystem() {
        setTitle("York's Library Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        cardPanel = new JPanel();
        cardPanel.setLayout(cardLayout);

        welcomePanel = new WelcomePanel(this);
        cardPanel.add(welcomePanel, "Welcome");

        loginPage = new LoginPage(this);
        cardPanel.add(loginPage, "Login");

        signUpPage = new SignUpPage(this);
        cardPanel.add(signUpPage, "SignUp");

        // Initially, create a blank DashboardPage
        dashboardPage = new DashboardPage(currentUser);
        cardPanel.add(dashboardPage, "Dashboard");

        add(cardPanel);
        setVisible(true);
    }

    // Method to handle successful login
    public void handleSuccessfulLogin(String email, String password) {
        // Create a new user object with the provided email and password
        currentUser = new User(email, password);
        System.out.println(currentUser);
        // Update the DashboardPage with the user information
        dashboardPage.setUser(currentUser);
        // Switch to the DashboardPage
        cardLayout.show(cardPanel, "Dashboard");
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Login")) {
            cardLayout.show(cardPanel, "Login");
        } else if (e.getActionCommand().equals("Sign Up")) {
            cardLayout.show(cardPanel, "SignUp");
        } else if (e.getActionCommand().equals("Login Successful")) {
            // Get email and password from the LoginPage and handle successful login
            String email = loginPage.getEmail();
            String password = loginPage.getPassword();
            handleSuccessfulLogin(email, password);
        }
    }

    public static void main(String[] args) {
        new LibraryManagementSystem();
    }
}
