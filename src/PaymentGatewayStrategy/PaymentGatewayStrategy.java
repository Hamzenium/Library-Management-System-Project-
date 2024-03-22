package PaymentGatewayStrategy;

import Items.Item;
import Users.User;

public interface PaymentGatewayStrategy {
	
	void pay(User user, Item item, double amount);

}
