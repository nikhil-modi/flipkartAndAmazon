package pageFiles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@id='nav-link-accountList']//div/span[@id='nav-link-accountList-nav-line-1']")
	WebElement signInBtnHomePage;
	
	@FindBy(xpath = "//input[@id='ap_email']")
	WebElement emailPhoneTextField;
	
	@FindBy(xpath = "//input[@id='continue']")
	WebElement continueBtn;
	
	@FindBy(xpath = "//input[@id='ap_password']")
	WebElement passwordField;
	
	@FindBy(xpath = "//input[@id='signInSubmit']")
	WebElement signInBtn;
	
	
	public void clickSignInBtnOnHomePage() {
		signInBtnHomePage.click();
	}
	
	public void enterPhoneEmail(String eData) {
		emailPhoneTextField.sendKeys(eData);
	}
	
	public void clickContinueBtn() {
		continueBtn.click();
	}
	
	public void enterPassword(String pData) {
		passwordField.sendKeys(pData);
	}
	
	public void clickSignBtn() {
		signInBtn.click();
	}
}
