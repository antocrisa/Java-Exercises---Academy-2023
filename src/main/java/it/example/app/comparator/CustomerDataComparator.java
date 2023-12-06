package it.example.app.comparator;

import java.util.Comparator;

import it.example.app.model.CustomerData;

public class CustomerDataComparator implements Comparator<CustomerData> {

	@Override
	public int compare(CustomerData o1, CustomerData o2) {
		if (o1.getTotalAmount() < o2.getTotalAmount())
			return -1;
		else if (o1.getTotalAmount() > o2.getTotalAmount())
			return 1;
		return 0;
	}
}
