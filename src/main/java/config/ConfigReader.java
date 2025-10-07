package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ConfigReader {
	private Properties properties;

	/*
	public ConfigReader() throws IOException {
		properties = new Properties();
		FileInputStream fs = new FileInputStream("src\\test\\resources\\config.properties");
		properties.load(fs);
	}
	*/

	//Generic way to load properties file from resources folder
	//This way it will work in any system without changing the path
	public ConfigReader() throws IOException {
        properties = new Properties();

        // Use ClassLoader to load config.properties from resources folder
        InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties");
        if (input == null) {
            throw new IOException("Unable to find config.properties in resources folder");
        }
        properties.load(input);
    }
	
	public String getBrowser() {
		return properties.getProperty("browser");
	}
	
	public String getBaseUrl() {
		return properties.getProperty("baseUrl");
	}

	public String getSearchtext() {
		// TODO Auto-generated method stub
		return properties.getProperty("searchText");
	}

	public Map<String,ArrayList<String>> getFiltersrequirements() {
		String data= properties.getProperty("filterRequirements");
		Map<String,ArrayList<String>>mp=new HashMap<>();
		String[] keyValues= data.split(";");//[0]=[Subject:Computer Science,Business,Information Technology,Data Science;]
		for(String keyValue:keyValues) {
			String key=keyValue.split(":")[0];
			String[] values=(keyValue.split(":")[1]).split(",");
			mp.put(key, new ArrayList<String>());
			for(String value:values) {
				mp.get(key).add(value);
			}
		}
		return mp;
	}

	public int getNumberOfRequireCards() {
		// TODO Auto-generated method stub
		return Integer.parseInt(properties.getProperty("NumberOfRequireCards"));
	}

	public List<String> getQueryListForDetails() {
		// TODO Auto-generated method stub
		ArrayList<String>queryListForDetails= new ArrayList<>();
		String[] temp= properties.getProperty("QueryListForDetails").split(",");
		for(String values: temp) {
			queryListForDetails.add(values);
		}
		return queryListForDetails;
	}

	public String getQueryAttributeName() {
		return properties.getProperty("QueryAttributeName");
	}

	public String[] getFormData() {
		return (properties.getProperty("FormData")).split(":");
	}

}
