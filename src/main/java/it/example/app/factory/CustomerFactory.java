package it.example.app.factory;

import it.example.app.model.Company;
import it.example.app.model.Customer;
import it.example.app.model.Individual;

public class CustomerFactory {

	public static Customer getCustomer(String type, String code, String fiscalCode) {
		
		switch(type) {
			case "INDIVIDUAL" : 
				return new Individual(code, fiscalCode);
			case "COMPANY": 
				return Company.CompanyBuilder.getBuilder(code, fiscalCode).build();
			default : return null;
		}
	}
}
