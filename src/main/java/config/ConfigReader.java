package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ConfigReader {
	private Properties properties;
	public ConfigReader() throws IOException {
		properties = new Properties();
		FileInputStream fs = new FileInputStream("src\\test\\resources\\config.properties");
		properties.load(fs);
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
