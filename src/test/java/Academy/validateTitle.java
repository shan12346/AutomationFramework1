package Academy;

import static org.testng.Assert.assertEquals;

import java.io.IOException;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.landingPage;
import resources.base;

public class validateTitle extends base{
	
	public WebDriver driver;
	//log object initialized
	public static Logger log =LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void iniDriver() throws IOException {
		driver = Initializedriver();
		log.info("Driver is initialized");
		
		driver.get(prop.getProperty("url"));
		log.info("Navigated to the HomePage");
	}
	
	@Test
	public void basePagenavigation() throws IOException {
		
		landingPage lp = new landingPage(driver);
		
		Assert.assertEquals(lp.getTitle().getText(),"FEATURED COURSES123");
		log.info("Successfully validated the text");
	
	}
	@AfterTest
	public void teardown() {
		driver.close();
	}
	
}
