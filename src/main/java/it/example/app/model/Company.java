package it.example.app.model;

public class Company extends Customer {

	private String name;
	private String businessType;
	private Integer numOfEmployee;
	
	public Company(String code, String fiscalCode, String email, String phoneNumber, String name, String businessType, Integer numOfEmployee) {
		super(code, fiscalCode);
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.name = name;
		this.businessType = businessType;
		this.numOfEmployee = numOfEmployee;
	}
	
	private Company(String code, String fiscalCode, String email, String phoneNumber) {
		this(code, fiscalCode, email, phoneNumber, null, null, null);
	}

	protected Company(String code, String fiscalCode) {
		super(code, fiscalCode);
	}

//
//	public void computeScore() {
//		System.out.println("Computing Company general part of the score for code: " + getCode());
//	}
//	
//	public void computeScore(int maxValue) {
//		System.out.println("Computing Company general part of the score for code: " + getCode());
//	}
//	
//	public int computeScore(int maxValue, int minvalue) {
//		System.out.println("Computing Company general part of the score for code: " + getCode());
//		return 0;
//	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBusinessType() {
		return businessType;
	}
	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}
	public Integer getNumOfEmployee() {
		return numOfEmployee;
	}
	public void setNumOfEmployee(Integer numOfEmployee) {
		this.numOfEmployee = numOfEmployee;
	}

	
	@Override
	public String toString() {
		return super.toString() +  "Company [name=" + name + ", businessType=" + businessType + ", numOfEmployee=" + numOfEmployee + "]";
	}

	public void computeScore() {
		System.out.println("Computing Customer score");
	}
	
	public static final class CompanyBuilder {
		
		private String code;
		private String fiscalCode;
		private String email;
		private String phoneNumber;
		private String name;
		private String businessType;
		private Integer numOfEmployee;
		
		private CompanyBuilder(String code, String fiscalCode) {
			this.code = code;
			this.fiscalCode= fiscalCode;
		}
		
	    public static CompanyBuilder getBuilder(String code, String fiscalCode) {
			 return new CompanyBuilder(code, fiscalCode);
		}
	    
	    public CompanyBuilder email(String email) {
	    	this.email = email;
	    	return this;
	    }
	    
	    public CompanyBuilder name(String name) {
	    	this.name = name;
	    	return this;
	    }
	    
	    public CompanyBuilder phoneNumber(String phoneNumber) {
	    	this.phoneNumber = phoneNumber;
	    	return this;
	    }
	    
	    // Methods for all other instance variables
	    
	    public Company build() {
	    	return new Company(code, fiscalCode, email, phoneNumber, name, businessType, numOfEmployee);
	    }
	}
	
	
}
