package Users;
import Items.Item;
import LibraryManagementSystem.LibraryManagementSystem;

import java.util.ArrayList;

import Courses.Course;
public class Student extends User {

	private ArrayList<Course> coursesTaking;
	private ArrayList<Item> courseTextBooks;
	
	public Student(String email, String psw) {
		super(email, psw);
		this.coursesTaking = new ArrayList<Course>();;
		this.courseTextBooks = new ArrayList<Item>();
	}
	
	public ArrayList<Course> getCoursesTaking() {
		return coursesTaking;
	}
	public void setCoursesTaking(Course course) {
		this.coursesTaking.add(course);
		LibraryManagementSystem system = LibraryManagementSystem.getInstance();
		system.makeVirtualCopiesAvailable(this);
	}
	
	public void removeCourse(Course course) {
		
		this.coursesTaking.remove(course);
		
		for (int i=0; i<courseTextBooks.size(); i++) {
			
			if (courseTextBooks.get(i).getName().equals(course.getCourseName())) {
				
				courseTextBooks.remove(i);
			}
			
		}
		
	}
	public ArrayList<Item> getCourseTextBooks() {
		return courseTextBooks;
	}
	public void setCourseTextBooks(Item courseTextBook) {
		this.courseTextBooks.add(courseTextBook);
	}
	

}
