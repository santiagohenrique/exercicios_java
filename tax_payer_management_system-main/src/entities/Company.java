package entities;

public class Company extends TaxPayer{

	
	
	private int numberOfEmployees;
	
	public Company() {
		super();
	}
	
	
	public Company(String name, Double anualIncome, int numberOfEmployees) {
		super(name, anualIncome);
		this.numberOfEmployees = numberOfEmployees;
	}


	public int getNumberOfEmployees() {
		return numberOfEmployees;
	}

	public void setNumberOfEmployees(int numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}


	@Override
	public double tax() {

		double taxPaid = 0;
		
		if(numberOfEmployees <= 10) {
			taxPaid = super.getAnualIncome() * 0.16;
		}else {
			taxPaid = super.getAnualIncome() * 0.14;
		}
		
		return taxPaid;
	}
	
	
	
}
