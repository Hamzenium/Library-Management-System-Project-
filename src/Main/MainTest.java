package Main;
import Items.Book;
import Users.ManagementTeam;
import Users.Visitors;
import Payment.Payable;
import Payment.DiscountedPaymentDecorator;
import Payment.Payment;
import Payment.PaymentDecorator;
import Payment.PenaltyPaymentDecorator;

public class MainTest {

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
	}



}
