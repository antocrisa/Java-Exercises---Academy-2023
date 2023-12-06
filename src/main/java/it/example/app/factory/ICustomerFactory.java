package it.example.app.factory;

import it.example.app.model.Customer;

public interface ICustomerFactory {
	
	Customer getCustomer(String type, String code, String fiscalCode);
	
}
