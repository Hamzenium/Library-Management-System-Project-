package Payment;

import Items.Item;
import Users.User;

public class Payment implements Payable{
	

    @Override
    public void makePayment(User user, Item item) {
        try {
            user.itemPayment(item);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}