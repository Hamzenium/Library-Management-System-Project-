package Payment;

import Items.Item;
import PaymentGatewayStrategy.CreditCardStrategy;
import PaymentGatewayStrategy.PaymentGatewayStrategy;
import Users.User;

public abstract class PaymentDecorator extends Payable {
    protected Payable payment;

    public PaymentDecorator(Payable payment) {
    	
    	this.payment =  payment;
    }
    
    public PaymentDecorator(Payable payment,  PaymentGatewayStrategy strategy) {
    	
    	this.payment =  payment;
    
    }

}