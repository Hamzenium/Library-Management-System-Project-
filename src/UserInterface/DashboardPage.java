package UserInterface;

import javax.swing.*;
import Users.User;
import java.awt.*;
import java.awt.event.*;

public class DashboardPage extends JPanel {
    private User currentUser;

    public DashboardPage(User user) {
        this.currentUser = user;

        setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel(new GridLayout(3, 2, 10, 10));

        JButton viewBooksButton = new JButton("View Books");
        viewBooksButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Show the list of requested books for the current user
                JOptionPane.showMessageDialog(null, currentUser.getRequestBookList(), "Requested Books", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        buttonPanel.add(viewBooksButton);

        JButton viewDeadlinesButton = new JButton("View Deadlines");
        // Assuming viewDeadlinesButton handles view deadlines action
        buttonPanel.add(viewDeadlinesButton);

        JButton requestButton = new JButton("Request a Book");
        // Assuming requestButton handles request book action
        buttonPanel.add(requestButton);

        JButton newsletterButton = new JButton("Newsletter");
        // Assuming newsletterButton handles newsletter action
        buttonPanel.add(newsletterButton);

        JButton recommendedBooksButton = new JButton("Recommended Books");
        // Assuming recommendedBooksButton handles recommended books action
        buttonPanel.add(recommendedBooksButton);

        add(buttonPanel, BorderLayout.CENTER);
    }

	public void setUser(User user) {
		// TODO Auto-generated method stub
		 this.currentUser = user;
	}
}

