package Users;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Items.Item;

public class User {

	private String psw;
	private String email;
	private int penalty;
	private ArrayList<Item> books;
	private Boolean canBorrow;
	private Boolean verify;
	private HashMap<Item,Boolean> requestBook;
	
	public User(String psw, String email) {
		this.books = new ArrayList<Item>();
		this.psw = psw ;
		this.email = email;
		this.penalty = 0;
		this.canBorrow = true;
		this.verify = false;
		this.requestBook = new HashMap<Item,Boolean>();
	}
	
	public void subscribe() {
		
	}
	
	public void cancel() {
		
	}

	public void verify() {
		
	}
	public void login() {
		
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

	public void addBooks(Item book) {
		this.books.add(book);
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
	public void addRequestBook(Item item) {
		this.requestBook.put(item, false);

	}
	public void updateRequestBook(Item item) {
		this.requestBook.put(item,true);

	}


}
