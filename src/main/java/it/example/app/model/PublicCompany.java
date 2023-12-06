package it.example.app.model;

public class PublicCompany extends Company {

	public PublicCompany(String code, String fiscalCode) {
		super(code, fiscalCode);
	}

	@Override
	public void computeScore() {
		super.computeScore();
		System.out.println("Computing Public Company specific part of the score for code: " + getId());
	}
}
