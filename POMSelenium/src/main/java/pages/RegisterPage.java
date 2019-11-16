package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.BasePage;
import stepDefinition.RegisterTest;

public class RegisterPage extends BasePage {
	
	Logger log = Logger.getLogger(RegisterTest.class);
	
	@FindBy(xpath = "//a[text()='REGISTER']")
	private WebElement register;
	
	@FindBy(name = "firstName")
	private WebElement firstName;
	
	@FindBy(name = "lastName")
	private WebElement lastName;
	
	@FindBy(name = "phone")
	private WebElement phone;
	
	@FindBy(id = "userName")
	private WebElement email;
	
	@FindBy(name = "address1")
	private WebElement address;
	
	@FindBy(name = "city")
	private WebElement city;
	
	@FindBy(name = "state")
	private WebElement state;
	
	@FindBy(name = "postalCode")
	private WebElement PINCode;
	
	@FindBy(name = "country")
	private WebElement country;
	
	@FindBy(id = "email")
	private WebElement userName;
	
	@FindBy(name = "password")
	private WebElement password;
	
	@FindBy(name = "confirmPassword")
	private WebElement cPassword;
	
	@FindBy(name = "register")
	private WebElement submit;
	
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getHomePageTitle() {
		return driver.getTitle();
	}
	
	public void goToRegisterPage() {
		register.click();
	}
	
	public String getRegisterPageTitle() {
		return driver.getTitle();
	}
	
	public void enterContactInformation(String fName, String lName, String ph, String eMail) {
		firstName.sendKeys(fName);
		log.info("First Name value "+fName+" in entered");
		lastName.sendKeys(lName);
		log.info("Last Name value "+lName+" in entered");
		phone.sendKeys(ph);
		log.info("Phone value "+ph+" in entered");
		email.sendKeys(eMail);
		log.info("Email value "+eMail+" in entered");
	}
	
	public void enterMailingInformation(String mAddress, String mCity, String mState, String mPostalCode, String mCoutry) {
		address.sendKeys(mAddress);
		city.sendKeys(mCity);
		state.sendKeys(mState);
		PINCode.sendKeys(mPostalCode);
		Select select = new Select(country);
		select.selectByVisibleText(mCoutry);
	}
	
	public void enterUserInformation(String uUserName, String uPassword, String uCPassword) {
		userName.sendKeys(uUserName);
		password.sendKeys(uPassword);
		cPassword.sendKeys(uCPassword);
	}
	
	public void submitRegister() {
		submit.click();
	}
	
}
