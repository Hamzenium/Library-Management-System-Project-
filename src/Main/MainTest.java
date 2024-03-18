package Main;
import Items.Book;
import Users.ManagementTeam;
import Users.Visitors;

public class MainTest {

	public static void main(String[] args) throws Exception {
		
		Visitors user1 = new Visitors("Hamza13","hamza.sohail29@gmail.com");
		Book javaBook = new Book(2,"Toronto", true,3,"12 Jan",true, "Java OOP book");
		Book systemdesginBook = new Book(4,"Toronto", true,3,"12 Jan",true, "System Design book");
		user1.addRequestBook(javaBook);
		user1.addRequestBook(systemdesginBook);
		
		ManagementTeam team = new ManagementTeam("Momina234", "momina Mustehsan");
		
		team.enableItem(user1, javaBook);
		team.enableItem(user1, systemdesginBook);
		team.verifyClient(user1, true);
		user1.itemPayment(javaBook);
		user1.itemPayment(systemdesginBook);
		user1.addBooks(javaBook);
		user1.addBooks(systemdesginBook);
		System.out.println(user1.getBookList());
	}


}
