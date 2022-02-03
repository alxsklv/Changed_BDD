package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Resources.Waiter;

public class supplierMainElements {
	
	public WebDriver driver;
	public Waiter waiter;	
	
	By hotelsParentTab = By.xpath("//*[@data-bs-target='#hotelsmodule']");
	By subHotelItem = By.xpath("//*[@data-bs-target='#Hotels']");	
	By manageHotels = By.xpath("//a[@href=\"https://phptravels.net/api/supplier/hotels\"]");	
	By addHotelButton = By.xpath("//*[@class='add_button']//*[@type='submit']");
	

	
	
	public supplierMainElements(WebDriver driver, Waiter waiter) {
		
		this.driver = driver;
		this.waiter = waiter;
	}
	

	public WebElement hotelsParentTab()
	{
		return waiter.explicitWait(hotelsParentTab, 10);
	}
	
	public WebElement subHotelItem()
	{
		return waiter.explicitWait(subHotelItem, 10);
	}
	
	public WebElement manageHotels()
	{
		return waiter.explicitWait(manageHotels, 10);
	}
	
	public WebElement addHotelButton()
	{
		return waiter.explicitWait(addHotelButton, 10);
	}

}

