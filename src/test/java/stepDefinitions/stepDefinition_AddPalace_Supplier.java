package stepDefinitions;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import org.testng.Assert;

import Resources.baseResources;
import Resources.lazyDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.supplierMainElements;
import pageObjects.hotelDetailsPageAdmin;



public class stepDefinition_AddPalace_Supplier extends baseResources {
	lazyDriver driver;
	supplierMainElements supplierMainElements;
	hotelDetailsPageAdmin hotelDetailsPageAdmin;

	
	public stepDefinition_AddPalace_Supplier(lazyDriver driver, supplierMainElements supplierMainElements, hotelDetailsPageAdmin hotelDetailsPageAdmin) {
		
		this.driver = driver;
		this.supplierMainElements = supplierMainElements;	
		this.hotelDetailsPageAdmin = hotelDetailsPageAdmin;
	}
	

    
    @And("^User selects Manage Hotels subsection of Hotels section$")
    public void user_selects_manage_hotels_subsection_of_hotels_section() throws Throwable {

    	supplierMainElements.hotelsParentTab().click();
    	supplierMainElements.subHotelItem().click();
    	supplierMainElements.manageHotels().click();   	 	
    	
    }
    
    @And("^User clicks on Add button to start with the creation of new Hotel$")
    public void user_clicks_on_add_button() throws Throwable {
       
    	supplierMainElements.addHotelButton().click();
    	
    	//This is just temp code to show that API call is correct. However, BE page is broken by itself
    	//THis code should be removed as soon as the functionality to add a hotel is back 
    	//All next methods of this class are for TTD and should be slightly changed later 
    	Thread.sleep(1000);
    	String currentUrl = driver.getCurrentUrl();    	
    	assertEquals("https://phptravels.net/api/supplier/hotels/add", currentUrl);          
    }
    
    @And("^Admin fills all parameters (.+) (.+) (.+)  for General Tab$")
    public void admin_fills_all_parameters_for_general_tab(String hotelname, String description, String price) throws Throwable {
        
    	//there should be more fields for General tab
    	hotelDetailsPageAdmin.hotelNameAdmin().sendKeys(hotelname);
    	
    	//I observed that description is an iFrame thing
    	driver.switchTo().frame(0);
    	hotelDetailsPageAdmin.descriptionBox().sendKeys(description);
    	driver.switchTo().defaultContent();
    	
    	hotelDetailsPageAdmin.priceHotelAdmin().sendKeys(price);    	
    	
    }
    
    @And("^Checks all parameters of Amenties tab except for \"([^\"]*)\"$")    
    public void checks_all_parameters(String uncheckOption) throws Throwable {
        
    	//Amenities are different for Hotels but I used amenities for Rooms 
    	//Assuming that we have something very similar for Hotels and mechanic will be the same
    	hotelDetailsPageAdmin.amentiesTab().click();
    	
    	List<WebElement> valuesAmenties = driver.findElements(By.xpath("//*[@class='col-md-6']//*[@class='pointer']"));
    	
    	for (int i=0; i<valuesAmenties.size(); i++)
        	{
        		String singleValue = valuesAmenties.get(i).getText();
        		
        		if (singleValue.contains(uncheckOption)) 
        		{
        			continue;
        		}
        		else
        		{
        			valuesAmenties.get(i).click();
        		}
        		
        	}   	
    	
    }
    
    @And("^Enters (.+) for Translate Tab$")
    public void enters_for_translate_tab(String germanDescription) throws Throwable {
        
    	hotelDetailsPageAdmin.translateTab().click();
    	
    	//it should be the iFrame 
    	driver.switchTo().frame(0);
    	hotelDetailsPageAdmin.descriptionBoxGerman().sendKeys(germanDescription);
    	driver.switchTo().defaultContent();
    }
    
    @When("^Admin hits submit button$")
    public void admin_hits_submit_button() throws Throwable {
    	
    	driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
    	hotelDetailsPageAdmin.submitButton().click();

    }
    
    @Then("^New hotel with the (.+) appears in the list of Hotels$")
    public void new_hotel_with_the_appears_in_the_list_of_hotels(String hotelname) throws Throwable {

    	hotelDetailsPageAdmin.hotelListContainer().isEnabled();
    	
    	//getting all the names of the hotel from the list and checking if our new hotel is present
    	List<WebElement> valuesHotels = driver.findElements(By.xpath("//*[@class='col-md-6']//*[@class='pointer']"));
    	
    	for (int i=0; i<valuesHotels.size(); i++)
        	{
        		String singleHotel = valuesHotels.get(i).getText();
        		
        		if (singleHotel.contains(hotelname)) 
        		{
        			Assert.assertTrue(true);
        		}
        		else
        		{
        			Assert.assertTrue(false,"Hotel is absent in the list");
        		}
        		
        	}  	
    	
    }
}
    	


