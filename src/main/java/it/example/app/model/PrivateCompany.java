package it.example.app.model;

public class PrivateCompany extends Company {

	public PrivateCompany(String code, String fiscalCode) {
		super(code, fiscalCode);
	}

	@Override
	public void computeScore() {
		super.computeScore();
		System.out.println("Computing PrivateCompany specific part of the score for code: " + getId());
	}
}
