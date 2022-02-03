package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Resources.baseResources;

public class homePage extends baseResources {

	
	By onSiteUsername = By.xpath("//*[@class='author__title']/strong");
	By profileButtonIcon = By.xpath("//*[@class='sidebar-menu list-items']/li[4]");


	By hotelsTab = By.cssSelector(".main-menu-content [href=\"https://www.phptravels.net/hotels\"]");
	
	By bookingsTab = By.xpath("//div[@class='sidebar-menu-wrap']//a[@href='https://www.phptravels.net/account/bookings']");
	
	
	
	public homePage(WebDriver driver) {
		
		this.driver = driver;
	}
	

	public WebElement onSiterUsername()
	{
		return driver.findElement(onSiteUsername);
	}
	
	public WebElement profileButtonIcon()
	{
		return driver.findElement(profileButtonIcon);
	}	

	
	public WebElement hotelsTab()
	{
		return driver.findElement(hotelsTab);
	}	
	
	public WebElement bookingsTab()
	{
		return driver.findElement(bookingsTab);
	}


}
