
public class User {

	private String psw;
	private String email;
	private int penalty;
	private booksRented[] books;
	private Boolean canBorrow;
	
	public User(String psw, String email,int penalty,booksRented books, Boolean canBorrow) {
		this.setBooks(new booksRented[50]);;
		this.setPsw(psw) ;
		this.setEmail(email);
		this.setPenalty(penalty);
		this.setCanBorrow(canBorrow);
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

	public booksRented[] getBooks() {
		return books;
	}

	public void setBooks(booksRented[] books) {
		this.books = books;
	}

}
