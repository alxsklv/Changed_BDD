package stepDefinitions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import Resources.baseResources;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.hotelDetailsPage_CMS;
import pageObjects.seoDetailsPage;

public class stepDefinition_settingSEOtags extends baseResources {

    
	@And("^Goes to SEO tab by clicking on it$")
    public void goes_to_seo_tab_by_clicking_on_it() throws Throwable {
        
		hotelDetailsPage_CMS h = new hotelDetailsPage_CMS(driver);
		h.seoTab().click();
    }
	
    @And("^Add some tags using dropdown$")
    public void add_some_tags_using_dropdown() throws Throwable {
    	
    	seoDetailsPage d = new seoDetailsPage(driver);
        
    	Select dropOptions =  new Select(d.tagSelection());    	
    	dropOptions.selectByVisibleText("Close to city center");
    	dropOptions.selectByVisibleText("Free transfer");
    	dropOptions.selectByVisibleText("Smoke free");
    	dropOptions.selectByVisibleText("Free cancelation");    	

    }
    
    @When("^Admin hits Save button$")
    public void admin_hits_save_button() throws Throwable {
        
    	seoDetailsPage d = new seoDetailsPage(driver);
    	d.saveButton().click();
    }
    
	
    @Then("^The \"([^\"]*)\" pop-up message is shown$")
    public void popup_message_is_shown(String correctMessage) throws Throwable {
        
    	Alert alert = driver.switchTo().alert();
    	String alertMessage= alert.getText();
    	
    	Assert.assertEquals(alertMessage, correctMessage);
    	
    	driver.quit();
    }


}
