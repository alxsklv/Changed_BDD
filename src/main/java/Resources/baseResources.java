package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class baseResources {
	public WebDriver driver;
	public Properties prop;
	public WebDriver initializeDriver() throws IOException
	{
		prop = new Properties();
		File fileDirectory = new File("src/main/java/Resources");
		File file = new File(fileDirectory, "data.properties");
		FileInputStream fis = new FileInputStream(file);
		
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome"))
		{
			driver = new ChromeDriver();			

		}
		else if(browserName.equals("firefox"))
		{
			driver = new FirefoxDriver();
			
		}
		else if(browserName.equals("IE"))
		{
			driver = new InternetExplorerDriver();

		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		
	}	

	
}

