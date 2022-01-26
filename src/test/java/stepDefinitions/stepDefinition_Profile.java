package stepDefinitions;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Resources.baseResources;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.homePage;
import pageObjects.profilePage;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
public class stepDefinition_Profile extends baseResources {


    @When("^User has clicked on Profile button$")
    public void user_has_clicked_on_profile_button() throws Throwable {
    	homePage h = new homePage(driver);
    	h.profileButtonIcon().click();
    }

    @Then("^Profile page is opened and its url is \"([^\"]*)\"$")
    public void profile_page_is_opened_and_its_url_is_something(String validURL) throws Throwable {
    	WebDriverWait wait = new WebDriverWait(driver,30);
    	//added Explicit wait to make sure that the profile page is fully uploaded
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Edit Profile')]")));
		String URL = driver.getCurrentUrl();
		Assert.assertTrue(URL.contains(validURL));
    }

    @And("^Valid userdata is present on the page \"([^\"]*)\" username and \"([^\"]*)\" title$")
    public void valid_data_is_present_on_the_page(String userName, String titleText) throws Throwable {
        
    	profilePage p = new profilePage(driver);
        
    	String titleFromPage = p.staticProfileText().getText();
        String profileUserFromPage = p.profileUser().getText();
		
        Assert.assertEquals(titleFromPage, userName);
		Assert.assertEquals(profileUserFromPage, titleText);
		
		driver.quit();
    }

}