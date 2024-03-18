package Users;

import Courses.Course;
import Items.Item;

public class Faculty extends User{

	private Item[] booksUsed;
	private Course[] coursesTeaching;
	
	public Faculty(String psw, String email) {
		super(psw, email);
		this.booksUsed =  new Item[50];
		this.coursesTeaching = new Course[50];
	}
	
    public Item[] getBooksUsed() {
		return booksUsed;
	}
	public void setBooksUsed(Item[] booksUsed) {
		this.booksUsed = booksUsed;
	}
	public Course[] getCoursesTeaching() {
		return coursesTeaching;
	}
	public void setCoursesTeaching(Course[] coursesTeaching) {
		this.coursesTeaching = coursesTeaching;
	}
	


}
