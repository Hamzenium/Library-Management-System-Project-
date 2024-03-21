package UserInterface;

import Users.User;
import javax.swing.*;

import Items.CourseTextbook;

import java.awt.*;
import java.awt.event.*;

public class SignUpPage extends JPanel {
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton signUpButton;
    private ActionListener actionListener;

    public SignUpPage(ActionListener listener) {
        setLayout(new GridLayout(4, 1));
        actionListener = listener;

        JLabel titleLabel = new JLabel("Sign Up Page", SwingConstants.CENTER);
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

        signUpButton = new JButton("Sign Up");
        signUpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get email and password from text fields
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());

                // Create a new user object
                User newUser = new User(email, password);
                CourseTextbook b1 = new CourseTextbook(5, "Calc2", "Maths", "Maths");
                newUser.addRequestBook(b1);

                // Dispatch "Sign Up Successful" action command
                actionListener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Sign Up Successful"));
            }
        });
        add(signUpButton);
    }
}
