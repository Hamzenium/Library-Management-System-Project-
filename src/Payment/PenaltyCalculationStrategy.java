package Payment;

public class PenaltyCalculationStrategy implements PenaltyCalculatorStrategy{

	@Override
	public double calculatePenalty(long daysOverdue) {
		return daysOverdue *0.5; // $0.5 per day penalty for overdue items
	}

}
