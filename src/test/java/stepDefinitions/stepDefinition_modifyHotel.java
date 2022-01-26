package stepDefinitions;

import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import Resources.baseResources;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.cmsMainPage;
import pageObjects.hotelDetailsPage_CMS;

public class stepDefinition_modifyHotel extends baseResources {

	
    @And("^Admin selects Hotel section$")
    public void admin_selects_hotel_section() throws Throwable {
        
    	cmsMainPage m = new cmsMainPage(driver);
        m.hotelTab().click();
    }
    
    @And("^Selects \"([^\"]*)\" hotel from the list$")
    public void selects_hotel_from_the_list(String monksHotel) throws Throwable {
    	
    	List<WebElement> hotelsFromTable = driver.findElements(By.xpath(".tableHead tb:nth-child(1)"));		
    	
    	for (int i=0; i<hotelsFromTable.size(); i++)
    	{
    		String singleValue = hotelsFromTable.get(i).getText();
    		
    		if (singleValue.equals(monksHotel)) 
    		{
    			hotelsFromTable.get(i).click();
    		}
    		else
    		{
    			Assert.assertTrue(false, "Hotel is absent");
    		}
    		
    	}
    	
    }
    
    @And("^Changes the name of the hotel to \"([^\"]*)\"$")
    public void changes_the_name_of_the_hotel(String newHotelName) throws Throwable {
    	
    	hotelDetailsPage_CMS h = new hotelDetailsPage_CMS(driver);
    	h.editHotel().click();
    	
    	h.hotelName().clear();
    	h.hotelName().sendKeys(newHotelName);
        
    }
    
    @And("^Clear facilites field and add \"([^\"]*)\" facility only$")
    public void clear_facilites_field_and_add(String newFacility) throws Throwable {
        
    	hotelDetailsPage_CMS h = new hotelDetailsPage_CMS(driver);
    	h.facilitiesSelection().clear();
    	
    	Select dropOptions =  new Select(h.facilitiesSelection());    	
    	dropOptions.selectByVisibleText(newFacility);

    }
    
    @When("^Admin hits Save button to save modifications$")
    public void admin_hits_save_button_to_save_modifications() throws Throwable {

    	hotelDetailsPage_CMS h = new hotelDetailsPage_CMS(driver);
    	h.saveButton().click();
    }

    @Then("^New values \"([^\"]*)\" and \"([^\"]*)\" are populated to corresponding fields$")
    public void new_values_something__are_populated(String newName, String newFacility) throws Throwable {
    	
    	hotelDetailsPage_CMS h = new hotelDetailsPage_CMS(driver);
    	
    	String hotelNameExtr = h.hotelName().getText();
    	String faciityExtr = h.facilitiesSelection().getText();
    	
    	Assert.assertEquals(hotelNameExtr, newName);
    	Assert.assertEquals(faciityExtr, newFacility);
    	
    	driver.quit();
    }




}
