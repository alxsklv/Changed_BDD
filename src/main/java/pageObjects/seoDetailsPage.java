package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class seoDetailsPage {
public WebDriver driver;
	
	By tagSelection = By.cssSelector("#tag");
	By saveButton = By.cssSelector("#save");

	
	
	public seoDetailsPage(WebDriver driver) {
		
		this.driver = driver;
	}
	

	public WebElement tagSelection()
	{
		return driver.findElement(tagSelection);
	}
	
	public WebElement saveButton()
	{
		return driver.findElement(saveButton);
	}
	

}

