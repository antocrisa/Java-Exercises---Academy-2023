package it.example.app.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import it.example.app.model.enums.CustomerErrors;
import it.example.app.model.enums.CustomerType;
import it.example.app.comparator.CustomerDataComparator;
import it.example.app.exception.CustomerInvalidException;
import it.example.app.model.Company;
import it.example.app.model.Customer;
import it.example.app.model.CustomerData;
import it.example.app.model.Individual;
import it.example.app.model.Transaction;
import it.example.app.model.enums.TransactionType;

public abstract class AcademyUtils {

	public static final String SPLIT_CHAR = ";";

	public static Map<String, List<Transaction>> importTransactions(String filepath) {
		Map<String, List<Transaction>> result = new HashMap<>();
        List<String> lines;
		try {
			lines = readFile(filepath);
		} catch (IOException e) {
			System.out.println("Errore lettura file delle transazioni!");
			return result;
		}
		for (String s : lines) {
			String[] tokens = s.split(SPLIT_CHAR, -1);	
			Transaction t = new Transaction(tokens[1], Double.parseDouble(tokens[2]), TransactionType.valueOf(tokens[3]));
			if (result.get(tokens[0]) != null)
				result.get(tokens[0]).add(t);
			else {
				List<Transaction> newList = new ArrayList<>();
				newList.add(t);
				result.put(tokens[0], newList);
			}
		}
        return result;
	}

	private static List<String> readFile(String filepath) throws IOException {
		return readFile(new File(filepath));
	}
	
	private static List<String> readFile(File f) throws IOException {
		return Files.readAllLines(f.toPath());
	}
	
	public static List<Customer> importCustomers(String filepath) throws IOException {
		List<Customer> custList = new ArrayList<>();
		List<String> lines = readFile(filepath);
		Integer count = 0;
		for (String s : lines) {
//			Optional<Customer> c = createCustomerFromLine(s);
//			if (c.isPresent())
//				custList.add(c.get());
//			else
//				count++;
			try {
				Customer c = createCustomerFromLineWithException(s);
				custList.add(c);
			} catch (Exception e) {
				System.out.println("Riga non importata, Customer id o fiscalCode non presente!"); 
				count++;
			}
		}
		System.out.println("Scartati " + count + " record dal file dei customer.");
		return custList;
	}

	private static Customer createCustomerFromLineWithException(String s) throws CustomerInvalidException {
		Customer c = null;
		String[] tokens = s.split(SPLIT_CHAR, -1);

		if (isRecordInvalid(tokens)) 
			throw new CustomerInvalidException(CustomerErrors.FISCAL_CODE_MISSING);
		else {
			switch (CustomerType.valueOf(tokens[0])) {
			case IND:
				c = new Individual(tokens[1], tokens[2], tokens[3], tokens[4], tokens[5], tokens[6]);
				break;
			case COM:
				Integer i = !tokens[7].isEmpty() ? Integer.parseInt(tokens[7]) : null;
				c = new Company(tokens[1], tokens[2], tokens[3], tokens[4], tokens[5], tokens[6], i);
				break;
			default:
				break;
			}
		}
		return c;
	}
	
	private static Optional<Customer> createCustomerFromLine(String s) {
		Customer c = null;
		String[] tokens = s.split(SPLIT_CHAR, -1);

		if (isRecordInvalid(tokens))
			System.out.println("Riga non importata, Customer id o fiscalCode non presente!");
		else {
			switch (CustomerType.valueOf(tokens[0])) {
			case IND:
				c = new Individual(tokens[1], tokens[2], tokens[3], tokens[4], tokens[5], tokens[6]);
				break;
			case COM:
				Integer i = !tokens[7].isEmpty() ? Integer.parseInt(tokens[7]) : null;
				c = new Company(tokens[1], tokens[2], tokens[3], tokens[4], tokens[5], tokens[6], i);
				break;
			default:
				break;
			}
		}
		
		return Optional.ofNullable(c);
	}

	private static boolean isRecordInvalid(String[] tokens) {
		return tokens[1].isEmpty() || tokens[2].isEmpty();
	}
		
	public static void insertCustomerTransaction(List<Customer> cust, Map<String, List<Transaction>> mapTrans) {
		
		for (Customer c: cust)
			c.setTransactions(mapTrans.get(c.getId()) != null ? mapTrans.get(c.getId()) : new ArrayList<>());
	}	
	
	public static List<CustomerData> getCustomerData(List<Customer> cust) {
		List<CustomerData> data = new ArrayList<>();
		for (Customer c: cust)
			data.add(new CustomerData(c.getId(), c.getTransactionNumber(), c.getAverageTransactionAmount(), c.getTotaleTransactionAmount()));
		return data;
	}
	
	public static CustomerData getMaxAmountCustomer(List<CustomerData> cust) {
		if (!cust.isEmpty())
			return Collections.max(cust, new CustomerDataComparator());
		else
			return null;
	}
	
	public static CustomerData getMaxAmountCustomerSenzaMax(List<CustomerData> cust) {
		CustomerData tmp = cust != null && !cust.isEmpty() ? cust.get(0) : null;
		for (CustomerData c : cust)
			if (c.getTotalAmount() > tmp.getTotalAmount())
				tmp = c;
		return tmp;
	}
	
	public static void printGenericList(List<?> cust) {
		cust.forEach(x -> System.out.println(x));
	}
	
	public static List<Integer> countInteger (List<Integer> input) {
		List<Integer> result = new ArrayList<>();
		Integer sum = 0;
		for (Integer n : input)
			sum += n;
		for (Integer n : input)
			result.add(sum - n);
		printGenericList(result);
		return result;
	}
}