package baseFile;

import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilitiesFiles.ReadConfig;

public class Base {
	public static WebDriver driver;
	
	ReadConfig rc = new ReadConfig();
	public String amazonUrl = rc.getAmazonUrl();
	public String flipkartUrl = rc.getFlipkartUrl();
	
	public static Logger logger = Logger.getLogger(Base.class);
	
	
	@BeforeSuite
	public void setup() {
		PropertyConfigurator.configure("Log4j.properties");
		
		ChromeOptions chromeOpt = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(chromeOpt);
		
		driver.get(amazonUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		
			
		
	}
	
	
	
	@AfterSuite
	public void tearDown() {
		driver.quit(); 
	}
	
	
}
