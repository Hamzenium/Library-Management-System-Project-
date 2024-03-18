package Users;

import Items.Item;

public class ManagementTeam extends User {

	public ManagementTeam(String psw, String email) {
		super(psw, email);
	}
	
	public void verifyClient(User user, Boolean verify) {
		user.setVerify(verify);
	}
	
	public void addItem(Item item, User user) throws Exception{
		Item book = user.getRequestBook();
		if(user.getVerify() && user.getCanBorrow()) {
			user.setBooks(book);
			user.setRequestBook(null);
		}
		else {
			throw new Exception("User is still not verified and not cannot borrow book");
		}

	}

	public void enableItem(User user, Boolean enableItem) {
		user.setVerify(enableItem);
	}
}
