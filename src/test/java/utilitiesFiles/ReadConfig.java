package utilitiesFiles;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	
	public ReadConfig() {
		File file = new File("./Configuration/config.properties");
		
		try {
			FileInputStream fs = new FileInputStream(file);
			pro = new Properties();
			pro.load(fs);
		}
		catch(Exception e) {
			System.out.println("exception is " + e.getMessage());
		}
	}
	
	public String getAmazonUrl() {
		String amazonUrl = pro.getProperty("urlAmazon");
		return amazonUrl;
	}
	
	public String getFlipkartUrl() {
		String flipkartUrl = pro.getProperty("urlFlipkart");
		return flipkartUrl;
	}
	
}
