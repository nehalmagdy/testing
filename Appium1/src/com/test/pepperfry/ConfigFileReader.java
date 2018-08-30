package com.test.pepperfry;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	
	private Properties properties;
	private final String propertyFilePath= "configs//AndroidConfiguration.properties";

	
	public ConfigFileReader(){
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}		
	}
	
	public String getudid(){
		String udid = properties.getProperty("udid");
		if(udid!= null) return udid;
		else throw new RuntimeException("udid not specified in the Configuration.properties file.");		
	}
	
	public String getPlatformName(){
		String platformName = properties.getProperty("platformName");
		if(platformName!= null) return platformName;
		else throw new RuntimeException("platformName not specified in the Configuration.properties file.");		
	}
	
	public String getAppActivity(){
		String appActivity = properties.getProperty("appActivity");
		if(appActivity!= null) return appActivity;
		else throw new RuntimeException("appActivity not specified in the Configuration.properties file.");		
	}
	
	public String getAppPackage(){
		String appPackage = properties.getProperty("appPackage");
		if(appPackage!= null) return appPackage;
		else throw new RuntimeException("appPackage not specified in the Configuration.properties file.");		
	}
	
	public String getApplicationUrl() {
		String url = properties.getProperty("URL");
		if(url != null) return url;
		else throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

}