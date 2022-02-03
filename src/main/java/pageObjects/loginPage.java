package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {

	public WebDriver driver;
	
	By loginButton = By.linkText("Login");
	By email = By.cssSelector("input[type='email']");
	By password = By.cssSelector("input[type='password']");
	By login = By.cssSelector("button[type='submit']");
	
	
	public loginPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public WebElement loginButton()
	{
		return driver.findElement(loginButton);
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