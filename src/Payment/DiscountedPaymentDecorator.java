package Payment;

import Items.Item;
import Users.User;

public class DiscountedPaymentDecorator extends PaymentDecorator {

    public DiscountedPaymentDecorator(PaymentInterface payment) {
        super(payment);
    }

    @Override
    public void makePayment(User user, Item item) throws Exception {
        Double result = user.getDiscount(item) * 0.8; // Applying 20% discount
        user.applyDiscount(item, result);
        user.itemPayment(item);
    }
}