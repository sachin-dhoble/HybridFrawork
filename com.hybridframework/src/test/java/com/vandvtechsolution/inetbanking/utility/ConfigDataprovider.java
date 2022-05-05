package com.vandvtechsolution.inetbanking.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigDataprovider {

	public Properties prop;

	public ConfigDataprovider(String configdatapath) {
		try {
			File fs = new File(configdatapath);
			FileInputStream fins = new FileInputStream(fs);
			prop = new Properties();
			prop.load(fins);
		} catch (Exception e) {
			System.out.println("File not found:" + e);

		}

	}

	public String sreachKey(String key) {
		return prop.getProperty(key);
	}

	public String getUserName() {
		return prop.getProperty("username");
	}

	public String getPwrd() {
		return prop.getProperty("passward");
	}

	public String getURL() {
		return prop.getProperty("url");
	}
}
