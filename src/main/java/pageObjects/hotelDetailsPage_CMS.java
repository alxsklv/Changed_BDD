package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class hotelDetailsPage_CMS {
public WebDriver driver;
	
	By editHotel = By.cssSelector("#edit");

	By hotelName = By.cssSelector("#name");	
	By facilitiesSelection = By.cssSelector("#facilities");
	
	By saveButton = By.cssSelector("#save");
	
	By seoTab = By.cssSelector("#seo");
	
	By deleteHotel = By.cssSelector("#delete");

	
	
	public hotelDetailsPage_CMS(WebDriver driver) {
		
		this.driver = driver;
	}
	

	public WebElement editHotel()
	{
		return driver.findElement(editHotel);
	}
	
	public WebElement hotelName()
	{
		return driver.findElement(hotelName);
	}
	
	public WebElement facilitiesSelection()
	{
		return driver.findElement(facilitiesSelection);
	}
	
	public WebElement saveButton()
	{
		return driver.findElement(saveButton);
	}
	
	public WebElement seoTab()
	{
		return driver.findElement(seoTab);
	}
	
	public WebElement deleteHotel()
	{
		return driver.findElement(deleteHotel);
	}
	

}

