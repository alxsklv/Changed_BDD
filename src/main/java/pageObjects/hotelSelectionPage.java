package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class hotelSelectionPage {
public WebDriver driver;
	
	//Main level fields 
    By searchField = By.cssSelector("#search");	
	By cityName = By.cssSelector("#ss");	
	By peopleAmount = By.cssSelector("#adults");

	//Filters related fields 
	//Filters on the website are shown as checkboxes 
	By filtersExpand = By.cssSelector("#filters");
	By priceFilter_between_50_and_100 = By.cssSelector("#price50and100");
	By buildingType_Villa = By.cssSelector("#villa");
	By district_Center = By.cssSelector("#cityCenter");
	By starRating_5 = By.cssSelector("#starFive");
	
	By applyButton = By.cssSelector("#applyBtn");	
	

	
	public hotelSelectionPage(WebDriver driver) {
		
		this.driver = driver;
	}
	

	public WebElement cityName()
	{
		return driver.findElement(cityName);
	}
	
	
	public WebElement filtersExpand()
	{
		return driver.findElement(filtersExpand);
	}
	
	public WebElement peopleAmount()
	{
		return driver.findElement(peopleAmount);
	}
	
	public WebElement priceFilter_between_50_and_100()
	{
		return driver.findElement(priceFilter_between_50_and_100);
	}
	
	public WebElement buildingType_Villa()
	{
		return driver.findElement(buildingType_Villa);
	}
	
	public WebElement district_Center()
	{
		return driver.findElement(district_Center);
	}
	
	public WebElement starRating_5()
	{
		return driver.findElement(starRating_5);
	}
	
	public WebElement applyButton()
	{
		return driver.findElement(applyButton);
	}
	
	public WebElement searchField()
	{
		return driver.findElement(searchField);
	}
	
}
