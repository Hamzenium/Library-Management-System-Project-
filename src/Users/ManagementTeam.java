package Users;

import Items.Item;

public class ManagementTeam extends User {

	public ManagementTeam(String psw, String email) {
		super(psw, email);
	}
	
	public void verifyClient(User user, Boolean verify) {
		user.setVerify(verify);
	}
	
	public void addItem(Item item, User user) {
		user.setBooks(item);
	}

	public void enableItem(User user, Boolean enableItem) {
		user.setVerify(enableItem);
	}
}
