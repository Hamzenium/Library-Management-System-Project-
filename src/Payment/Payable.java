package Payment;
import Items.Item;
import Users.User;

public interface Payable {
	
	void makePayment(User user, Item item) throws Exception;

}
