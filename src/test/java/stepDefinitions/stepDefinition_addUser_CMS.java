package stepDefinitions;

import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;


import org.testng.Assert;

import Resources.baseResources;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.cmsLoginPage;
import pageObjects.cmsMainPage;
import pageObjects.userDetailsPage;

public class stepDefinition_addUser_CMS extends baseResources {

	
    @Given("^User is on login page of CMS environment \"([^\"]*)\"$")
    public void user_is_on_login_page_of_cms(String urlCMS) throws Throwable {
    	{
    		//here I use Cucumber for parameterization but data.properties could be also used instead
    		driver = initializeDriver();
    		driver.get(urlCMS); 
    	}
    }
    
    @And("^User performs login to CMS using valid user \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void user_performs_login_to_cms_with_credentials(String userName, String password) throws Throwable {
		cmsLoginPage c = new cmsLoginPage(driver);
		c.enterEmail().sendKeys(userName);
		c.enterPassword().sendKeys(password);
		c.clickLogin().click(); 
    }
    
    @And("^Admin selects User section$")
    public void admin_selects_user_tab() throws Throwable {
        cmsMainPage m = new cmsMainPage(driver);
        m.usersTab().click();
        
		String URL = driver.getCurrentUrl();
		Assert.assertTrue(URL.contains("/users"));
    }
    
    @And("^Click on Add New User button$")
    public void click_on_add_button() throws Throwable {
    	
    	userDetailsPage u = new userDetailsPage(driver);
    	u.addNewUser().click();
    	
    }
    
    @When("^All fields (.+) (.+) (.+) (.+) are filled with data$")
    public void all_fields_are_filled_with_data(String username, String userpassword, String useremail, String birthday) throws Throwable {
    	
    	userDetailsPage u = new userDetailsPage(driver);
    	
    	u.userName().sendKeys(username);
    	u.userPassword().sendKeys(userpassword);
    	u.userEmail().sendKeys(useremail);
    	u.birthday().sendKeys(birthday);    	

    }
    
    @Then("^Admin hits Save button to populate new user$")
    public void admin_hits_save() throws Throwable {
        
    	userDetailsPage u = new userDetailsPage(driver);
    	u.saveButton().click();
    }


    @And("^Checks that the new User was added to the list of users by checking userName \"([^\"]*)\" and userEmail \"([^\"]*)\" values$")
    public void checks_that_the_new_user_was_added(String controlName, String controlEmail) throws Throwable {
        
    	
    	//After user was saved, we can see the table with all available users
    	//We are checking two different columns to make sure that our user is added
    	//first we check User Name column to find the name of our user
    
    	List<WebElement> usersFromTable = driver.findElements(By.xpath(".tableHead tb:nth-child(1)"));		
		
    	for (int i=0; i<usersFromTable.size(); i++)
    	{
    		String singleValue = usersFromTable.get(i).getText();
    		
    		if (singleValue.equals(controlName)) 
    		{
    			Assert.assertTrue(true, "User was found");
    		}
    		else
    		{
    			Assert.assertTrue(false, "User is absent");
    		}
    		
    	}
    	
    	//here we check the same table but second column to find the email record in corresponding column
    	List<WebElement> emailFromTable = driver.findElements(By.xpath(".tableHead tb:nth-child(2)"));		
    	for (int i=0; i<emailFromTable.size(); i++)
    	{
    		String singleValue = emailFromTable.get(i).getText();
    		
    		if (singleValue.equals(controlEmail)) 
    		{
    			Assert.assertTrue(true, "Email was found");
    		}
    		else
    		{
    			Assert.assertTrue(false, "User is absent");
    		}
    		
    	}
    	
    	driver.quit();
    } 

}
