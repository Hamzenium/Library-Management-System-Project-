package Users;

import java.util.ArrayList;

import Items.Item;

public class User {

	private String psw;
	private String email;
	private int penalty;
	private ArrayList<Item> books;
	private Boolean canBorrow;
	private Boolean verify;
	private Item requestBook;
	
	public User(String psw, String email) {
		this.books = new ArrayList<Item>();
		this.psw = psw ;
		this.email = email;
		this.penalty = 0;
		this.canBorrow = true;
		this.verify = false;
		this.requestBook = null;
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

	public void setBooks(Item book) {
		this.books.add(book);
	}

	public Boolean getVerify() {
		return verify;
	}

	public void setVerify(Boolean verify) {
		this.verify = verify;
	}

	public Item getRequestBook() {
		return requestBook;
	}

	public void setRequestBook(Item requestBook) {
		this.requestBook = requestBook;
	}

}
