package comm.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
	
		this.driver = driver;
	}
	
	public By username = By.name("txtUsername");
	public By password = By.name("txtPassword");
	public By loginBtn = By.name("Submit");
		
	public void login(String name, String pass ){
		
		driver.findElement(username).sendKeys(name);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(loginBtn).click();
		
		
		
		
	}

	

}
