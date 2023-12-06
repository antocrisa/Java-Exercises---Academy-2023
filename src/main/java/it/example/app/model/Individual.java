package it.example.app.model;

public class Individual extends Customer {

	public Individual(String code, String fiscalCode, String email, String phoneNumber, String firstname, String lastname) {
		super(code, fiscalCode);
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public Individual(String code, String fiscalCode) {
		super(code, fiscalCode);
	}
	
	
	
	@Override
	public void computeScore() {
		System.out.println("Computing Individual general part of the score for code: " + getId());
	}
	
	private String firstname;
	private String lastname;
	private int age;
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

		
}
