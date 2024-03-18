package Users;

import Items.Item;

public class User {

	private String psw;
	private String email;
	private int penalty;
	private Item[] books;
	private Boolean canBorrow;
	
	public User(String psw, String email) {
		this.books = new Item[50];
		this.psw = psw ;
		this.email = email;
		this.penalty = 0;
		this.canBorrow = true;
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

	public Item[] getBooks() {
		return books;
	}

	public void setBooks(Item[] books) {
		this.books = books;
	}

}
