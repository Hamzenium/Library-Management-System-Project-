package Payment;


import PaymentGatewayStrategy.*;;
public class MobilePaymentDecorator extends PaymentDecorator {



	public MobilePaymentDecorator(Payable payment) {
		
		super(payment, new MobilePaymentStrategy());
	
	}

	@Override
	public double cost() {
		return 0;
	}

}
