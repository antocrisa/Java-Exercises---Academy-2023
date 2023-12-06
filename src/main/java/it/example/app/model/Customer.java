package it.example.app.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Customer {

	protected String id;
	protected String fiscalCode;
	protected String email;
	protected String phoneNumber;
	protected List<Transaction> transactions = new ArrayList<>();
	
	public Customer(String id, String fiscalCode) {
		super();
		this.id = id;
		this.fiscalCode = fiscalCode;
	}
	
	public Integer getTransactionNumber() {
		return transactions.size();
	}
	
	public Double getAverageTransactionAmount() {
		return getTotaleTransactionAmount() / getTransactionNumber();
	}
	
	public Double getTotaleTransactionAmount() {
		Double tot = 0.0;
		for (Transaction t: transactions)
			tot += t.getAmount();
		return tot;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFiscalCode() {
		return fiscalCode;
	}
	public void setFiscalCode(String fiscalCode) {
		this.fiscalCode = fiscalCode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", fiscalCode=" + fiscalCode + ", email=" + email + ", phoneNumber=" + phoneNumber
				+ ", transactions=" + transactions + "]";
	}

	public abstract void computeScore();
}