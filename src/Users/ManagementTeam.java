package Users;

import java.util.HashMap;

import Items.Item;

public class ManagementTeam extends User {

	public ManagementTeam(String psw, String email) {
		super(psw, email);
	}
	
	public void verifyClient(User user, Boolean verify) {
		user.setVerify(verify);
	}
	
	public void enableItem(User user, Item item) {
			user.requestBook.put(item, true);

	}
	
//	public void addItem(User user, Item book) throws Exception{
//		if(user.getVerify() && user.getCanBorrow() && ) {
//			user.updateRequestBook(book);
//			user.addBooks(book);
//		}
//		else {
//			throw new Exception("User is still not verified and not cannot borrow book");
//		}

	
}
