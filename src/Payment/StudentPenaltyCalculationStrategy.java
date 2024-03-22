package Payment;

public class StudentPenaltyCalculationStrategy implements PenaltyCalculatorStrategy {
	
	@Override
	public double calculatePenalty(long daysOverdue) {
		return daysOverdue *0.3; // $0.3 per day penalty for overdue items
	}

}
