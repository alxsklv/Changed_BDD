package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class supplierLoginPage {
public WebDriver driver;
	
	By email = By.cssSelector("#email");
	By password = By.cssSelector("#pass");
	By login = By.xpath("//button[@name='login']");
	
	
	public supplierLoginPage(WebDriver driver) {
		
		this.driver = driver;
	}	


	public WebElement enterEmail()
	{
		return driver.findElement(email);
	}
	
	public WebElement enterPassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement clickLogin()
	{
		return driver.findElement(login);
	}

}
