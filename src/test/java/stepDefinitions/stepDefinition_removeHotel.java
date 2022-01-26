package stepDefinitions;

import org.openqa.selenium.Alert;


import org.testng.Assert;

import Resources.baseResources;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.hotelDetailsPage_CMS;

public class stepDefinition_removeHotel extends baseResources {

    @When("^Admin clicks on Delete button$")
    public void admin_clicks_on_delete_button() throws Throwable {
        
    	hotelDetailsPage_CMS h = new hotelDetailsPage_CMS(driver);
    	h.deleteHotel().click();
    }
    
    @Then("^The \"([^\"]*)\" popup is shown$")
    public void the_something_popup_is_shown(String removedMessage) throws Throwable {
        
    	Alert alert = driver.switchTo().alert();
    	String alertMessage= alert.getText();
    	
    	Assert.assertEquals(alertMessage, removedMessage);
    	
    	driver.quit();
    	
    }

}
