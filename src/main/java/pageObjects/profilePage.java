package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class profilePage {
public WebDriver driver;
	
	By profileUser = By.cssSelector("#profileUser");
	By staticProfileText = By.cssSelector("#pageTitle");
	By userField = By.cssSelector("#userField");
	By emailField = By.cssSelector("#emailField");
	By editProfile = By.cssSelector("#edit");
	By saveProfile = By.cssSelector("#save");
	
	By myBookings = By.cssSelector("#bookings");
	
	
	public profilePage(WebDriver driver) {
		
		this.driver = driver;
	}
	

	public WebElement profileUser()
	{
		return driver.findElement(profileUser);
	}
	
	public WebElement userField()
	{
		return driver.findElement(userField);
	}
	
	public WebElement staticProfileText()
	{
		return driver.findElement(staticProfileText);
	}
	
	public WebElement emailField()
	{
		return driver.findElement(emailField);
	}
	
	public WebElement editProfile()
	{
		return driver.findElement(editProfile);
	}
	
	public WebElement saveProfile()
	{
		return driver.findElement(saveProfile);
	}	
	
	public WebElement myBookings()
	{
		return driver.findElement(myBookings);
	}	

}
