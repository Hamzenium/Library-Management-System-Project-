package Users;
import Items.Item;

import java.util.ArrayList;

import Courses.Course;
public class Student extends User {

	private ArrayList<Course> coursesTaking;
	private ArrayList<Item> courseTextBooks;
	
	public Student(String psw, String email) {
		super(psw, email);
		this.coursesTaking = new ArrayList<Course>();;
		this.courseTextBooks = new ArrayList<Item>();
	}
	
	public ArrayList<Course> getCoursesTaking() {
		return coursesTaking;
	}
	public void setCoursesTaking(Course course) {
		this.coursesTaking.add(course);
	}
	public ArrayList<Item> getCourseTextBooks() {
		return courseTextBooks;
	}
	public void setCourseTextBooks(Item courseTextBook) {
		this.courseTextBooks.add(courseTextBook);
	}
	

}
