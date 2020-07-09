package comm.orangehrm.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import comm.orangehrm.base.SetUp;
import comm.orangehrm.pages.EmployeeDetails;
import comm.orangehrm.pages.LoginPage;

public class DetailsTestCases extends SetUp {
	
	//public WebDriver driver;
	EmployeeDetails ed;
	LoginPage l;
	
	@BeforeClass
	public void beforeclass()
	{
		l =new LoginPage(driver);
		ed= new EmployeeDetails(driver);
	}
	
	@Test
	public void informationEmployee()
	{
	
		//l.login(DataConfig.readPropFile("validUsername"),DataConfig.readPropFile("validPassword"));
		driver.findElement(ed.admin).click();
		ed.searchEmployeeDetails();
		
	}
}
