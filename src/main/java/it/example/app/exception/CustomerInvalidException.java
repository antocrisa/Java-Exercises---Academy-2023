package it.example.app.exception;

import it.example.app.model.enums.CustomerErrors;

public class CustomerInvalidException extends Exception {

	private CustomerErrors code;

	public CustomerInvalidException(CustomerErrors code) {
		super();
		this.code = code;
	}
}
