package comm.orangehrm.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EmployeeDetails {
	
	public EmployeeDetails(WebDriver driver) {
	
		this.driver= driver;
	}

	String stringTableRow = "//table[@id='resultTable']/tbody/tr";
	
	public WebDriver driver;

	public  By admin = By.xpath("//a[@id='menu_admin_viewAdminModule']");
	public  By table = By.xpath("//table[@id='resultTable']/tbody/tr");
	
	public void searchEmployeeDetails()
	{
		
		List<WebElement> ls = driver.findElements(table);
		int count = ls.size();
		System.out.println(count);
		
		for(int i=1; i<=count; i++)
		{	
			String userName = driver.findElement(By.xpath(stringTableRow+"["+i+"]/td[2]/a")).getText();
			//System.out.println(userName);
			
			if(userName.equalsIgnoreCase("linda.anderson"))
			{
					System.out.println("username =="+userName);
					String employeeName = driver.findElement(By.xpath(stringTableRow+"["+i+"]//td[4]")).getText();
					System.out.println("employee name =="+employeeName);
					String status = driver.findElement(By.xpath(stringTableRow+"["+i+"]/td[5]")).getText();
					System.out.println("status =="+status);
					
			}
			
		}
	
		
		
	}

}
