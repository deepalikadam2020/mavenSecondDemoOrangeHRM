package comm.orangehrm.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import comm.orangehrm.base.SetUp;
import comm.orangehrm.pages.LoginPage;
import comm.orangehrm.utility.DataConfig;

public class LoginTestCases extends SetUp {
	
	LoginPage l;

	@BeforeClass 
	public void beforeclass()
	{
		l =new LoginPage(driver);
	}

	@Test(priority = 3)
	public void validLogin()
	{
		l.login(DataConfig.readPropFile("validUsername"),DataConfig.readPropFile("validPassword"));
	}
	
	@Test(priority = 2)
	public void inavlidLogin1()
	{
		l.login(DataConfig.readPropFile("validUsername"), DataConfig.readPropFile("invalidPassword"));
	}
	
	@Test(priority = 1)
	public void invalidLogin1()
	{
		l.login(DataConfig.readPropFile("invalidUsername"), DataConfig.readPropFile("validPassword"));
	}


}
