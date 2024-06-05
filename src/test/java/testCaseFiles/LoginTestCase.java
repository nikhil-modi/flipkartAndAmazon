package testCaseFiles;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import baseFile.Base;
import pageFiles.LoginPage;
import utilitiesFiles.ExcelUtils;

public class LoginTestCase {
	
	
	@Test(dataProvider = "LoginData")
	public void login(String phoneNo, String password) throws InterruptedException {
		Base base = new Base();
		base.setup();
		
		LoginPage lp = new LoginPage(Base.driver);
		Base.logger.info("opening the browser");
		
		
		lp.clickSignInBtnOnHomePage();
		Base.logger.info("clicked on the signIn btn on the home page");
		
		lp.enterPhoneEmail(phoneNo);
		Base.logger.info("entered the phone number on the first page of home screen");
		
		lp.clickContinueBtn();
		Base.logger.info("clicked on the continue button after entering the phone number");
		
		lp.enterPassword(password);
		Base.logger.info("entered the password for the further process");
		
		lp.clickSignBtn();
		Base.logger.info("clicked on the signIn button for entering the amazon home page");
		
		base.tearDown();
		
	}
	
	@DataProvider(name = "LoginData")
	String [][] getData() throws IOException{
		String path = System.getProperty("user.dir")+"/src/test/java/testDataFiles/amazonData.xlsx";
		
		int rowNum = ExcelUtils.getRowCount(path, "Sheet1");
		int colNum = ExcelUtils.getCellCount(path, "Sheet1", 0);
		
		System.out.println(rowNum);
		System.out.println(colNum);
		
		String [][] loginData = new String[rowNum][colNum];
		
		for(int i=0; i<rowNum; i++) {
			for(int j=0; j<colNum; j++) {
				loginData[i][j] = ExcelUtils.getCellData(path, "Sheet1", i+1, j);
			}
		}
		
		return loginData;
	}
	
	

}
