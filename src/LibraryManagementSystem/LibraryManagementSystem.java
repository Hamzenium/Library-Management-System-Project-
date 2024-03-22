package LibraryManagementSystem;

import java.util.ArrayList;
import java.util.HashMap;

import Courses.Course;
import Items.Item;
import Items.OnlineBook;
import Users.Student;
import Users.User;

public class LibraryManagementSystem {
	
	
	private static LibraryManagementSystem instance;
	private  ArrayList<User> loggedInUsers;
	private  ArrayList<OnlineBook> onlineBooks;
	private  ArrayList<Course> course;
	
	private LibraryManagementSystem() {
		
		this.onlineBooks = new ArrayList<>();
		this.loggedInUsers = new ArrayList<>();
		this.course =  new ArrayList<>();
	}
	
	public static LibraryManagementSystem getInstance() {
		if (instance == null) {
			instance = new LibraryManagementSystem();
		}
		return instance;
	}
	
	public ArrayList<User> getLoggedInUsers() {
		return loggedInUsers;
	}
	public void setLoggedInUsers(User user) {
		this.loggedInUsers.add(user);
	}
	public ArrayList<OnlineBook> getOnlineBooks() {
		return onlineBooks;
	}
	
	public ArrayList<Course> getCourse() {
		return course;
	}

	public void addCourse(Course course) {
		this.course.add(course);
	}

	public Course searchCourse(String search) {
		for(Course course: this.course) {
			if(course.getCourseName() == search) {
				return course;
			}
		}
		return null;
	}

	public  HashMap<Item, String> showDueDates(User user){
		
		HashMap<Item, String> dueDates = new HashMap<>();
		
		for (int i =0; i < instance.loggedInUsers.size(); i++){
			
		if (instance.loggedInUsers.get(i).getEmail().equals(user.getEmail())) {
			
			for (int j = 0; j< user.getBooks().size(); j++) {
				
				dueDates.put(user.getBooks().get(j), user.getBooks().get(j).getDueDates());
			}
		}
			
		}
		
		return dueDates;
		
		
	}
	
	public void makeVirtualCopiesAvailable(Student user) {
	    for (int i = 0; i < user.getCoursesTaking().size(); i++) {
	        for (int j = 0; j < instance.onlineBooks.size(); j++) {
	            if (user.getCoursesTaking().get(i).getCourseName().equals(instance.onlineBooks.get(j).getCourseName())) {
	                boolean bookAlreadyAdded = false;
	                for (Item textbook : user.getCourseTextBooks()) {
	                    if (textbook instanceof OnlineBook && ((OnlineBook) textbook).getCourseName().equals(instance.onlineBooks.get(j).getCourseName())) {
	                        bookAlreadyAdded = true;
	                        break;
	                    }
	                }
	                if (!bookAlreadyAdded) {
	                    user.setCourseTextBooks(instance.onlineBooks.get(j));
	                }
	            }
	        }
	    }
	}
	}
