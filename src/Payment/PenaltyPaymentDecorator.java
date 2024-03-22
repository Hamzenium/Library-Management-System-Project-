package Payment;

import Items.Item;
import Users.User;

public class PenaltyPaymentDecorator extends PaymentDecorator {
	
	  public PenaltyPaymentDecorator(Payable payment) {
	    	super(payment);
	    }

		@Override
		public double cost() {
			// TODO Auto-generated method stub
			return this.payment.cost() * 1.2;
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
		
		public double calculatePenalty(long daysOverdue) {
			return daysOverdue *0.5; // $0.5 per day penalty for overdue items
		}


}