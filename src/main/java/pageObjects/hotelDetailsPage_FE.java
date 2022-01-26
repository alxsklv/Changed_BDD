package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class hotelDetailsPage_FE {
public WebDriver driver;
	
	By detailsButton = By.cssSelector("#details");
	By hotelFeatures = By.cssSelector("#features");
	
	
	public hotelDetailsPage_FE(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public WebElement hotelFeatures()
	{
		return driver.findElement(hotelFeatures);
	}
	
	public WebElement detailsButton()
	{
		return driver.findElement(detailsButton);
	}
	

}

