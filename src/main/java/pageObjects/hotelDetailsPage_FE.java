package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Resources.Waiter;

public class hotelDetailsPage_FE {
	
	public WebDriver driver;
	public Waiter waiter;	
 
	
	By twoStars = By.xpath("//input[@id='stars_2']//parent::div[1]");	
	By detailsButton = By.cssSelector(".effect.mt-0.btn-block.ladda-button.waves-effect:nth-child(6)");
	
	By cookiesBanner = By.cssSelector("#cookie_stop");
	By bookNow = By.xpath("//*[contains (text(),'Triple Rooms')]//following::span[1]");
	
	By firstName_1 = By.xpath("//*[@name='firstname_1']");
	By lastName_1 = By.xpath("//*[@name='lastname_1']");
	
	By firstName_2 = By.xpath("//*[@name='firstname_2']");
	By lastName_2 = By.xpath("//*[@name='lastname_2']");
	
	By paymentMethod = By.xpath("//input[@id='gateway_stripe']");
			
	By termsCheck = By.cssSelector(".custom-checkbox");
	By confirmBooking = By.cssSelector("#booking");
	
	//There is no chance to receive success message so I'm not sure what will be selector 
	By confirmationMessage = By.xpath("/html[1]/body[1]/p[1]/strong[1]");
	
	
	
	public hotelDetailsPage_FE(WebDriver driver, Waiter waiter) {
		
		this.driver = driver;
		this.waiter = waiter;
	}	


	
	public WebElement twoStars()
	{
		return driver.findElement(twoStars);
	}
	
	public WebElement detailsButton()
	{
		return driver.findElement(detailsButton);
	}
	
	public WebElement cookiesBanner()
	{
		return driver.findElement(cookiesBanner);
	}
	
	public WebElement bookNow()
	{
		return waiter.explicitWait(bookNow, 30);
	}
	
	public WebElement firstName_1()
	{
		return driver.findElement(firstName_1);
	}
	
	public WebElement lastName_1()
	{
		return driver.findElement(lastName_1);
	}
	
	public WebElement firstName_2()
	{
		return driver.findElement(firstName_2);
	}
	
	public WebElement lastName_2()
	{
		return driver.findElement(lastName_2);
	}
	
	public WebElement paymentMethod()
	{
		return driver.findElement(paymentMethod);
	}
	
	public WebElement termsCheck()
	{
		return driver.findElement(termsCheck);
	}
	
	public WebElement confirmationMessage()
	{
		return driver.findElement(confirmationMessage);
	}
	
	public WebElement confirmBooking()
	{
		return driver.findElement(confirmBooking);
	}
	
}


