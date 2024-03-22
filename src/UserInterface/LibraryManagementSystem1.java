
package UserInterface;

import javax.swing.*;

import Items.Book;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import LibraryManagementSystem.LibraryManagementSystem;
import Payment.Payment;
import Users.ManagementTeam;
import Users.Student;
import Users.User;

public class LibraryManagementSystem1 extends JFrame implements ActionListener {
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private LoginPage loginPage;
    private WelcomePanel welcomePanel;
    private DashboardPage dashboardPage;
    private User currentUser; // Reference to the current user object

    public LibraryManagementSystem1() {
        setTitle("York's Library Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set up the card layout
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // Initialize the login page
        loginPage = new LoginPage(this);
        cardPanel.add(loginPage, "Login");

        // Initialize the dashboard page
        dashboardPage = new DashboardPage(currentUser);
        cardPanel.add(dashboardPage, "Dashboard");

        // Initialize the welcome panel
        welcomePanel = new WelcomePanel(this);
        cardPanel.add(welcomePanel, "Welcome");

        // Add the card panel to the frame
        add(cardPanel);

        // Show the welcome panel
        cardLayout.show(cardPanel, "Welcome");

        // Calculate the size to cover 60% of the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) (screenSize.width * 0.6);
        int height = (int) (screenSize.height * 0.6);
        setSize(width, height);

        // Center the frame
        setLocationRelativeTo(null);

        // Show the frame
        setVisible(true);
    }

    // Method to handle successful login
    public void handleSuccessfulLogin(String email, String password) {
        // Retrieve the list of users from the LibraryManagementSystem
        LibraryManagementSystem system = LibraryManagementSystem.getInstance();
        ArrayList<User> users = system.getLoggedInUsers();

        // Iterate through the list of users
        for (User user : users) {
            // Check if the provided email and password match with the user's credentials
            if (user.getEmail().equals(email) && user.getPsw().equals(password)) {
                // If a match is found, assign the user to currentUser
                currentUser = user;
                // Update the DashboardPage with the user information
                dashboardPage.setUser(currentUser);
                // Switch to the DashboardPage
                cardLayout.show(cardPanel, "Dashboard");
                return; // Exit the loop if user is found
            }
        }

        // If no user with matching email and password is found
        System.out.println("Invalid email or password. Please try again.");
        // Optionally, display an error message on the login page
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Login")) {
            // Get email and password from the login page and handle successful login
            String email = loginPage.getEmail();
            String password = loginPage.getPassword();
            handleSuccessfulLogin(email, password);
        }
    }

    public static void main(String[] args) {
        // Run the Library Management System
        SwingUtilities.invokeLater(() -> {
            LibraryManagementSystem1 lms = new LibraryManagementSystem1();

            // Create LibraryManagementSystem instance
            LibraryManagementSystem system = LibraryManagementSystem.getInstance();

            // Create sample users
            Student user1 = new Student("hamza.sohail29@gmail.com", "hamza123");
    	    Book javaBook = new Book(2, "Toronto", true, 3, "12 Jan", true, "Java OOP book");
    	    Book systemdesginBook = new Book(4, "Toronto", true, 3, "12 Jan", true, "System Design book");
            // Set logged-in users
            system.setLoggedInUsers(user1);
            user1.addRequestBook(javaBook);
            
            ManagementTeam team = ManagementTeam.getInstance("email", "psw");
    	    Payment payment = new Payment();
 
    	    team.enableItem(user1, javaBook);
    	    team.enableItem(user1, systemdesginBook);
    	    team.verifyClient(user1, true);
            

            // Get logged-in users
            ArrayList<User> loggedInUsers = system.getLoggedInUsers();
            for (User user : loggedInUsers) {
                if (user instanceof Student) {
                    Student student = (Student) user;
                    System.out.println("Student logged in: " + student.getEmail());
                }
                // Add conditions for other types of users if necessary
            }
        });
    }
}


