package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.landingPage;
import pageObjects.loginPage;
import resources.base;

public class HomePage extends base{
	
	public WebDriver driver;
	
	public static Logger log =LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void iniDriver() throws IOException {
		driver = Initializedriver();
		
	}
	
	
	@Test(dataProvider="getData")
	public void basePagenavigation(String username,String password,String text) throws IOException {
		
		driver.get(prop.getProperty("url"));
		
		//click the login button
		landingPage lp = new landingPage(driver);
		lp.getLogin().click();
		
		//log in credential
		loginPage lg = new loginPage(driver);
		lg.getemail().sendKeys(username);
		lg.getpassword().sendKeys(password);
		
		log.info(text);
		//System.out.println(text);
		
		
		lg.getlogin().click();
	}
	
	@DataProvider
	public Object[][] getData() {
		//rows stand for how many different data types should run
		//Column stands for how many values per each test cases
		Object[][] data = new Object[2][3];
		
		data[0][0]="nonrestricted@gmail.com";
		data[0][1]="25632";
		data[0][2]="restricted_user";
		
		data[1][0]="restricted@gmail.com";
		data[1][1]="25632";
		data[1][2]="nonrestricted_user";
		
		return data;
		
		
		
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
	}

}
