package UserInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomePanel extends JPanel {
    private LoginPage loginPage;
    private JButton loginButton, signUpButton;
    private ActionListener loginListener;

    public WelcomePanel(ActionListener loginListener) {
        this.loginListener = loginListener;
        setLayout(new BorderLayout());

        // Create a JLabel to hold the background image
        JLabel backgroundLabel = new JLabel(new ImageIcon("/Users/muhammadhamzasohail/Desktop/Library-Management-Banner.png"));
        backgroundLabel.setLayout(new BorderLayout());

        // Create a label for the heading
        JLabel headingLabel = new JLabel("Welcome to York's Library Management System", SwingConstants.CENTER);
        headingLabel.setFont(new Font("Arial", Font.BOLD, 36));

        // Create a panel for the heading and add some space below it
        JPanel headingPanel = new JPanel(new BorderLayout());
        headingPanel.add(headingLabel, BorderLayout.NORTH);
        headingPanel.add(Box.createVerticalStrut(50), BorderLayout.CENTER); // Add space below the heading

        // Add the heading panel to the background label
        backgroundLabel.add(headingPanel, BorderLayout.NORTH);

        // Create button panel
        JPanel buttonPanel = new JPanel(new FlowLayout());
        loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginPage = new LoginPage(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        loginListener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Login"));
                    }
                });
                removeAll();
                add(loginPage);
                revalidate();
                repaint();
            }
        });
        loginButton.setFont(new Font("Arial", Font.PLAIN, 24));
        buttonPanel.add(loginButton);

        signUpButton = new JButton("Sign Up");
        signUpButton.setFont(new Font("Arial", Font.PLAIN, 24));
        buttonPanel.add(signUpButton);

        // Add button panel to the background label
        backgroundLabel.add(buttonPanel, BorderLayout.SOUTH);

        // Add the background label to the WelcomePanel
        add(backgroundLabel, BorderLayout.CENTER);
    }
}

