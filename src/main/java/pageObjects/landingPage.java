package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
// create class of landingpage elemets only by pageobjcet
public class landingPage {
 
	public WebDriver driver;
	
	By signin = By.cssSelector("a[href*='sign_in']");
	By title = By.cssSelector(".text-center>h2");
	By navbar = By.cssSelector(".nav.navbar-nav.navbar-right>li>a");
	

	public landingPage(WebDriver driver) {
		// driver variable created inside class assigned to WebDriver driver
		this.driver=driver;
	}


	public WebElement getLogin() {
		
		return driver.findElement(signin);
	}

public WebElement getTitle() {
		
		return driver.findElement(title);
	}
public WebElement getNavigationbar() {
	
	return driver.findElement(navbar);
}

	
}
