package it.example.app.model;

public class Employee extends Individual {

	public Employee(String code, String fiscalCode) {
		super(code, fiscalCode);
	}

	@Override
	public void computeScore() {
		super.computeScore();
		System.out.println("Computing Employee specific part of the score for code: " + getId());
	}
}
