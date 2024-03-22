package UserInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class LoginPage extends JPanel {
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private ActionListener actionListener;
    private BufferedImage backgroundImage;

    public LoginPage(ActionListener listener) {
        setLayout(new BorderLayout());
        actionListener = listener;

        // Create a panel for sign-in components
        JPanel signInPanel = new JPanel(new GridBagLayout());
        signInPanel.setOpaque(false); // Make the panel transparent

        // Create constraints for layout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Padding

        JLabel titleLabel = new JLabel("Login Page", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Set font to bold and size 24
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        signInPanel.add(titleLabel, gbc);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 18)); // Set font to bold and size 18
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        signInPanel.add(emailLabel, gbc);

        emailField = new JTextField(20);
        emailField.setFont(new Font("Arial", Font.PLAIN, 18)); // Set font size 18
        gbc.gridx = 1;
        gbc.gridy = 1;
        signInPanel.add(emailField, gbc);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 18)); // Set font to bold and size 18
        gbc.gridx = 0;
        gbc.gridy = 2;
        signInPanel.add(passwordLabel, gbc);

        passwordField = new JPasswordField(20);
        passwordField.setFont(new Font("Arial", Font.PLAIN, 18)); // Set font size 18
        gbc.gridx = 1;
        gbc.gridy = 2;
        signInPanel.add(passwordField, gbc);

        loginButton = new JButton("Login");
        loginButton.setFont(new Font("Arial", Font.PLAIN, 18)); // Set font to bold and size 18
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        signInPanel.add(loginButton, gbc);

        // Add action listener to login button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = getEmail();
                String password = getPassword();
                // Invoke the ActionListener provided from the constructor
                actionListener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Login"));
            }
        });

        // Add the sign-in panel to the center of the main panel
        add(signInPanel, BorderLayout.CENTER);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw the background image
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }

    public String getEmail() {
        return emailField.getText();
    }

    public String getPassword() {
        return new String(passwordField.getPassword());
    }
}


