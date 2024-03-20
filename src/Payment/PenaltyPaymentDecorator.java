package Payment;

import Items.Item;
import Users.User;

public class PenaltyPaymentDecorator extends PaymentDecorator {
	
	double penalty ;
    public PenaltyPaymentDecorator(Payable payment) {
        super(payment);
        this.penalty = 1.2;
    }

    @Override
    public void makePayment(User user, Item item) throws Exception {
        Double result = user.getDiscount(item) * 1.2; // Applying 20% penalty
        user.applyDiscount(item, result);
        user.itemPayment(item);
    }
}

