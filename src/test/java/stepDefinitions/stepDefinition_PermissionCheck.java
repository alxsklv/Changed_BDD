package stepDefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


import Resources.baseResources;
import Resources.lazyDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.loginPageCMS;


public class stepDefinition_PermissionCheck extends baseResources {

	lazyDriver driver;
	loginPageCMS loginPageCMS;

	
	public stepDefinition_PermissionCheck(lazyDriver driver, loginPageCMS loginPageCMS) {
		
		this.driver = driver;
		this.loginPageCMS = loginPageCMS;	
	}	

	

    @Given("^User is on (.+) login page$")
    public void user_is_on_CMS_login_page(String url) throws Throwable {
    	
    	driver.getDelegate().get(url);
        
    }
    
    @When("^User login into environment with username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void user_login_into_cms_with_credentials(String username, String password) throws Throwable {

    	loginPageCMS.emailInputCMS().sendKeys(username);
    	loginPageCMS.passwordInputCMS().sendKeys(password);
    	loginPageCMS.loginButtonCMS().click();  
    	Thread.sleep(1000);
    	
    }
    
    @Then("^User receives error message \"([^\"]*)\"$")
    public void user_receives_error_message(String messageToCompare) throws Throwable {
		
    	String currentMessage = loginPageCMS.alertMessage().getText();    	 	
    	assertTrue(currentMessage.contains(messageToCompare));
    	
    }
    
    @And("^Stays on the page with the same URL (.+)$")
    public void stays_on_the_page_with_the_same_url(String urlF) throws Throwable {
        
    	String currentUrl = driver.getCurrentUrl();
    	assertEquals(urlF, currentUrl);
    }
	
}


