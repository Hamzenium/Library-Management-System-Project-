package Payment;

import Items.Item;
import Users.User;

public class DiscountedPaymentDecorator extends PaymentDecorator {

    public DiscountedPaymentDecorator(Payable payment) {
        
    	super(payment);
    }

	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return this.payment.cost() * 0.8;
	}
	
	@Override
	public void makePayment(User user, Item item) {
		try {
		Double result = user.getDiscount(item) * this.cost();
		user.applyDiscount(item, result);
        user.itemPayment(item);
        } catch (Exception e) {
        e.printStackTrace();
    }
		
	}

}