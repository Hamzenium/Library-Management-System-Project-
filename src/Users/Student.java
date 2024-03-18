package Users;
import Items.Item;
import Courses.Course;
public class Student extends User {

	private Course[] coursesTaking;
	private Item[] courseTextBooks;
	
	public Student(String psw, String email) {
		super(psw, email);
		this.coursesTaking = new Course[50];
		this.courseTextBooks = new Item[50];
	}
	
	public Course[] getCoursesTaking() {
		return coursesTaking;
	}
	public void setCoursesTaking(Course[] coursesTaking) {
		this.coursesTaking = coursesTaking;
	}
	public Item[] getCourseTextBooks() {
		return courseTextBooks;
	}
	public void setCourseTextBooks(Item[] courseTextBooks) {
		this.courseTextBooks = courseTextBooks;
	}
	

}
