package it.example.app;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import it.example.app.filter.CustomerFilenameFilter;
import it.example.app.model.Customer;
import it.example.app.model.CustomerData;
import it.example.app.model.Transaction;
import it.example.app.utils.AcademyUtils;

public class App 
{
    public static void main(String[] args)
    {
    	List<Customer> custList = new ArrayList<>();
		File folder = new File(args[0]);
		File outputDir = new File(args[1]);
		File[] files = folder.listFiles(new CustomerFilenameFilter());
		
		for (File f : files)
			elaborateSingleCustomerFile(custList, outputDir, f);

    	Map<String, List<Transaction>> transactionMap = AcademyUtils.importTransactions("/Transactions.txt");
    	AcademyUtils.insertCustomerTransaction(custList, transactionMap);
    	List<CustomerData> custData = AcademyUtils.getCustomerData(custList);
    	CustomerData maxCustomer = AcademyUtils.getMaxAmountCustomer(custData);
    	CustomerData maxCustomer2 = AcademyUtils.getMaxAmountCustomerSenzaMax(custData);
    	AcademyUtils.printGenericList(custList);
    	AcademyUtils.printGenericList(custData);
    	System.out.println("Customer Max Transaction Amount" + maxCustomer2);
    	
    	AcademyUtils.countInteger(Arrays.asList(new Integer[] {2,8,3,4,5,10}));
    }

	private static void elaborateSingleCustomerFile(List<Customer> custList, File outputDir, File f) {
		if (!f.exists() || f.isDirectory()) {
			System.out.println("ERRORE FILE NOT EXISTS!");
			return;
		}
		
		try {
			custList.addAll(AcademyUtils.importCustomers(f.toString()));
			if (!outputDir.exists())
				Files.createDirectories(Paths.get(outputDir.getPath()));
			Files.move(f.toPath(), Paths.get(outputDir.getAbsolutePath(), f.getName()), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			System.out.println("ERRORE nella lettura del file dei Customer");
		}
	}
}
