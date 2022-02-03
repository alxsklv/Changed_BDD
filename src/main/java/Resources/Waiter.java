package Resources;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiter {
	
	public Waiter(WebDriver driver) {
		
		this.driver = driver;
	}
	
	private WebDriver driver;

	@SuppressWarnings("deprecation")
	public WebElement fluentWait(final By locator) {
	    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
	            .withTimeout(30, TimeUnit.SECONDS)
	            .pollingEvery(10, TimeUnit.SECONDS)
	            .ignoring(NoSuchElementException.class);

	    WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
	        public WebElement apply(WebDriver driver) {
	            return driver.findElement(locator);
	        }
	    });

	    return  foo;
	};
	
	public WebElement explicitWait(By locator, int timeout) {
		
		WebDriverWait wait = new WebDriverWait(driver,timeout);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		
		return driver.findElement(locator);
		
	} 

}
