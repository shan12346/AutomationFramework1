package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {
	
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver Initializedriver() throws IOException {
		
		prop = new Properties();
		FileInputStream fis= new FileInputStream ("C:\\Users\\deysa\\eclipse-workspace\\E2eProject\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		
		String browsername= prop.getProperty("browser");
		System.out.println(browsername);
		
		if(browsername.equals("chrome"))
		{
			
			System.setProperty("webdriver.chrome.driver", "C:\\Work\\chromedriver.exe");
			 driver = new ChromeDriver();
		}
			
	
		else if (browsername.equals("firefox"))
		{
			
			//execute the code
			driver = new FirefoxDriver();
		}
		
		else if (browsername.equals("IE")) 
		{
			
			//execute the code
			driver = new InternetExplorerDriver();
	    }
driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
return driver;
}
	
	//taking screenshot on failure
	public void getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		


	}
	
	
}
