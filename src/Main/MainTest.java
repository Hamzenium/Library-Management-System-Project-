package Main;
import Courses.Course;

import Items.Book;
import Items.CourseTextbook;
import Items.OnlineBook;
import LibraryManagementSystem.LibraryManagementSystem;
import Newsletters.Newsletter;
import Payment.DiscountedPaymentDecorator;
import Payment.Payment;
import Payment.PenaltyPaymentDecorator;
import Payment.PenaltyPaymentDecorator;
import Users.Faculty;
import Users.ManagementTeam;
import Users.Student;
import Users.User;
import Users.Visitors;
public class MainTest {

	
	public static PenaltyPaymentDecorator wrapPaymentWithPenalty(int penaltyCount) {
	    Payment payment = new Payment();
	    PenaltyPaymentDecorator wrappedPayment = new PenaltyPaymentDecorator(payment);
	    
	    for (int i = 1; i < penaltyCount; i++) {
	        wrappedPayment = new PenaltyPaymentDecorator(wrappedPayment);
	    }
	    
	    return wrappedPayment;
	}
public static void main(String[] args) throws Exception {
//	    
	    Visitors user1 = new Visitors("Hamza13", "hamza.sohail29@gmail.com");
	    Book javaBook = new Book(2, "Toronto", true, 3, "12 Jan", true, "Java OOP book");
	    Book systemdesginBook = new Book(4, "Toronto", true, 3, "12 Jan", true, "System Design book");
	    user1.addRequestBook(javaBook);
	    user1.addRequestBook(systemdesginBook);
	    user1.getBooks();
	    
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
           
           

//           to first add the course
// the user first needs to be verified by the mangment team,
// then the user can add request book method to request for a book
           //the the managemnt team needs to enable the item to be borrowed by the person
           // the user needs to then add pay for the item 
           // then the user can add the item which being the book to their book list

          user.addRequestBook(b6);
          ManagementTeam team = ManagementTeam.getInstance("email", "psw");

          PenaltyPaymentDecorator payment = wrapPaymentWithPenalty(2);
          
          System.out.println("\n"+payment.cost());

           System.out.println("\n");
          team.verifyClient(user, true);
          team.enableItem(user, b6);
//          payment.makePayment(user, b6);
          
       // Apply discount twice
       // Apply discount twice
  
          // Now 'payment' is wrapped with DiscountedPaymentDecorator twice


          // Now 'payment' is wrapped with DiscountedPaymentDecorator twice

//          
//          
//          
//        System.out.println(user.getBooks());
//           user.logout();
//           user.login("bob", "psw");
//          System.out.println(system.showDueDates(user));
//          System.out.println(system.getLoggedInUsers());
//          System.out.println(system.getOnlineBooks());
          
          Newsletter geonews = new Newsletter("CricInfo Newsletter");
          
          user.subscribe(geonews);
          String word ="heelo !";
          geonews.update(word);


}
     


}

   


