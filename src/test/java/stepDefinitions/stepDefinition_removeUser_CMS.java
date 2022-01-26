package stepDefinitions;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;


import org.testng.Assert;

import Resources.baseResources;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.userDetailsPage;

public class stepDefinition_removeUser_CMS extends baseResources {

	@And("^Admin selects user \"([^\"]*)\" by clicking on his name$")
    public void admin_selects_user(String userName) throws Throwable {
        
    	
    	//Iterating through the users column and click on their name to get it selected
    
    	List<WebElement> usersFromTable = driver.findElements(By.xpath(".tableHead tb:nth-child(1)"));		
		
    	for (int i=0; i<usersFromTable.size(); i++)
    	{
    		String singleValue = usersFromTable.get(i).getText();
    		
    		if (singleValue.equals(userName)) 
    		{
    			usersFromTable.get(i).click();
    		}
    		else
    		{
    			Assert.assertTrue(false, "User is absent");
    		}    		
    	}    	
    }
	
    @When("^Remove button is clicked$")
    public void remove_button_is_clicked() throws Throwable {
        
    	userDetailsPage u = new userDetailsPage(driver);
    	u.removeUser().click();
    	//assuming that we don't need additional confirmation to remove the user
       
    }
    
    @Then("^The \"([^\"]*)\" pop up is shown$")
    public void the_something_pop_up_is_shown(String validMessage) throws Throwable {
        
    	Alert alert = driver.switchTo().alert();
    	String alertMessage= alert.getText();
    	
    	Assert.assertEquals(alertMessage, validMessage);
    	
    	driver.quit();
    }
    
    
}
