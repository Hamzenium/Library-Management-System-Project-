package Courses;

import Items.CourseTextbook;
import LibraryManagementSystem.LibraryManagementSystem;

public class Course {
	

	private String courseName;
	private int courseID;
	private CourseTextbook textbook;
	
	public Course(String name, int id) {
		this.courseName = name;
		this.courseID = id;
		
		LibraryManagementSystem system = LibraryManagementSystem.getInstance();
		system.addCourse(this);
		
		
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getCourseID() {
		return courseID;
	}
	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}
	
	public void setTextBook(CourseTextbook book) {
		
		this.textbook = book;
		
	}
	
public CourseTextbook getTextBook() {
		
		return this.textbook;
		
	}
	
}
