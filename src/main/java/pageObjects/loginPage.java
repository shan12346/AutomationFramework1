package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//create class of logingpage elemets only by pageobjcet
public class loginPage {
 
	public WebDriver driver;
	
	By email = By.cssSelector("input[id='user_email']");
	By password = By.cssSelector("input[type='password']");
	By login = By.cssSelector("input[type='submit']");

	public loginPage(WebDriver driver) {
		
		this.driver=driver;
	}


	public WebElement getemail() {
		
		return driver.findElement(email);
	}
    public WebElement getpassword() {
		
		return driver.findElement(password);
	}
    public WebElement getlogin() {
		
		return driver.findElement(login);
	}


	
}

