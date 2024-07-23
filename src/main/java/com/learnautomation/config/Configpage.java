package com.learnautomation.config;

import java.io.File;
import java.util.Properties;

import org.testng.Reporter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Configpage {
	
	public static String getproperty(String key) {
	
	Properties properties = new Properties();
	try {
		properties.load(new FileInputStream(new File("./Config/Config.properties")));
		} catch (IOException e) {
		// TODO Auto-generated catch block
		Reporter.log(e.getMessage());
	}
	
	String value = properties.getProperty(key);
	
	return value;

}
}
