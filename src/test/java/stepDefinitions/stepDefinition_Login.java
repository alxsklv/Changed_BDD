package stepDefinitions;


import org.openqa.selenium.By;
import org.testng.Assert;

import Resources.baseResources;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.hotelSelectionPage;

public class stepDefinition_Login extends baseResources {
	
    @Given("^User is on login page with url for corresponding localization (.+)$")
    public void login_page_with_localization(String url) throws Throwable 
    {		
		driver = initializeDriver();
		driver.get(url); 
	}
    
    @When("^User enters tha name \"([^\"]*)\" of the hotel to the search field$")
    public void user_enters_hotel_name(String hotelNameMM) throws Throwable {
    	
    	hotelSelectionPage h = new hotelSelectionPage(driver);
    	h.searchField().sendKeys(hotelNameMM);
        
    }

    @And("^See corresponding (.+) for selected localization$")
    public void see_corresponding_messag_per_localization(String localMessage) throws Throwable {
    	
    	String successMessage = driver.findElement(By.id("bookingResult")).getText();
    	Assert.assertEquals(successMessage, localMessage);
    	
    	driver.quit();
        
    }	


}
