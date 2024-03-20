package Courses;


public class Course {
	

	private String courseName;
	private int courseID;
	
	public Course(String name, int id) {
		this.courseName = name;
		this.courseID = id;
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
	
}
