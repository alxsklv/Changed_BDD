package stepDefinitions;

import org.junit.runner.RunWith;
import org.testng.Assert;

import Resources.baseResources;
import Resources.lazyDriver;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.homePage;
import pageObjects.profilePage;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
public class stepDefinition_CheckIfAddedToProfile extends baseResources {

	lazyDriver driver;
	homePage homePage;
	profilePage profilePage;

	public stepDefinition_CheckIfAddedToProfile(homePage homePage, lazyDriver driver, profilePage profilePage) {
		
		this.homePage = homePage;
		this.driver = driver;
		this.profilePage = profilePage;
		
	}

    @When("^User selects My Bookings tab$")
    public void user_selects_my_bookings_tab() throws Throwable {
    	
    	homePage.bookingsTab().click();
       
    }

    @Then("^User see his booking in My Booking list$")
    public void user_see_his_booking_in_my_booking_list() throws Throwable {
    	
    	
    	//This site does not allow to add any hotel (it fails on last step when Booking any) so we always have No Results found    	
    	Thread.sleep(1000);
    	String message = profilePage.myBookingMessage().getText();
    	
    	if (message.contains("No Results")) {
    		Assert.assertTrue(false,"Website is broken and we always have bookings list empty");
    	}
    	
    	else {
    		Assert.assertTrue(true,"Suprisingly, we have some hotel booked");
    	}

    }

}
