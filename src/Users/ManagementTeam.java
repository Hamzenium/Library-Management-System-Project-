
package Users;

import Items.Item;
import LibraryManagementSystem.LibraryManagementSystem;

import java.util.Random;

import Items .*;

public class ManagementTeam extends User {
	
	private static ManagementTeam instance;

	private ManagementTeam(String email, String psw) {
		super(email, psw);
	}
	
	public void verifyClient(User user, Boolean verify) {
		user.setVerify(verify);
	}
	
	public void enableItem(User user, Item item) {
			user.requestBook.put(item, true);
			user.setNotifications(item);

	}
	
	public static ManagementTeam getInstance(String email, String psw) {
		if (instance == null) {
			instance = new ManagementTeam(email, psw);
		}
		return instance;
	}
	
	public void addRequestedBook(String bookName) {
		
		Random random = new Random();
		
		int randomNumber = random.nextInt(101);
		
		OnlineBook book = new OnlineBook(randomNumber, bookName);
		
	}

	
}
