package it.example.app.model;

public class CustomerData {

	private String customerId;
	private Integer numOfTransaction;
	private Double averageAmount;
	private Double totalAmount;
	
	public CustomerData(String customerId, Integer numOfTransaction, Double averageAmount, Double totalAmount) {
		super();
		this.customerId = customerId;
		this.numOfTransaction = numOfTransaction;
		this.averageAmount = averageAmount;
		this.totalAmount = totalAmount;
	}

	
	
	@Override
	public String toString() {
		return "CustomerData [customerId=" + customerId + ", numOfTransaction=" + numOfTransaction + ", averageAmount="
				+ averageAmount + ", totalAmount=" + totalAmount + "]";
	}


	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public Integer getNumOfTransaction() {
		return numOfTransaction;
	}

	public void setNumOfTransaction(Integer numOfTransaction) {
		this.numOfTransaction = numOfTransaction;
	}

	public Double getAverageAmount() {
		return averageAmount;
	}

	public void setAverageAmount(Double averageAmount) {
		this.averageAmount = averageAmount;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	
}
