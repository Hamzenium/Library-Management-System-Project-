package Items;

import Courses.Course;
import LibraryManagementSystem.LibraryManagementSystem;

public class CourseTextbook extends OnlineBook {
	
	private String courseName;

	public CourseTextbook(int id, String name, String course,String category) {
		super(id, name,category);
		this.courseName = course;
		
		LibraryManagementSystem system = LibraryManagementSystem.getInstance();
	}

	@Override
	public String getCourseName() {
		return courseName;
	}

	public void setourseName(String course) {
		this.courseName = course;
	}

}
