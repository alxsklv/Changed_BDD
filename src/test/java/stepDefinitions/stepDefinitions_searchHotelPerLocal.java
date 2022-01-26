package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Resources.baseResources;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageObjects.hotelSelectionPage;
import pageObjects.profilePage;

public class stepDefinitions_searchHotelPerLocal extends baseResources{
	
	@Given("User is on login page")
	public void user_is_on_login_page() throws IOException 
	{
		//this file reader feature is done on purpose just to show that I can also do it like this
		//However, parameterization could be done through the Cucumbers features file instead
		driver = initializeDriver();
		driver.get(prop.getProperty("url")); 
	}

    @Then("^User hits Search button$")
    public void they_hits_search_button() throws Throwable {
    	
    	hotelSelectionPage s = new hotelSelectionPage(driver); 
    	
    	//scroll to very bottom of the page where Apply button is located
    	driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
    	s.applyButton().click();
    	
    	WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("//div[contains(text(),'Hotel is found')]")));
    }


    @And("^Purchase a hotel from search results$")
    public void purchase_a_hotel_from_search_results() throws Throwable {
        
    	//Assuming that only one 'Forest' hotel was found after all filters were applied
    	driver.findElement(By.cssSelector("#ForestHotel")).click();
    	Thread.sleep(2000);
    	driver.findElement(By.cssSelector("#purchase")).click();
    	
    	String hotelBooked = driver.findElement(By.cssSelector("#bookedMessage")).getText();
    	Assert.assertEquals(hotelBooked, "Booking was added to your profile");
    }

    @And("^Checks the profile to see that the hotel is booked$")
    public void check_the_profile_to_see_that_the_hotel_is_booked() throws Throwable {
        
    	profilePage p = new profilePage(driver); 
    	p.myBookings().click();
    	Thread.sleep(2000);
    	
    	//checking that the hotel is present in Booking section of the Profile page
    	String hotelName = driver.findElement(By.xpath("//*[text()='Forest Hotel']")).getText();
    	Assert.assertTrue(hotelName.contains("Forest Hotel"));    	
    	
    }

}

