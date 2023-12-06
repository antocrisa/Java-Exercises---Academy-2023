package it.example.app.model;

import java.time.LocalDateTime;

import it.example.app.model.enums.TransactionType;

public class Transaction {

	private String code;
	private LocalDateTime transactionDate;
	private double amount;
	private TransactionType type;
	
	
	public Transaction(String code, double amount, TransactionType type) {
		super();
		this.code = code;
		this.amount = amount;
		this.type = type;
	}

	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public LocalDateTime getTransactionDate() {
		return transactionDate;
	}
	
	public void setTransactionDate(LocalDateTime transactionDate) {
		this.transactionDate = transactionDate;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public TransactionType getType() {
		return type;
	}
	
	public void setType(TransactionType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Transazione [code=");
		builder.append(code);
		builder.append(", transactionDate=");
		builder.append(transactionDate);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", type=");
		builder.append(type);
		builder.append("]");
		return builder.toString();
	}
	
	
}
