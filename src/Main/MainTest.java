package Main;
import Items.Book;
import Payment.DiscountedPaymentDecorator;
import Payment.Payment;
import Users.ManagementTeam;
import Users.Visitors;

public class MainTest {

	public static void main(String[] args) throws Exception {
	    
	    Visitors user1 = new Visitors("Hamza13", "hamza.sohail29@gmail.com");
	    Book javaBook = new Book(2, "Toronto", true, 3, "12 Jan", true, "Java OOP book");
	    Book systemdesginBook = new Book(4, "Toronto", true, 3, "12 Jan", true, "System Design book");
	    user1.addRequestBook(javaBook);
	    user1.addRequestBook(systemdesginBook);
	    
	    ManagementTeam team = new ManagementTeam("Momina234", "momina Mustehsan");
	    Payment payment = new Payment();

	    // Wrapping the core payment component with decorators
	    payment = new DiscountedPaymentDecorator(payment); // Applying discount
	    payment = new PenaltyPaymentDecorator(payment); // Applying penalty

	    // Making payment
	    payment.makePayment(user1, javaBook);
	    team.enableItem(user1, javaBook);
	    team.enableItem(user1, systemdesginBook);
	    team.verifyClient(user1, true);
	    System.out.println(user1.getBookList());
	}



}
