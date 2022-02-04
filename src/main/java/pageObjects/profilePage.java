package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Resources.Waiter;

public class profilePage {
	
	public WebDriver driver;	
	public Waiter waiter;

	By profileUser = By.cssSelector("input[name='firstname']");
	By staticProfileText = By.cssSelector(".dashboard-main-content .form-box .form-title-wrap .title");
	

	By phoneField = By.cssSelector("input[name='phone']");
	By saveProfile = By.cssSelector("button[type='submit']");
	
	By successMessage = By.cssSelector(".dashboard-main-content .form-content .alert");
	
	By myBookingMessage = By.xpath("//div[@class='form-content']//child::div");
	
	By firstBookingInList = By.xpath("//*[@class='table  text-center']//tbody/tr[1]/td[4]");

	
	
	public profilePage(WebDriver driver, Waiter waiter) {
		
		this.driver = driver;
		this.waiter = waiter;
	}
	

	public WebElement profileUser()
	{
		return driver.findElement(profileUser);
	}	

	
	public WebElement staticProfileText()
	{
		return waiter.explicitWait(staticProfileText,30);
	}
	
	public WebElement phoneField()
	{
		return driver.findElement(phoneField);
	}	

	
	public WebElement saveProfile()
	{
		return driver.findElement(saveProfile);
	}	
	
	public WebElement successMessage()
	{
		return waiter.explicitWait(successMessage,30);
	}
	
	public WebElement myBookingMessage()
	{
		return driver.findElement(myBookingMessage);
	}
	
	public WebElement firstBookingInList()
	{
		return driver.findElement(firstBookingInList);
	}


}
