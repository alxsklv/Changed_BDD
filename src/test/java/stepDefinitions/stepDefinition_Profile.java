package stepDefinitions;

import org.junit.runner.RunWith;
import org.testng.Assert;

import Resources.baseResources;
import Resources.lazyDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.homePage;
import pageObjects.profilePage;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
public class stepDefinition_Profile extends baseResources {

	lazyDriver driver;
	homePage homePage;
	profilePage profilePage;

	public stepDefinition_Profile(homePage homePage, lazyDriver driver, profilePage profilePage) {
		
		this.homePage = homePage;
		this.driver = driver;
		this.profilePage = profilePage;
		
	}

    @When("^User has clicked on Profile button$")
    public void user_has_clicked_on_profile_button() throws Throwable {

    	homePage.profileButtonIcon().click();
    	
    }

    @Then("^Profile page is opened and its url is \"([^\"]*)\"$")
    public void profile_page_is_opened_and_its_url_is_something(String validURL) throws Throwable {

		String URL = driver.getCurrentUrl();
		Assert.assertTrue(URL.contains(validURL));
    }

    @And("^Valid userdata is present on the page \"([^\"]*)\" username and \"([^\"]*)\" title$")
    public void valid_data_is_present_on_the_page(String userName, String titleText) throws Throwable {
         
    	String titleFromPage = profilePage.staticProfileText().getText();		
    	
        String profileUserFromPage = profilePage.profileUser().getAttribute("value");
		
        Assert.assertEquals(titleFromPage, titleText);
		Assert.assertEquals(profileUserFromPage, userName);
		
    }

}