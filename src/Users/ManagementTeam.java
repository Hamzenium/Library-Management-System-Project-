package Users;

import Items.Item;

public class ManagementTeam extends User {

	public ManagementTeam(String email, String psw) {
		super(email, psw);
	}
	
	public void verifyClient(User user, Boolean verify) {
		user.setVerify(verify);
	}
	
	public void enableItem(User user, Item item) {
			user.requestBook.put(item, true);

	}

	
}
