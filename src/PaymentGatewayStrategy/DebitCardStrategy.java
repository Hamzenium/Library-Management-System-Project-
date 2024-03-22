package PaymentGatewayStrategy;

import Items.Item;
import Users.User;

public class DebitCardStrategy implements PaymentGatewayStrategy{
	
	@Override
    public void pay(User user, Item item, double amount) {
        System.out.println("Paid $" + amount + " via debit card.");
        try {
			user.itemPayment(item);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

}
