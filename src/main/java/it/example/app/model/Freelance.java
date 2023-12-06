package it.example.app.model;

public class Freelance extends Individual {

	public Freelance(String code, String fiscalCode) {
		super(code, fiscalCode);
	}

	@Override
	public void computeScore() {
		super.computeScore();
		System.out.println("Computing Freelance specific part of the score for code: " + getId());
	}
}
