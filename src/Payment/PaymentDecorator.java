package Payment;

import Items.Item;
import Users.User;

public abstract class PaymentDecorator implements Payable {
    protected Payable payment;

    public PaymentDecorator(Payable payment) {
    }

    @Override
    public void makePayment(User user, Item item) throws Exception {
        try {
            payment.makePayment(user, item);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}