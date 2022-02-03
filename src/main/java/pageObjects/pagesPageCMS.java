package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Resources.Waiter;

public class pagesPageCMS {
	
    public WebDriver driver;
	public Waiter waiter;

    By firstPageInList = By.xpath("//*[@class='xcrud-row xcrud-row-0'][5]/td/span/a");   //First element was changing by someone so I used another one
    By editButtonOfPage = By.cssSelector("a[title=\"Edit\"");
    By pageTitle = By.xpath("//*[@name='pagetitle']");
    By permaLink = By.xpath("//*[@name='pageslug']");    
    By descriptionField = By.xpath("/html[1]/body[1]");
    By seoKey = By.xpath("//input[@name='keywords']");
    By seoDescription = By.xpath("//input[@name='pagedesc']");
    By submitChanges = By.xpath("//button[@type='submit']");
    

    public pagesPageCMS(WebDriver driver, Waiter waiter) 
    {
    	
        this.driver = driver;
		this.waiter = waiter;
    }

    public WebElement firstPageInList() 
    {        
    	return driver.findElement(firstPageInList);
    }

    public WebElement editButtonOfPage() 
    {        
    	return driver.findElement(editButtonOfPage);
    }
    
    public WebElement pageTitle() 
    {        
    	return waiter.explicitWait(pageTitle, 20);

    }
    
    public WebElement permaLink() 
    {        
    	return driver.findElement(permaLink);
    }
    
    public WebElement descriptionField() 
    {        
    	return driver.findElement(descriptionField);
    }
    
    public WebElement seoKey() 
    {     
    	return driver.findElement(seoKey);
    }
    
    public WebElement seoDescription() 
    {        
    	return driver.findElement(seoDescription);
    }  
    
    public WebElement submitChanges() 
    {        
    	return driver.findElement(submitChanges);
    }
    
    
}
