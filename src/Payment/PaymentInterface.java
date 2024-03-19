package Payment;
import Items.Item;
import Users.User;

public interface PaymentInterface {
	
	void makePayment(User user, Item item) throws Exception;
}
