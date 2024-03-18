package Users;
import Items.Item;
import Courses.Course;
public class Student extends User {

	private Course[] coursesTaking;
	private Item[] courseTextBooks;
	public Student(String psw, String email) {
		super(psw, email);
	}

}
