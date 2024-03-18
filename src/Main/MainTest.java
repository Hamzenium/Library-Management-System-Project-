package Main;
import Courses.Course;
import Items.Book;
import Users.ManagementTeam;
import Users.Visitors;

public class MainTest {

	public static void main(String[] args) throws Exception {
		
		Visitors user1 = new Visitors("Hamza13","hamza.sohail29@gmail.com");
		Book javaBook = new Book(2,"Toronto", true,3,"12 Jan",true, "Java OOP book");
		user1.setRequestBook(javaBook);
		
		ManagementTeam team = new ManagementTeam("Momina234", "momina Mustehsan");
		
		team.enableItem(user1, true);
		team.verifyClient(user1, true);
		team.addItem(user1);
		Book itemfound = (Book) user1.getBooks().get(0);
		System.out.println(itemfound.getName());
	}
	

}
