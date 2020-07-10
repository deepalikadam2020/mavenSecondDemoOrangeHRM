package comm.orangehrm.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import comm.orangehrm.base.SetUp;
import comm.orangehrm.pages.EmployeeDetails;
import comm.orangehrm.pages.LoginPage;
import comm.orangehrm.utility.DataConfig;

public class DetailsTestCases extends SetUp {

	EmployeeDetails ed;
	LoginPage l;
	
	@BeforeClass
	public void beforeclass()
	{
		l =new LoginPage(driver);
		ed= new EmployeeDetails(driver);
	}
	
	@Test(priority = 1)
	public void informationEmployee()
	{
	
		l.login(DataConfig.readPropFile("validUsername"),DataConfig.readPropFile("validPassword"));
		driver.findElement(ed.admin).click();
		ed.verifyEmployeeDetails(DataConfig.readPropFile("searchUsername"));
	}
	
	@Test(priority = 2)
	public void infoOfSearchedEmployee()
	{
		ed.searchEmoloyeeDetail(DataConfig.readPropFile("searchUsername"),DataConfig.readPropFile("searchEmployeeName"));
		ed.verifyEmployeeDetails(DataConfig.readPropFile("searchUsername"));

	}
}