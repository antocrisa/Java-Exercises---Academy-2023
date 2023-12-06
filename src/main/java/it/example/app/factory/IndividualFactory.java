package it.example.app.factory;

import it.example.app.model.Customer;
import it.example.app.model.Employee;
import it.example.app.model.Freelance;

public class IndividualFactory implements ICustomerFactory {

	public Customer getCustomer(String type, String code, String fiscalCode) {
		
		switch(type) {
			case "EMPLOYEE" : 
				return new Employee(code, fiscalCode);
			case "FREELANCE": 
				return new Freelance(code, fiscalCode);
			case "XXX" :
				return null;
			default : return null;
		}
	}
}
