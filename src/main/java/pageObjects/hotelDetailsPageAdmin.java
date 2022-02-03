package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Resources.Waiter;

public class hotelDetailsPageAdmin {
	public WebDriver driver;
	public Waiter waiter;	
	
	By hotelNameAdmin = By.xpath("//div[@id='s2id_autogen1']//*[@class='select2-chosen']");
	By descriptionBox = By.xpath("/html[1]/body[1]");	
	By priceHotelAdmin = By.xpath("//*[@class='col-md-8']//*[@placeholder='Price']");	
	By amentiesTab = By.cssSelector("#AMENITIES-tab");
	By translateTab = By.cssSelector("#TRANSLATE-tab");
	By descriptionBoxGerman = By.xpath("//div[@id='cke_3_contents']");
	By submitButton = By.xpath("//button[@id='add']");
	
	By hotelListContainer = By.xpath("//*[@class='xcrud-container']");
	
	
	public hotelDetailsPageAdmin(WebDriver driver, Waiter waiter) {
		
		this.driver = driver;
		this.waiter = waiter;
	}
	

	public WebElement hotelNameAdmin()
	{
		return driver.findElement(hotelNameAdmin);
	}
	
	public WebElement descriptionBox()
	{
		return driver.findElement(descriptionBox);
	}
	
	public WebElement priceHotelAdmin()
	{
		return driver.findElement(priceHotelAdmin);
	}
	
	public WebElement amentiesTab()
	{
		return driver.findElement(amentiesTab);
	}
	
	public WebElement translateTab()
	{
		return driver.findElement(translateTab);
	}	
	
	public WebElement descriptionBoxGerman()
	{
		return driver.findElement(descriptionBoxGerman);
	}
	
	public WebElement submitButton()
	{
		return waiter.explicitWait(submitButton, 20);
	}
	
	public WebElement hotelListContainer()
	{
		return waiter.explicitWait(hotelListContainer, 20);
	}

	

}

