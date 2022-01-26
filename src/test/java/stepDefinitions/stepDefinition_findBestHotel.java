package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Resources.baseResources;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.homePage;
import pageObjects.hotelSelectionPage;
import pageObjects.profilePage;

public class stepDefinition_findBestHotel extends baseResources{
	
	@Given("^User selects Hotels tab$")
    public void user_selects_hotels_tab() throws Throwable {
		
        homePage h = new homePage(driver);
        
        h.hotelsTab().click();        
        
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#findYourHotel")));
    }

    @When("^User selects all necessary filters$")
    public void user_selects_all_necessary_filters() throws Throwable {
    	hotelSelectionPage s = new hotelSelectionPage(driver); 
    	
    	s.cityName().sendKeys("Tokio");
    	s.peopleAmount().sendKeys("1");
    	s.filtersExpand().click();
    	
    	
    	//select checkbox for price range filter and check if it is selected
    	s.priceFilter_between_50_and_100().click();
    	Assert.assertTrue(s.priceFilter_between_50_and_100().isSelected());
    	
    	//next checkbox is not visible by default so scrolling is required
    	//after element is visible - select its checkbox 
    	WebElement buildingVilla = s.buildingType_Villa();
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", buildingVilla);
    	Thread.sleep(500);
    	buildingVilla.click();
    	Assert.assertTrue(buildingVilla.isSelected());
    	
    	s.starRating_5().click();
    	Assert.assertTrue(s.starRating_5().isSelected());
    	
    	//scroll to district section and select city Center checkbox 
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", s.district_Center());
    	Thread.sleep(500);
    	s.district_Center().click();    	
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
    	
    	driver.quit();
    	
    }

}
