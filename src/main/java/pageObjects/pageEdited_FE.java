package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Resources.Waiter;

public class pageEdited_FE {
	
    public WebDriver driver;
	public Waiter waiter;

    By updatedTitle = By.xpath("//*[@class='title stroke-shape']");
    By updatedDescription = By.xpath("//*[@class='sidebar-widget'][2]");

    By seoTags = By.xpath("//meta");
     
    

    public pageEdited_FE(WebDriver driver, Waiter waiter) 
    {
    	
        this.driver = driver;
		this.waiter = waiter;
    }

    public WebElement updatedTitle() 
    {        
    	return driver.findElement(updatedTitle);
    }

    public WebElement updatedDescription() 
    {        
    	return driver.findElement(updatedDescription);
    }
    
    public WebElement seoTags() 
    {        
    	return waiter.explicitWait(seoTags, 20);

    }  

    

    
}
