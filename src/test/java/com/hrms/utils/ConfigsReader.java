package com.hrms.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigsReader {
	
	public static Properties prop;
	
	/**
	 * This method read properties file
	 * @param filePath
	 */
	public static void readProperties(String filePath) {
		try {
			FileInputStream fis = new FileInputStream(filePath);
			prop=new Properties();
			prop.load(fis);
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * This method will return value of specified 
	 * @param String key
	 * @return String value
	 */
	// create a method to return value of specified key
	public static String getProperty(String key) {
		
	return prop.getProperty(key);
	}
	
	
}
