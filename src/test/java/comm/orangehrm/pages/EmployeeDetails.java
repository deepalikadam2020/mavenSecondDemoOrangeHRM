package comm.orangehrm.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class EmployeeDetails {

	public WebDriver driver;

	public EmployeeDetails(WebDriver driver) {

		this.driver = driver;
	}

	String stringTableRow = "//table[@id='resultTable']/tbody/tr";
	
	public By admin = By.xpath("//a[@id='menu_admin_viewAdminModule']");
	public By table = By.xpath("//table[@id='resultTable']/tbody/tr");
	public By editUsername = By.name("searchSystemUser[userName]");
	public By editEmployeeName = By.name("searchSystemUser[employeeName][empName]");
	public By dropdownUserRole = By.xpath("//select[@name=\"searchSystemUser[userType]\"]");
	public By dropdownStatus = By.xpath("//select[@name=\"searchSystemUser[status]\"]");
	public By searchBtn = By.xpath("//input[@id=\"searchBtn\"]");
	public By resetBtn = By.xpath("//input[@id=\"resetBtn\"]");

	public void searchEmoloyeeDetail(String sUsername, String sEmployeeName) {

		driver.findElement(editUsername).sendKeys(sUsername);

		WebElement userroleOption = driver.findElement(dropdownUserRole);
		Select sel = new Select(userroleOption);
		sel.selectByValue("2");
		
		driver.findElement(editEmployeeName).sendKeys(sEmployeeName);
		
		WebElement statusOption = driver.findElement(dropdownStatus);
		Select sel1 = new Select(statusOption);
		sel1.selectByValue("1");

		driver.findElement(searchBtn).click();

	}

	public boolean verifyEmployeeDetails(String un) {
		
		List<WebElement> ls = driver.findElements(table);
		int count = ls.size();
		System.out.println(count);

		for (int i = 1; i <= count; i++) {
			String userName = driver.findElement(By.xpath(stringTableRow + "[" + i + "]/td[2]/a")).getText();
			if (userName.equals(un)) {
				System.out.println("username ==" + userName);
				Assert.assertEquals(userName, un, "username not match");
				String userRole = driver.findElement(By.xpath(stringTableRow + "[" + i + "]//td[3]")).getText();
				System.out.println("userrole ==" + userRole);
				String employeeName = driver.findElement(By.xpath(stringTableRow + "[" + i + "]//td[4]")).getText();
				System.out.println("employee name ==" + employeeName);
				String status = driver.findElement(By.xpath(stringTableRow + "[" + i + "]/td[5]")).getText();
				System.out.println("status ==" + status);
				return true;
			}
		}
		
		System.out.println(" record not found");
		return false;
	}
}
