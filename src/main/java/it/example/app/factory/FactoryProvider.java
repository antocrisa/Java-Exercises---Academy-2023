package it.example.app.factory;

public abstract class FactoryProvider {

	public static ICustomerFactory getFactory(String type) {
		ICustomerFactory cf = null;
		
		switch (type) {
		case "COMPANY":
				cf = new CompanyFactory();
			break;
		case "INDIVIDUAL":
			cf = new IndividualFactory();
		default:
			break;
		}
		
		return cf;
	}
}
