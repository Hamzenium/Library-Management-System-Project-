package Users;

import LibraryManagementSystem.LibraryManagementSystem;
import Payment.PenaltyCalculationStrategy;
import Payment.StudentPenaltyCalculationStrategy;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Items.Item;
import Items.OnlineBook;
import Items.PhyscialItem;

public class User {
	
	
	private String psw;
	private String email;
	private int penalty;
	private ArrayList<Item> books;
	private Boolean canBorrow;
	private Boolean verify;
	protected HashMap<Item,Boolean> requestBook;
	private HashMap<Item,Boolean> payment;
	private HashMap<Item,Double> discount;

	
	public User(String email, String psw) {
		this.books = new ArrayList<Item>();
		this.psw = psw ;
		this.email = email;
		this.penalty = 0;
		this.canBorrow = true;
		this.verify = false;
		this.requestBook = new HashMap<Item,Boolean>();
		this.payment = new HashMap<Item,Boolean>();
		this.discount = new HashMap<Item,Double>();
	}
	
	public void subscribe() {
		
	}
	
	public void cancel() {
		
	}

	public void verify() {
		
	}
	public void login (String email, String psw) throws Exception {
		
		if (this.email.equals(email) && this.psw.equals(psw)) {
			
			LibraryManagementSystem system = LibraryManagementSystem.getInstance();
		    system.getLoggedInUsers().add(this);
		    system.showDueDates(this);
		    System.out.println(system.showDueDates(this));
			
		}
		
		else {
			
			throw new Exception("Login failed");
			
		}	
			
		}
		
	public void logout() {
		
		LibraryManagementSystem system = LibraryManagementSystem.getInstance();
		system.getLoggedInUsers().remove(this);
		
	}
	public void regsiter() {
		
	}
	public void searchBook() {
		
	}
	public void requestBook() {
		
	}

	public String getPsw() {
		return psw;
	}

	public void setPsw(String psw) {
		this.psw = psw;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPenalty() {
		return penalty;
	}

	public void setPenalty(int penalty) {
		this.penalty = penalty;
	}

	public Boolean getCanBorrow() {
		return canBorrow;
	}

	public void setCanBorrow(Boolean canBorrow) {
		this.canBorrow = canBorrow;
	}

	public ArrayList<Item> getBooks() {
		return books;
	}

	public String addBooks(Item book) throws Exception {
		if(this.payment.get(book) == true) {
			this.books.add(book);
			return "Your book has been added to your list";
		}
		else {
			throw new Exception("Failed: Book not added.");
		}
	}
	public Boolean getBookStatus(Item book) {
		return this.requestBook.get(book);
	}


	public Boolean getVerify() {
		return verify;
	}

	public void setVerify(Boolean verify) {
		this.verify = verify;
	}

	public String getRequestBookList() {
		
		HashMap<Item, Boolean> list = this.requestBook;
		String pointer = "";
		String result = "The list of requested Books for: "+this.getEmail();
		for(Map.Entry<Item, Boolean> entry : list.entrySet()) {
		    Item item = entry.getKey();
		    Boolean status = entry.getValue();
		    
		    if(status == true) {
		    	pointer = "Granted";
		    }
		    else{
		    	pointer = "Pending";
		    }
		    result += " Name: " + item.getName() + " Status: " + pointer + "\n";
		}
		return result;


	}
	public String getBookList() {
		
		return this.books.toString();


	}
	public String addRequestBook(Item item) {
	        this.requestBook.put(item, false);
	        this.payment.put(item, false);
	        this.discount.put(item, 5.0);
	        return "Your book has been requested";
	}


	public String itemPayment(Item item) throws Exception {
	
		if(this.getBookStatus(item) == true) {
			
			if(this.getVerify() && this.canBorrow) {
				this.payment.put(item, true);
				this.requestBook.put(item, true);
				this.addBooks(item);
				return "Your Payment has been successfull and the Item has been added "+this.getDiscount(item);
			}
			else {
				throw new Exception("Your have not been granted access to the book or not verified yet.");
			}
			
		}
		else {
			throw new Exception("Your Book's status is still pending");
		}
	}
	public void updateRequestBook(Item item) {
		this.requestBook.put(item,true);

	}
	public void applyDiscount(Item item, Double value) {
		this.discount.put(item, value);
	}
	public Double getDiscount(Item item) {
	
		System.out.println(this.discount.get(item));
		return this.discount.get(item);
	}
	
	
	public String requestNewBook(String bookName, String category) throws Exception {
		
		LibraryManagementSystem system = LibraryManagementSystem.getInstance();
		
		for (int i=0; i<system.getOnlineBooks().size(); i++) {
			
			
			if (system.getOnlineBooks().get(i).getName().equals(bookName)) {
				
				throw new Exception("Book already exists");
			}
			
		}
				
				ManagementTeam managementTeam = ManagementTeam.getInstance("email", "psw");
				
				managementTeam.addRequestedBook(bookName, category);
				
				for (int j=0; j<system.getCourse().size(); j++) {
					
					
					if (system.getCourse().get(j).getTextBook().equals(bookName)) {
						
						System.out.println("Priority for requested book is high");
						return "Priority for requested book is high";
						
					}
					
				}
				
				System.out.println("Priority for requested book is low");
				return "Priority for requested book is low";
				
			}
	
	public String returnBook(Item book) {
		
		    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	        LocalDate due = LocalDate.parse(book.getDueDates(), formatter);
	        LocalDate returned = LocalDate.now();

	        long overDue = ChronoUnit.DAYS.between(due, returned);
	        double penalty = 0;
	        
	        if (overDue > 0) {
	        
	        
	        if (this instanceof Student) {
	        	
	        	StudentPenaltyCalculationStrategy calculator = new StudentPenaltyCalculationStrategy();
	        	
	        	 penalty = calculator.calculatePenalty(overDue);
	        	
	        }
	        
	        else {
	        	
	        	PenaltyCalculationStrategy calculator = new PenaltyCalculationStrategy();
	        	
	        	 penalty = calculator.calculatePenalty(overDue);
	        	
	        }
	        
	        this.books.remove(book);
	        System.out.println(overDue);
	        System.out.println(penalty);
	        return "You have been charged a penalty of" + penalty;
	        
	        }

	        else {
	        	
	        	this.books.remove(book);
	        	return "your book has been returned";
	        	
	        }
		
		
	}
	
	public Item searchItem(String name) throws Exception{
		
		LibraryManagementSystem system = LibraryManagementSystem.getInstance();
		
		for (int i=0; i<system.getOnlineBooks().size(); i++) {
			
			if(system.getOnlineBooks().get(i).getName().equals(name)) {
				system.showRecommendations(system.getOnlineBooks().get(i));
				return system.getOnlineBooks().get(i);
			}
		}
		
		for (int j=0; j<system.getPhysicalItem().size(); j++) {
			
			if(system.getPhysicalItem().get(j).getName().equals(name)) {
				system.showRecommendations(system.getPhysicalItem().get(j));
				return system.getPhysicalItem().get(j);
			}
		}
		
		
		throw new Exception("Item not found");
		
	}
	
	public ArrayList<Item> getreccomendations(){
		
		LibraryManagementSystem system = LibraryManagementSystem.getInstance();
		 ArrayList<Item> recommendations = new ArrayList<>();
		
		for (int i = 0; i < this.books.size() && i < 2; i++) {
			
			recommendations.addAll(system.showRecommendations(this.books.get(i)));
		}
		return recommendations;
		
		
	}
		
	
}
