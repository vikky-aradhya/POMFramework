package stepDefinition;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BasePage;
import pages.RegisterPage;
import utils.ExcelUtility;

public class RegisterTest extends BasePage {
	
	private Properties prop;
	public WebDriver driver;
	public RegisterPage registerPage;
	public ExcelUtility excelReader;
	//Logger log = Logger.getLogger(RegisterTest.class);
	Logger log = Logger.getLogger("devpinoyLogger");
	
	@BeforeSuite
	@Parameters({"scenario", "sheet"})
	public void setUp(String scenarioName, String sheetName) throws Exception {
		prop = init_properties();
		driver = init_driver(prop.getProperty("browser"));
		registerPage = new RegisterPage(driver);
		excelReader = new ExcelUtility(scenarioName, sheetName);
	}
	
	@Test(priority = 0)
	public void verifyHomePageTitle() {		
			String title = registerPage.getHomePageTitle();
			System.out.println("Home Page Title is: " +title);
			Assert.assertEquals(title, "Welcome: Mercury Tours");
			log.info("title matched!!!");
		
	}
	
	
	@Test(priority = 1)
	public void registerUser() {
		registerPage.goToRegisterPage();
	}
	
	@Test(priority = 2)
	public void verifyRegisterPageTitle() {
		String title = registerPage.getRegisterPageTitle();
		System.out.println("Register Page Title is: " +title);
		Assert.assertEquals(title, "Register: Mercury Tours");
	}
	
	@Test(priority = 3)
	public void enterUserDetails() {
		registerPage.enterContactInformation(testdataMap.get("FirstName"), testdataMap.get("LastName"), testdataMap.get("Phone"), testdataMap.get("Email"));
		registerPage.enterMailingInformation(testdataMap.get("Address"), testdataMap.get("City"), testdataMap.get("State"), testdataMap.get("Postal_Code"), testdataMap.get("Country"));
		registerPage.enterUserInformation(testdataMap.get("Username"), testdataMap.get("Password"), testdataMap.get("Password"));
		registerPage.submitRegister();
	}
	
	@AfterSuite
	public void tearDown() {
		driver.quit();
	}

}
