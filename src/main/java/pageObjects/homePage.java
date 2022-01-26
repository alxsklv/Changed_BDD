package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class homePage {
public WebDriver driver;
	
	By onSiteUsername = By.cssSelector("#currentUser");
	By profileButton = By.cssSelector("#profileButton");
	By aboutTab = By.cssSelector("#about");
	By hotelsTab = By.cssSelector("#hotels");
	By membershipTab = By.cssSelector("#membership");
	
	
	
	public homePage(WebDriver driver) {
		
		this.driver = driver;
	}
	

	public WebElement onSiterUsername()
	{
		return driver.findElement(onSiteUsername);
	}
	
	public WebElement profileButtonIcon()
	{
		return driver.findElement(profileButton);
	}
	
	public WebElement aboutTab()
	{
		return driver.findElement(aboutTab);
	}
	
	public WebElement hotelsTab()
	{
		return driver.findElement(hotelsTab);
	}
	
	public WebElement membershipTab()
	{
		return driver.findElement(membershipTab);
	}
	


}
