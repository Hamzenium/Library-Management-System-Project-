package Payment;

import PaymentGatewayStrategy.CreditCardStrategy;

public class CreditCardDecorator extends PaymentDecorator {

	public CreditCardDecorator(Payable payment) {
		 super(payment, new CreditCardStrategy());
	}

	@Override
	public double cost() {
		return 0;
	}
	
}
