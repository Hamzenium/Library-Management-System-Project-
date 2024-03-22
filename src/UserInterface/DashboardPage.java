package UserInterface;

import javax.swing.*;

import Items.Book;
import Items.Item;
import LibraryManagementSystem.LibraryManagementSystem;
import Payment.Payment;
import Users.ManagementTeam;
import Users.Student;
import Users.User;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class DashboardPage extends JFrame implements ActionListener {
    private Student user1;
    private ArrayList<Item> bookList; // ArrayList to hold books

    public DashboardPage(Student user, ArrayList<Item> bookList) {
        this.user1 = user;
        this.bookList = bookList; // Set the book list
        setTitle("Dashboard Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Calculate the size to be 60% of the screen size
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) (screenSize.getWidth() * 0.6);
        int height = (int) (screenSize.getHeight() * 0.6);
        setSize(width, height);

        setLocationRelativeTo(null);

        // Create a JLabel to hold the background image
        JLabel background = new JLabel(new ImageIcon("/Users/muhammadhamzasohail/Desktop/beige-abstract-wallpaper-background-image.jpg"));
        background.setLayout(new GridLayout(5, 1)); // Adjust layout to add components

        // Create the panel for buttons
        JPanel buttonPanel1 = new JPanel(new GridLayout(1, 2));
        buttonPanel1.setOpaque(false); // Make the panel transparent

        JButton viewBooksButton = new JButton("View Books");
        viewBooksButton.addActionListener(this);
        buttonPanel1.add(viewBooksButton);

        JButton viewDeadlinesButton = new JButton("View Deadlines");
        viewDeadlinesButton.addActionListener(this);
        buttonPanel1.add(viewDeadlinesButton);

        // Create the second row of buttons
        JPanel buttonPanel2 = new JPanel(new GridLayout(1, 2));
        buttonPanel2.setOpaque(false); // Make the panel transparent

        JButton requestBookButton = new JButton("Request a Book");
        requestBookButton.addActionListener(this);
        buttonPanel2.add(requestBookButton);

        JButton newsletterButton = new JButton("Newsletter");
        newsletterButton.addActionListener(this);
        buttonPanel2.add(newsletterButton);

        // Create the third row of buttons
        JPanel buttonPanel3 = new JPanel(new GridLayout(1, 2));
        buttonPanel3.setOpaque(false); // Make the panel transparent

        JButton recommendedBooksButton = new JButton("Recommended Books");
        recommendedBooksButton.addActionListener(this);
        buttonPanel3.add(recommendedBooksButton);

        JButton searchBookButton = new JButton("Search Book");
        searchBookButton.addActionListener(this);
        buttonPanel3.add(searchBookButton);

        // Create the fourth row of buttons
        JPanel buttonPanel4 = new JPanel(new GridLayout(1, 2));
        buttonPanel4.setOpaque(false); // Make the panel transparent

        JButton viewRequestedBooksButton = new JButton("View Requested Books");
        viewRequestedBooksButton.addActionListener(this);
        buttonPanel4.add(viewRequestedBooksButton);

        JButton addBookButton = new JButton("Add Book");
        addBookButton.addActionListener(this);
        buttonPanel4.add(addBookButton);

        // Add button panels to the background label
        background.add(buttonPanel1);
        background.add(buttonPanel2);
        background.add(buttonPanel3);
        background.add(buttonPanel4);

        // Set the content pane to the background label
        setContentPane(background);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle button clicks
        String command = e.getActionCommand();
        switch (command) {
            case "View Books":
                displayBooks();
                break;
            case "View Deadlines":
                break;
            case "Request a Book":
                // Handle request book action
                break;
            case "Newsletter":
                // Handle newsletter action
                break;
            case "Recommended Books":
                // Handle recommended books action
                break;
            case "Search Book":
                // Handle search book action
            	searchBooks();
                break;
            case "View Requested Books":
                displayRequestedBooks(); // Call method to display requested books
                break;
            case "Make Payment":
                // Handle make payment action
                break;
            default:
                break;
        }
    }

    private void displayBooks() {
        JFrame booksFrame = new JFrame("Books");

        // Calculate the size to be 60% of the screen size
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) (screenSize.getWidth() * 0.3);
        int height = (int) (screenSize.getHeight() * 0.6);
        booksFrame.setSize(width, height);

        JPanel booksPanel = new JPanel();
        booksPanel.setLayout(new BoxLayout(booksPanel, BoxLayout.Y_AXIS)); // Set Y_AXIS alignment

        for (int i = 0; i < user1.getBooks().size(); i++) {
            int counter = i + 1;
            Item book = user1.getBooks().get(i);
            JPanel bookInfoPanel = new JPanel();
            bookInfoPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1)); // Add border
            bookInfoPanel.setBackground(Color.WHITE); // Set background color
            bookInfoPanel.setAlignmentX(Component.LEFT_ALIGNMENT); // Align components to the left
            bookInfoPanel.setLayout(new BoxLayout(bookInfoPanel, BoxLayout.Y_AXIS)); // Set Y_AXIS alignment

            JLabel indexLabel = new JLabel("Book: " + counter);
            JLabel nameLabel = new JLabel("Name: " + book.getName());
            JLabel idLabel = new JLabel("ID: " + book.getIdentificationNumber());

            indexLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
            nameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
            idLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

            bookInfoPanel.add(indexLabel);
            bookInfoPanel.add(Box.createVerticalStrut(5)); // Add vertical space
            bookInfoPanel.add(nameLabel);
            bookInfoPanel.add(idLabel);

            booksPanel.add(bookInfoPanel);
            booksPanel.add(Box.createVerticalStrut(10)); // Add vertical space between boxes
        }

        JScrollPane scrollPane = new JScrollPane(booksPanel); // Add scroll pane for vertical scrolling
        booksFrame.add(scrollPane);
        booksFrame.setLocationRelativeTo(null);
        booksFrame.setVisible(true);
    }
    public static void main(String[] args) throws Exception {
        // Create sample users
    	
        ManagementTeam team = ManagementTeam.getInstance("email", "psw");
        ArrayList<Item> bookList = new ArrayList<Item>();
        Student user1 = new Student("hamza.sohail29@gmail.com", "hamza123");
        // Add some books to user1
        Book javaBook = new Book(2232, "Toronto", true, 3, "20 Jan", true, "Java OOP book","programming");
        Book systemdesignBook = new Book(4343, "Toronto", true, 3, "12 Jan", true, "System Design book","programming");
        Book mechanics = new Book(2434, "Toronto", true, 3, "23 Jan", true, "Polymer Mechanical Properties","mechanics");
        Book mechanics2 = new Book(2434, "Toronto", true, 3, "23 Jan", true, "Chemical Properties of Acids","chemsitry");
        Book systemDesignBook = new Book(4343, "New York", true, 4, "12 Jan", true, "System Design book","programming");
        Book mechanics1 = new Book(2434, "London", true, 5, "23 Jan", true, "Polymer Mechanical Properties 1","mechanics");
        Book mechanics3 = new Book(2436, "Berlin", true, 1, "28 Jan", true, "Polymer Mechanical Properties 3","mechanics");
        Book chemistry1 = new Book(2437, "Sydney", true, 6, "30 Jan", true, "Chemical Properties of Acids 1","chemistry");
        Book chemistry2 = new Book(2438, "Tokyo", true, 3, "02 Feb", true, "Chemical Properties of Acids 2","chemistry");
        Book chemistry3 = new Book(2439, "Beijing", true, 4, "05 Feb", true, "Chemical Properties of Acids 3","chemistry");
        Book physics1 = new Book(2440, "Moscow", true, 2, "08 Feb", true, "Physics for Beginners 1","physics");
        Book physics2 = new Book(2441, "Rome", true, 1, "11 Feb", true, "Physics for Beginners 2","physics");
        Book physics3 = new Book(2442, "Athens", true, 5, "14 Feb", true, "Physics for Beginners 3","physics");
        Book history1 = new Book(2443, "Cairo", true, 3, "17 Feb", true, "World History 1","history");
        Book history2 = new Book(2444, "Dubai", true, 4, "20 Feb", true, "World History 2","history");
        Book history3 = new Book(2445, "Mumbai", true, 2, "23 Feb", true, "World History 3","history");
        Book fiction1 = new Book(2446, "Istanbul", true, 1, "26 Feb", true, "Fiction Novels 1","novels");
        Book fiction2 = new Book(2447, "Bangkok", true, 6, "01 Mar", true, "Fiction Novels 2","novels");
        Book fiction3 = new Book(2448, "Seoul", true, 3, "04 Mar", true, "Fiction Novels 3","novels");
        Book arts1 = new Book(2449, "Kuala Lumpur", true, 4, "07 Mar", true, "Art History 1","history");
        Book arts2 = new Book(2450, "Singapore", true, 2, "10 Mar", true, "Art History 2","history");
        Book arts3 = new Book(2451, "Manila", true, 5, "13 Mar", true, "Art History 3","history");
        
        
        bookList.add(javaBook);
        bookList.add(systemdesignBook);
        bookList.add(mechanics);
        bookList.add(mechanics2);
        bookList.add(systemDesignBook);
        bookList.add(mechanics1);
        bookList.add(mechanics3);
        bookList.add(chemistry1);
        bookList.add(chemistry2);
        bookList.add(chemistry3);
        bookList.add(physics1);
        bookList.add(physics2);
        bookList.add(physics3);
        bookList.add(history1);
        bookList.add(history2);
        bookList.add(history3);
        bookList.add(fiction1);
        bookList.add(fiction2);
        bookList.add(fiction3);
        bookList.add(arts1);
        bookList.add(arts2);
        bookList.add(arts3);

        team.searchBook(null);
        

        user1.addRequestBook(systemdesignBook);
        user1.addRequestBook(javaBook);
        user1.addRequestBook(mechanics);
        user1.addRequestBook(mechanics2);
        team.enableItem(user1, javaBook);
        team.enableItem(user1, systemdesignBook);
        team.verifyClient(user1, true);
        Payment payment = new Payment();
        payment.makePayment(user1, systemdesignBook);
        payment.makePayment(user1, javaBook);
        user1.getRequestBookList();

        // Create a JFrame to hold the WelcomePanel
        JFrame welcomeFrame = new JFrame("Welcome to York's Library Management System");
        welcomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        welcomeFrame.setSize(800, 600);
        welcomeFrame.setLocationRelativeTo(null);

        // Create the WelcomePanel and add it to the JFrame
        WelcomePanel welcomePanel = new WelcomePanel(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open the DashboardPage when the login button is clicked
                welcomeFrame.dispose(); // Close the WelcomeFrame
                new DashboardPage(user1,bookList);

            }
        });
        welcomeFrame.add(welcomePanel);

        welcomeFrame.setVisible(true);
    }


    private void displayRequestedBooks() {
        JFrame requestedBooksFrame = new JFrame("Requested Books");

        // Calculate the size to be 60% of the screen size
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) (screenSize.getWidth() * 0.3);
        int height = (int) (screenSize.getHeight() * 0.6);
        requestedBooksFrame.setSize(width, height);

        JPanel requestedBooksPanel = new JPanel();
        requestedBooksPanel.setLayout(new BoxLayout(requestedBooksPanel, BoxLayout.Y_AXIS)); // Set Y_AXIS alignment

        for (Entry<Item, Boolean> entry : user1.getreqBookList().entrySet()) {
            Item requestedBook = entry.getKey();
            boolean status = entry.getValue();
            String statusText = status ? "Approved" : "Pending";

            JPanel requestedBookInfoPanel = new JPanel();
            requestedBookInfoPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1)); // Add border
            requestedBookInfoPanel.setBackground(Color.WHITE); // Set background color
            requestedBookInfoPanel.setAlignmentX(Component.LEFT_ALIGNMENT); // Align components to the left
            requestedBookInfoPanel.setLayout(new BoxLayout(requestedBookInfoPanel, BoxLayout.Y_AXIS)); // Set Y_AXIS alignment

            JLabel nameLabel = new JLabel("Name: " + requestedBook.getName());
            JLabel statusLabel = new JLabel("Status: " + statusText);

            nameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
            statusLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

            requestedBookInfoPanel.add(nameLabel);
            requestedBookInfoPanel.add(Box.createVerticalStrut(5)); // Add vertical space
            requestedBookInfoPanel.add(statusLabel);

            requestedBooksPanel.add(requestedBookInfoPanel);
            requestedBooksPanel.add(Box.createVerticalStrut(10)); // Add vertical space between boxes
        }

        JScrollPane scrollPane = new JScrollPane(requestedBooksPanel); // Add scroll pane for vertical scrolling
        requestedBooksFrame.add(scrollPane);
        requestedBooksFrame.setLocationRelativeTo(null);
        requestedBooksFrame.setVisible(true);
    }
    
    private void searchBooks() {
        JFrame searchBooksFrame = new JFrame("Search Books");

        // Calculate the size to be 60% of the screen size
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) (screenSize.getWidth() * 0.3);
        int height = (int) (screenSize.getHeight() * 0.6);
        searchBooksFrame.setSize(width, height);

        // Panel to hold the search components
        JPanel searchPanel = new JPanel();
        JTextField searchField = new JTextField(20);
        JButton searchButton = new JButton("Search");

        // Panel to display search results
        JPanel searchBooksPanel = new JPanel();
        searchBooksPanel.setLayout(new BoxLayout(searchBooksPanel, BoxLayout.Y_AXIS)); // Set Y_AXIS alignment

        // Scroll pane for the search results panel
        JScrollPane scrollPane = new JScrollPane(searchBooksPanel);

        // ActionListener for the search button
        searchButton.addActionListener(e -> {
            String searchQuery = searchField.getText().toLowerCase();
            searchBooksPanel.removeAll(); // Clear previous search results

            boolean found = false;
            for (Item book : bookList) {
                // Check if the book name contains the search query (case-insensitive)
                if (book.getName().toLowerCase().contains(searchQuery)) {
                    JPanel bookInfoPanel = new JPanel();
                    bookInfoPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1)); // Add border
                    bookInfoPanel.setBackground(Color.WHITE); // Set background color
                    bookInfoPanel.setAlignmentX(Component.LEFT_ALIGNMENT); // Align components to the left
                    bookInfoPanel.setLayout(new BoxLayout(bookInfoPanel, BoxLayout.Y_AXIS)); // Set Y_AXIS alignment

                    JLabel nameLabel = new JLabel("Name: " + book.getName());
                    JLabel authorLabel = new JLabel("Author: " + book.getIdentificationNumber());
                    JLabel genreLabel = new JLabel("Genre: " + book.getAvailableForPurchase());

                    nameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
                    authorLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
                    genreLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

                    bookInfoPanel.add(nameLabel);
                    bookInfoPanel.add(Box.createVerticalStrut(5)); // Add vertical space
                    bookInfoPanel.add(authorLabel);
                    bookInfoPanel.add(genreLabel);

                    searchBooksPanel.add(bookInfoPanel);
                    searchBooksPanel.add(Box.createVerticalStrut(10)); // Add vertical space between boxes

                    found = true;
                }
            }

            // Check if no matching book was found
            if (!found) {
                JLabel noResultLabel = new JLabel("No matching book found.");
                searchBooksPanel.add(noResultLabel);
            }

            // Refresh the panel to reflect changes
            searchBooksPanel.revalidate();
            searchBooksPanel.repaint();
        });

        // Add components to the search panel
        searchPanel.add(searchField);
        searchPanel.add(searchButton);

        // Add components to the frame
        searchBooksFrame.getContentPane().setLayout(new BorderLayout());
        searchBooksFrame.getContentPane().add(searchPanel, BorderLayout.NORTH);
        searchBooksFrame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        searchBooksFrame.setVisible(true);
    }
}

