package stepDefinitions;


import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Resources.baseResources;
import Resources.lazyDriver;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.homePage;

import pageObjects.loginPage;

public class stepDefinition_Login_FE extends baseResources {
	
	lazyDriver driver;
	loginPage loginPage;
	homePage homePage;

	public stepDefinition_Login_FE(lazyDriver driver, loginPage loginPage, homePage homePage) {
		
		this.driver = driver;
		this.loginPage = loginPage;
		this.homePage = homePage;
		
	}

    @Given("^User is on FE login page \"([^\"]*)\" and login$")
    public void user_is_on_fe_login_page(String url) throws Throwable {
		
    	driver.getDelegate().get(url);
		loginPage.loginButton().click();	
		
    }

	@And("^User login into application with username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void user_login_into_application(String userName, String password) throws Throwable {
        
    	
    	loginPage.enterEmail().sendKeys(userName);
    	loginPage.enterPassword().sendKeys(password);
    	
    	Actions actions = new Actions(driver);
    	actions.moveToElement(loginPage.clickLogin());
    	actions.perform();    	
    	loginPage.clickLogin().click();
    	
    }

    @When("^Home page with proper \"([^\"]*)\" url is populated$")
    public void home_page_with_proper_something_url_is_populated(String valideURL) throws Throwable {
        
    	String currentURL = driver.getCurrentUrl();
    	
    	Assert.assertEquals(currentURL, valideURL);
    }

    @Then("^Username \"([^\"]*)\" is displayed at the Landing Page near the Profile section$")
    public void entered_username_is_displayed(String userName) throws Throwable {
    	
    	String logedUserName = homePage.onSiterUsername().getText();
    	
    	Assert.assertEquals(logedUserName, userName);         	
        
    }   

    	
}	



