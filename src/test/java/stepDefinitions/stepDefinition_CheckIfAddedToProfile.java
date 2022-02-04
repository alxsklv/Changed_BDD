package stepDefinitions;

import org.junit.runner.RunWith;
import org.testng.Assert;

import Resources.baseResources;
import Resources.lazyDriver;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.homePage;
import pageObjects.hotelDetailsPage_FE;
import pageObjects.profilePage;
import io.cucumber.junit.Cucumber;


@RunWith(Cucumber.class)
public class stepDefinition_CheckIfAddedToProfile extends baseResources {

	lazyDriver driver;
	homePage homePage;
	profilePage profilePage;
	hotelDetailsPage_FE hotelDetailsPage_FE;

	public stepDefinition_CheckIfAddedToProfile(homePage homePage, lazyDriver driver, profilePage profilePage, hotelDetailsPage_FE hotelDetailsPage_FE) {
		
		this.homePage = homePage;
		this.driver = driver;
		this.profilePage = profilePage;
		this.hotelDetailsPage_FE = hotelDetailsPage_FE;
		
	}

    @When("^User selects My Bookings tab$")
    public void user_selects_my_bookings_tab() throws Throwable {
    	
    	homePage.bookingsTab().click();
    	profilePage.firstBookingInList().click();
       
    }

    @Then("^User see his booking in My Booking list$")
    public void user_see_his_booking_in_my_booking_list() throws Throwable {
    	
    	String nameOfHotel = hotelDetailsPage_FE.bookedHotelName().getText();    	
    	
    	if (nameOfHotel.contains("Rendezvous Hotels")) {
    		Assert.assertTrue(true,"Website is broken and we always have bookings list empty");
    	}
    	
    	else {
    		Assert.assertTrue(false,"Website is broken and we always have bookings list empty");
    	}

    }

}
