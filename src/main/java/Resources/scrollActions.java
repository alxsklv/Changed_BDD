package Resources;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class scrollActions {
	
	public scrollActions(WebDriver driver) {
		
		this.driver = driver;
	}
	
	private WebDriver driver;


	public void scrollToElement(WebElement locator) {
		
    	Actions actions = new Actions(driver);
    	actions.moveToElement(locator);
    	actions.perform();		
	} 

}
