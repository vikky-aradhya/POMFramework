package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;

public class LoginPage extends BasePage {
	
	@FindBy(xpath="//a[text()='Home']")
	private WebElement HomeLink; 
	
	@FindBy(name="userName")
	private WebElement UserNameTexBox; 
	
	@FindBy(name="password")
	private WebElement PasswordTexBox; 
	
	@FindBy(name="login")
	private WebElement LoginButton; 
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void goToHomepage() {
		HomeLink.click();
	}
	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public void LoginDetails(String UserName, String Password) {
		UserNameTexBox.sendKeys(UserName);
		PasswordTexBox.sendKeys(Password);
		LoginButton.click();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);	
	}
	

}
