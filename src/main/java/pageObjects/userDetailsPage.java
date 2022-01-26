package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class userDetailsPage {
public WebDriver driver;
	
	By addNewUser = By.cssSelector("#add");

	By userName = By.cssSelector("#name");	
	By userPassword = By.cssSelector("#pwd");
	By userEmail = By.cssSelector("#eml");
	By birthday = By.cssSelector("#dob");
	
	By saveButton = By.cssSelector("#save");
	By removeUser = By.cssSelector("#remove");
	
	
	public userDetailsPage(WebDriver driver) {
		
		this.driver = driver;
	}
	

	public WebElement userName()
	{
		return driver.findElement(userName);
	}
	
	public WebElement userPassword()
	{
		return driver.findElement(userPassword);
	}
	
	public WebElement userEmail()
	{
		return driver.findElement(userEmail);
	}
	
	public WebElement birthday()
	{
		return driver.findElement(birthday);
	}
	
	public WebElement saveButton()
	{
		return driver.findElement(saveButton);
	}
	
	public WebElement addNewUser()
	{
		return driver.findElement(addNewUser);
	}
	
	public WebElement removeUser()
	{
		return driver.findElement(removeUser);
	}
	

}

