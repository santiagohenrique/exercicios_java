package entities;

public class Individual extends TaxPayer{

	
	
	private double healthExpenditures;
	
	public Individual() {
		super();
	}
	
	public Individual(String name, Double anualIncome, double healthExpenditures) {
		super(name, anualIncome);
		this.healthExpenditures = healthExpenditures;
	}

	public double getHealthExpenditures() {
		return healthExpenditures;
	}

	public void setHealthExpenditures(double healthExpenditures) {
		this.healthExpenditures = healthExpenditures;
	}


	@Override
	public double tax() {

		double taxPaid = 0;
		
		if(super.getAnualIncome() < 20000.0) {
			taxPaid = super.getAnualIncome() * 0.15;
		}else {
			taxPaid = super.getAnualIncome() * 0.25;
		}
		
		taxPaid -= healthExpenditures * 0.5;
		
		return taxPaid;
	}
	

	
}
