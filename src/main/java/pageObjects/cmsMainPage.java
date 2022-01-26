package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class cmsMainPage {
	
public WebDriver driver;
	
	By usersTab = By.cssSelector("#user");
	By hotelTab = By.cssSelector("#hotel");

	
	public cmsMainPage(WebDriver driver) {
		
		this.driver = driver;
	}

	
	public WebElement usersTab()
	{
		return driver.findElement(usersTab);
	}
	
	public WebElement hotelTab()
	{
		return driver.findElement(hotelTab);
	}
	

}
