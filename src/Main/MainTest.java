package Main;
import Courses.Course;
import Items.Book;
<<<<<<< HEAD
=======
import Items.CourseTextbook;
import Items.OnlineBook;
import LibraryManagementSystem.LibraryManagementSystem;
import Payment.DiscountedPaymentDecorator;
import Payment.Payment;
import Users.Faculty;
>>>>>>> Abdullah
import Users.ManagementTeam;
import Users.Student;
import Users.User;
import Users.Visitors;
import Payment.Payable;
import Payment.DiscountedPaymentDecorator;
import Payment.Payment;
import Payment.PaymentDecorator;
import Payment.PenaltyPaymentDecorator;

public class MainTest {

<<<<<<< HEAD
	public static void main(String[] args) throws Exception {
	    
	    Visitors user1 = new Visitors("Hamza13", "hamza.sohail29@gmail.com");
	    Book javaBook = new Book(2, "Toronto", true, 3, "12 Jan", true, "Java OOP book");
	    Book systemdesginBook = new Book(4, "Toronto", true, 3, "12 Jan", true, "System Design book");
	    user1.addRequestBook(javaBook);
	    user1.addRequestBook(systemdesginBook);
	    
	    ManagementTeam team = new ManagementTeam("Momina234", "momina");
	 // Create a basic payment object
	 // Create a basic payment object
	    Payable payment = new Payment(); // Create a basic payment object
	    Payable payment1 = new DiscountedPaymentDecorator(new Payment());// Decorate with DiscountedPaymentDecorator

//	    // Decorate the discounted payment object with PenaltyPaymentDecorator
	    team.enableItem(user1, javaBook);
	    team.enableItem(user1, systemdesginBook);
	    team.verifyClient(user1, true);
	    discountedPayment2.makePayment(user1, javaBook);
	    System.out.println(user1.getBookList());
=======
public static void main(String[] args) throws Exception {
//	    
//	    Visitors user1 = new Visitors("Hamza13", "hamza.sohail29@gmail.com");
//	    Book javaBook = new Book(2, "Toronto", true, 3, "12 Jan", true, "Java OOP book");
//	    Book systemdesginBook = new Book(4, "Toronto", true, 3, "12 Jan", true, "System Design book");
//	    user1.addRequestBook(javaBook);
//	    user1.addRequestBook(systemdesginBook);
//	    
//	    ManagementTeam team = new ManagementTeam("Momina234", "momina Mustehsan");
//	    Payment payment = new Payment();
//
//	    // Wrapping the core payment component with decorators
//	    payment = new DiscountedPaymentDecorator(payment); // Applying discount
//	    payment = new PenaltyPaymentDecorator(payment); // Applying penalty
//
//	    // Making payment
//	    payment.makePayment(user1, javaBook);
//	    team.enableItem(user1, javaBook);
//	    team.enableItem(user1, systemdesginBook);
//	    team.verifyClient(user1, true);
//	    System.out.println(user1.getBookList());
	
	 Student user = new Student("bob", "psw");
	 Course c1 = new Course("Maths",2);
	 CourseTextbook b1 = new CourseTextbook(5, "Calc2", "Maths");
	 
	 LibraryManagementSystem system = LibraryManagementSystem.getInstance();
	 
	 CourseTextbook b2 = new CourseTextbook(5, "Calc3", "Maths2");
	 Course c2 = new Course("Maths2",2);
	 
	 CourseTextbook b3 = new CourseTextbook(5, "Calc1", "Maths1");
	 Course c3 = new Course("Maths1",2);
	 
	 OnlineBook b4 = new OnlineBook(1, "chemistry");
	 
	 Course c4 = new Course("biology",2);
	 
	 
        user.login("bob", "psw");
        user.setCoursesTaking(c1);
        for (int i= 0; i<user.getCourseTextBooks().size(); i++) {
            System.out.print(user.getCourseTextBooks().get(i).getName() + "," );
            }
        
        System.out.println("\n");
        
        user.setCoursesTaking(c2);
        for (int i= 0; i<user.getCourseTextBooks().size(); i++) {
            System.out.print(user.getCourseTextBooks().get(i).getName() + "," );
            }
        
        System.out.println("\n");
        
        user.setCoursesTaking(c3);
        for (int i= 0; i<user.getCourseTextBooks().size(); i++) {
        System.out.print(user.getCourseTextBooks().get(i).getName() + "," );
        }
        
        System.out.println("\n");
        
        
        
        
        Faculty u2 = new Faculty("alex", "psw");
        u2.login("alex", "psw");
        
        for (int i= 0; i<system.getLoggedInUsers().size(); i++) {
            System.out.print(system.getLoggedInUsers().get(i).getEmail() + "," );
            }
            
            System.out.println("\n");
            
           
           u2.logout();
            
           for (int i= 0; i<system.getLoggedInUsers().size(); i++) {
               System.out.print(system.getLoggedInUsers().get(i).getEmail() + "," );
               }
            
           
           Book b6 = new Book(7, "library", true, 20, "March 20", true, "new book");
           
           
          user.addBooks(b6);
           
           user.logout();
           user.login("bob", "psw");
	
>>>>>>> Abdullah
	}


   
     


   

}
