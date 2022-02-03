package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Resources.Waiter;

public class hotelSelectionPage {
	
	public WebDriver driver;
	public Waiter waiter;	
 

	By cityName = By.cssSelector(".select2-selection__rendered");
	By cityNameActive = By.cssSelector(".select2-search__field");	
    By foundHotel = By.xpath("//body/span[1]/span[1]/span[2]/ul[1]/li[1]");
    
    By checkIn = By.cssSelector("#checkin");
    By checkOut = By.cssSelector("#checkout");
	
	By searchButton = By.cssSelector("#submit");
	
	By localsButton = By.cssSelector("#languages");
	
	
	public hotelSelectionPage(WebDriver driver, Waiter waiter) {
		
		this.driver = driver;
		this.waiter = waiter;
	}
	

	public WebElement cityName()
	{
		return driver.findElement(cityName);
	}
	
	
	public WebElement cityNameActive()
	{
		return driver.findElement(cityNameActive);
	}
	
	public WebElement foundHotel()
	{
		return waiter.fluentWait(foundHotel);
	}
	
	public WebElement checkIn()
	{
		return waiter.fluentWait(checkIn);
	}	
	
	public WebElement checkOut()
	{
		return waiter.fluentWait(checkOut);
	}	
	
	
	public WebElement searchButton()
	{
		return driver.findElement(searchButton);
	}	
	
	public WebElement localsButton()
	{
		return driver.findElement(localsButton);
	}

	
}
