package stepDefinitions;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Resources.baseResources;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pageObjects.profilePage;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
public class stepDefinition_ProfileChange extends baseResources {


    @When("^User click on Edit and enter new values to username \"([^\"]*)\" and email \"([^\"]*)\" fileds and click Update$")
    public void user_click_on_edit_and_enter_new_values_and_update(String newUsername, String newEmail) throws Throwable {
        profilePage p = new profilePage(driver);
        p.editProfile().click(); 
        
        p.emailField().sendKeys(Keys.CONTROL+"A");
        p.emailField().sendKeys(newEmail);
        
        p.userField().clear();
        p.userField().sendKeys(newUsername);
        
        p.saveProfile().click();
        
    }

    @Then("^corresponding fields get new \"([^\"]*)\" and \"([^\"]*)\" values$")
    public void fields_get_new_values(String newUsername, String newEmail) throws Throwable {
    	
    	profilePage p = new profilePage(driver);    	
    	WebDriverWait wait = new WebDriverWait(driver,30);
    	
    	//wait until all changes got populated
    	//prevents from grabbing the old values 
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Changes are populated')]")));
    	
    	String changedEmail = p.emailField().getText();
    	String changedUsername = p.userField().getText();
		
    	Assert.assertEquals(changedEmail, newUsername);
		Assert.assertEquals(changedUsername, newEmail);
    }

    @And("^\"([^\"]*)\" message is shown to user$")
    public void something_message_is_shown_to_user(String expectedMessage) throws Throwable {
    	
    	String successMessage = driver.findElement(By.xpath("//div[contains(text(),'Changes are populated')]")).getText();
		Assert.assertEquals(expectedMessage, successMessage);
		
		driver.quit();
    	
    }

}