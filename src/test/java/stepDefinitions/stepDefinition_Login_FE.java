package stepDefinitions;


import org.testng.Assert;

import Resources.baseResources;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.homePage;

import pageObjects.loginPage;

public class stepDefinition_Login_FE extends baseResources {
	
	@Given("^User is on FE login page$")
    public void user_is_on_fe_login_page() throws Throwable {
		//I did it using the file but could be also done through cucumbers parameterization 
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
    }

    @When("^User login into application with username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void user_login_into_application(String userName, String password) throws Throwable {
        
    	loginPage l = new loginPage(driver);
    	
    	l.enterEmail().sendKeys(userName);
    	l.enterPassword().sendKeys(password);
    	
    	l.clickLogin();
    }

    @Then("^Home page with proper \"([^\"]*)\" url is populated$")
    public void home_page_with_proper_something_url_is_populated(String valideURL) throws Throwable {
        
    	String currentURL = driver.getCurrentUrl();
    	
    	Assert.assertEquals(currentURL, valideURL);
    }

    @And("^Entered username \"([^\"]*)\" is displayed at the Landing Page near the Profile section$")
    public void entered_username_is_displayed(String userName) throws Throwable {
        
    	homePage h = new homePage(driver);
    	
    	String logedUserName = h.onSiterUsername().getText();
    	
    	Assert.assertEquals(logedUserName, userName);
        
        driver.quit();
    }
    	
    	
}	



