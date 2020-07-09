package comm.orangehrm.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DataConfig {
	
	static File file = new File("E:\\deepacorejavawork\\MavenSecondDemoOrangeHRM\\credentials.properties");
	
	public static String readPropFile(String value) 
	{
		FileInputStream fileInput = null; 
		try 
		{
		fileInput = new FileInputStream(file);
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		Properties prop;
		prop = new Properties();
		try
		{
		prop.load(fileInput);
		}
		catch (IOException e1) 
		{
			e1.printStackTrace();
		}

		return 	prop.getProperty(value);
	
	}

}
