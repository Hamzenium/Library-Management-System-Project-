package LibraryManagementSystem;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

import Courses.Course;
import Items.Item;
import Items.OnlineBook;
import Items.PhyscialItem;
import Users.Student;
import Users.User;

public class LibraryManagementSystem {
	
	
	private static LibraryManagementSystem instance;
	private  ArrayList<User> loggedInUsers;
	private  ArrayList<OnlineBook> onlineBooks;
	private  ArrayList<Course> course;
	private ArrayList<PhyscialItem> physicalItem;
	
	private LibraryManagementSystem() {
		
		this.onlineBooks = new ArrayList<>();
		this.loggedInUsers = new ArrayList<>();
		this.course =  new ArrayList<>();
		this.physicalItem =  new ArrayList<>();
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
	
	public ArrayList<PhyscialItem> getPhysicalItem(){
		
		return this.physicalItem;
	}
	
	public void addPhyscialItem(PhyscialItem item) {
		
		this.physicalItem.add(item);
		
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
	public  ArrayList<String> showDueDatesIndividual(User user){
		
		ArrayList<String> list = new ArrayList<String>();
		String output = "";
			
			for (int j = 0; j< user.getBooks().size(); j++) {
				
				output = user.getBooks().get(j).getName() +" : "+  user.getBooks().get(j).getDueDates();
				list.add(output);
				output = "";
			}
		
		
		return list;
		
		
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
	    
	   public ArrayList<Item> showRecommendations(Item item){
		   
		   ArrayList<Item> reccomendations = new ArrayList<>();
		   
		   for (int i=0; i<instance.getOnlineBooks().size();i++) {
			   
			   if (instance.getOnlineBooks().get(i).getCategory().equals(item.getCategory())
					   && !instance.getOnlineBooks().get(i).getName().equals(item.getName())) {
				   
				   reccomendations.add(instance.getOnlineBooks().get(i));
				   
			   }
			   
		   }
		   
       for (int j=0; j<instance.getPhysicalItem().size();j++) {
			   
			   if (instance.getPhysicalItem().get(j).getCategory().equals(item.getCategory())
					   && !instance.getPhysicalItem().get(j).getName().equals(item.getName())) {
				   
				   reccomendations.add(instance.getPhysicalItem().get(j));
				   
			   }
			   
		   }
		return reccomendations;   
	    
	}
	}
