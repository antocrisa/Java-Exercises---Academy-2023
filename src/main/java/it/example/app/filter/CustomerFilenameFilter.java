package it.example.app.filter;

import java.io.File;
import java.io.FilenameFilter;

public class CustomerFilenameFilter implements FilenameFilter {

	@Override
	public boolean accept(File dir, String name) {
		return name.startsWith("Customer");
	}

}
