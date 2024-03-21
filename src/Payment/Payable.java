package Payment;
import Items.Item;
import Users.User;

abstract class Payable {
	
	public abstract double cost();
	public void makePayment(User user, Item item) {
		
	}

}

