package UserInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomePanel extends JPanel {
    private JButton loginButton, signUpButton;
    private ImageIcon backgroundImage;
    private ActionListener loginListener; // ActionListener for login button

    public WelcomePanel(ActionListener loginListener) {
        this.loginListener = loginListener; // Assign the ActionListener for login button
        setLayout(new BorderLayout());

        // Load the background image (Replace the path with your actual image path)
        backgroundImage = new ImageIcon("/Users/muhammadhamzasohail/Desktop/Library-Management-Banner.png");

        // Create a label for the heading
        JLabel headingLabel = new JLabel("Welcome to York's Library Management System", SwingConstants.CENTER);
        headingLabel.setFont(new Font("Arial", Font.BOLD, 36));

        // Create a panel for the heading and add some space below it
        JPanel headingPanel = new JPanel(new BorderLayout());
        headingPanel.add(headingLabel, BorderLayout.NORTH);
        headingPanel.add(Box.createVerticalStrut(50), BorderLayout.CENTER); // Add space below the heading

        // Add the heading panel
        add(headingPanel, BorderLayout.NORTH);

        // Create a label for the background image
        JLabel imageLabel = new JLabel(backgroundImage);

        // Add the image label
        add(imageLabel, BorderLayout.CENTER);

        // Create button panel
        JPanel buttonPanel = new JPanel(new FlowLayout());
        loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Forward the action event to the ActionListener provided by the parent class
                loginListener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Login"));
            }
        });
        loginButton.setFont(new Font("Arial", Font.PLAIN, 24));
        buttonPanel.add(loginButton);

        signUpButton = new JButton("Sign Up");
        signUpButton.setFont(new Font("Arial", Font.PLAIN, 24));
        buttonPanel.add(signUpButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
