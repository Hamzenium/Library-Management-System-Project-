package Payment;

import PaymentGatewayStrategy.*;;

public class DebitCardDecorator extends PaymentDecorator{

	public DebitCardDecorator(Payable payment) {
		super(payment, new DebitCardStrategy());
	}

	@Override
	public double cost() {
		return 0;
	}

}
