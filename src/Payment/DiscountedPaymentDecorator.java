package Payment;

import Items.Item;
import Users.User;

public class DiscountedPaymentDecorator extends PaymentDecorator {

	double discount;
    public DiscountedPaymentDecorator(Payable payment) {
        
    	super(payment);
    	this.discount = 0.8;
    }

    @Override
    public void makePayment(User user, Item item) throws Exception {
        Double result = user.getDiscount(item) * 0.8; // Applying 20% discount
        user.applyDiscount(item, result);
        user.itemPayment(item);
    }


}