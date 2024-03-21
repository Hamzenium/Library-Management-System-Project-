package Payment;

public interface PenaltyCalculatorStrategy {
	
	double calculatePenalty(long daysOverdue);

}
