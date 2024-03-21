package Payment;

import Items.Item;
import Users.User;

public abstract class PaymentDecorator extends Payable {
    protected Payable payment;

    public PaymentDecorator(Payable payment) {
    	
    	this.payment =  payment;
    }
    

}