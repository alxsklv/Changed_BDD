package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class supplierMainElements {
public WebDriver driver;
	
	By addHotel = By.cssSelector("#addHotel");	
	By hotelNameField = By.cssSelector("#name");	
	By facilitiesDrop = By.cssSelector("#facility");
	By saveHotel = By.cssSelector("#save");

	
	
	public supplierMainElements(WebDriver driver) {
		
		this.driver = driver;
	}
	

	public WebElement addHotel()
	{
		return driver.findElement(addHotel);
	}
	
	public WebElement hotelNameField()
	{
		return driver.findElement(hotelNameField);
	}
	
	public WebElement facilitiesDrop()
	{
		return driver.findElement(facilitiesDrop);
	}
	
	public WebElement saveHotel()
	{
		return driver.findElement(saveHotel);
	}

}

