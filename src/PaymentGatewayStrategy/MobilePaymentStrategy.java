package PaymentGatewayStrategy;

import Items.Item;
import Users.User;

public class MobilePaymentStrategy implements PaymentGatewayStrategy {
	
	public void pay(User user, Item item, double amount) {
        try {
			user.itemPayment(item);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

}
