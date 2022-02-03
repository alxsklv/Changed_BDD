package stepDefinitions;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Resources.baseResources;
import Resources.lazyDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pageObjects.profilePage;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
public class stepDefinition_ProfileChange extends baseResources {
	
	lazyDriver driver;
	profilePage profilePage;

	public stepDefinition_ProfileChange(lazyDriver driver, profilePage profilePage) {
		
		this.driver = driver;
		this.profilePage = profilePage;
	}
	
	
    @When("^User click on Edit and enter new values to username \"([^\"]*)\" and phone \"([^\"]*)\" fileds and click Update$")
    public void user_click_on_edit_and_enter_new_values_and_update(String newUsername, String newEmail) throws Throwable {
        
    	profilePage.phoneField().sendKeys(Keys.CONTROL+"A");
    	profilePage.phoneField().sendKeys(newEmail);
        
    	profilePage.profileUser().clear();
    	profilePage.profileUser().sendKeys(newUsername);
        
    	profilePage.profileUser().sendKeys(Keys.ENTER);
    	
    	//This is proper way to get to Update element but for some reason it stopped working for the website (was working before)
//    	Actions actions = new Actions(driver);
//    	actions.moveToElement(profilePage.saveProfile());
//    	actions.perform();
//   	profilePage.saveProfile().click();

        
    }

    @Then("^corresponding fields get new \"([^\"]*)\" and \"([^\"]*)\" values$")
    public void fields_get_new_values(String newUsername, String newPhone) throws Throwable {
    	
    	
    	String changedPhone = profilePage.phoneField().getAttribute("value");
    	String changedUsername = profilePage.profileUser().getAttribute("value");
		
    	Assert.assertEquals(changedPhone, newPhone);
		Assert.assertEquals(changedUsername, newUsername);
    }

    @And("^\"([^\"]*)\" message is shown to user$")
    public void something_message_is_shown_to_user(String expectedMessage) throws Throwable {
    	
    	profilePage.successMessage().isDisplayed();
    	String successMessage = profilePage.successMessage().getText();    	    	
		Assert.assertTrue(successMessage.contains(expectedMessage));
    	
    }

}