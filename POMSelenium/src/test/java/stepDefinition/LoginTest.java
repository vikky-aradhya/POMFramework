package stepDefinition;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BasePage;
import pages.LoginPage;

public class LoginTest extends BasePage {
	
	public LoginPage loginpage;
	
	@Test(priority = 4)
	public void goToLoginPage() {
		loginpage = new LoginPage(getDriver());
	}
	
	@Test(priority = 5)
	public void goToHomePage() {
		loginpage.goToHomepage();
	}
	
	@Test(priority = 6)
	public void verifyLoginPageTitle() {
		String title = loginpage.getLoginPageTitle();
		System.out.println("Login Page Title is: " +title);
		Assert.assertEquals(title, "Welcome: Mercury Tours");
	}
	
	@Test(priority = 7)
	public void loginUser() {
		loginpage.LoginDetails(testdataMap.get("Username"), testdataMap.get("Password"));
	}

}

