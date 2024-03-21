package Payment;

import Items.Item;
import Users.User;

public class Payment extends Payable{

	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return 1;
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



//
////@Override
////public void makePayment(User user, Item item) {
////    try {
////        user.itemPayment(item);
////    } catch (Exception e) {
////        e.printStackTrace();
////    }
////}