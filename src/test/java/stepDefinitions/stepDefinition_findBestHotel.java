package stepDefinitions;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Resources.baseResources;
import Resources.dataPicker;
import Resources.lazyDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.homePage;
import pageObjects.hotelSelectionPage;
import pageObjects.hotelDetailsPage_FE;
import pageObjects.profilePage;

public class stepDefinition_findBestHotel extends baseResources{
	
	lazyDriver driver;
	homePage homePage;
	hotelSelectionPage hotelSelectionPage;
	profilePage profilePage;
	dataPicker dataPicker;
	hotelDetailsPage_FE hotelDetailsPage_FE;

	
public stepDefinition_findBestHotel(homePage homePage, lazyDriver driver, profilePage profilePage, hotelSelectionPage hotelSelectionPage, dataPicker dataPicker, hotelDetailsPage_FE hotelDetailsPage_FE) {
		
		this.homePage = homePage;
		this.driver = driver;
		this.hotelSelectionPage = hotelSelectionPage;
		this.profilePage = profilePage;	
		this.dataPicker = dataPicker;
		this.hotelDetailsPage_FE = hotelDetailsPage_FE;
		
	}
	
	@Given("^User selects Hotels tab$")
    public void user_selects_hotels_tab() throws Throwable {		
        
		homePage.hotelsTab().click();  	

    }

    @When("^User selects all necessary filters and city is \"([^\"]*)\"$")
    public void user_selects_all_necessary_filters_something(String cityName) throws Throwable {
    	
    	hotelSelectionPage.cityName().click();
    	hotelSelectionPage.cityNameActive().sendKeys(cityName);  
    	Thread.sleep(1000);
    	hotelSelectionPage.foundHotel().click();

    	WebElement checkIn=hotelSelectionPage.checkIn();
    	WebElement checkOut=hotelSelectionPage.checkOut();    	

    	checkIn.click();
    	dataPicker.dateSelection(15, checkIn);
    	dataPicker.dateSelection(24, checkOut); 	    	
    		
    }

    @Then("^User hits Search button$")
    public void they_hits_search_button() throws Throwable {
    	
    	hotelSelectionPage.searchButton().click();

    }


    @And("^User sets star grade to two stars and click on Details$")
    public void user_sets_star_grade_to_two_stars() throws Throwable {

    	hotelDetailsPage_FE.twoStars().click();    	
    	hotelDetailsPage_FE.detailsButton().click();    	

    }

    @And("^User books cheapest Triple rooms option from the details page$")
    public void user_books_cheapest_option() throws Throwable {
    	
    	hotelDetailsPage_FE.cookiesBanner().click();
    	hotelDetailsPage_FE.bookNow().click();    	

    }

    @And("^User fills in travellers data, payment method, accept terms and confirm booking$")
    public void user_fills_in_travellers_data_payment_method_accept_terms_and_confirm_booking() throws Throwable {
    	
    	hotelDetailsPage_FE.firstName_1().sendKeys("Alex");
    	hotelDetailsPage_FE.lastName_1().sendKeys("QA");
    	hotelDetailsPage_FE.firstName_2().sendKeys("Tom");
    	hotelDetailsPage_FE.lastName_2().sendKeys("Black");
    	
    	hotelDetailsPage_FE.paymentMethod().click();    	
    	
    	driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
    	Thread.sleep(1000);
    	
    	hotelDetailsPage_FE.termsCheck().click();
    	hotelDetailsPage_FE.confirmBooking().click();
    	
    	Thread.sleep(1000);
    	String confirmationMessage = hotelDetailsPage_FE.confirmationMessage().getText(); 
    	
    	if (confirmationMessage.equals("Invoice ID or Number is Wrong!")) {
    		Assert.assertTrue(false,"This means that website is broken and does not allow to add hotel to Profile (this is the most possible option as I always see this message");
    	}
    	
    	else {
    		Assert.assertTrue(true,"Suprisingly, this function is working and hotel was booked");
    	}
    	

    }
    
    @And("^User sets language to (.+)$")
    public void user_sets_language_to(String language) throws Throwable {
        
    	hotelSelectionPage.localsButton().click();
    	Thread.sleep(3000);
    	
    	
    	
    	List<WebElement> languagesAll = driver.findElements(By.xpath("//*[@class='dropdown']//*[@aria-labelledby='languages']/li/a"));
    	
    	for (int i=0; i<languagesAll.size(); i++)
        	{
        		String singleLanguage = languagesAll.get(i).getText();

        		
        		if (singleLanguage.contains(language)) 
        		{
        			System.out.println(languagesAll.get(i).getText());
        		
        			languagesAll.get(i).click();  
        	    	Thread.sleep(1000);
        	    	break;
 
        		}
        		else
        		{
        			continue;
        		}
        		
        	}  
    }

}
