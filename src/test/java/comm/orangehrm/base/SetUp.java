package comm.orangehrm.base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import comm.orangehrm.utility.DataConfig;

public class SetUp {
	
	public static WebDriver driver;
	
	@BeforeSuite
	public void openBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\deepacorejavawork\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@BeforeTest
	public void openUrl() throws IOException 
	{
		driver.get(DataConfig.readPropFile("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	}
	
	@AfterSuite
	public void closeBrowser()
	{
		if(driver != null)
		{
			driver.close();
		}
		
	}

}
