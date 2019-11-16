package stepDefinition;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class logdemo {

	public static void main(String[] args) {
	
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.co.in/");
		
		Logger log = Logger.getLogger("devpinoyLogger");
		log.debug("Getting errors");
		driver.quit();
		

	}

}
