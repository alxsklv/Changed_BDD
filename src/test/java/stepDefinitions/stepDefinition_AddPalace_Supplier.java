package stepDefinitions;

import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;

import org.testng.Assert;

import Resources.baseResources;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.supplierLoginPage;
import pageObjects.supplierMainElements;

public class stepDefinition_AddPalace_Supplier extends baseResources {

	
    @Given("^User is on login page of supplier \"([^\"]*)\"$")
    public void user_is_on_supplier_login_page(String urlSupplier) throws Throwable {
    	{
    		//here I use Cucumber for parameterization but data.properties could be also used instead
    		driver = initializeDriver();
    		driver.get(urlSupplier); 
    	}
    }
    
    @And("^User performs login to environment using valid user \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void user_performs_login_to_environment(String userName, String password) throws Throwable {
		supplierLoginPage l = new supplierLoginPage(driver);
		l.enterEmail().sendKeys(userName);
		l.enterPassword().sendKeys(password);
		l.clickLogin().click(); 
    }
    
    @And("^User selects Add New Hotel section to add new MM hotel$")
    public void user_selects_add_new_hotel_section_to_add_new_mm_hotel() throws Throwable {
        supplierMainElements m = new supplierMainElements(driver);
        m.addHotel().click();
        
		String URL = driver.getCurrentUrl();
		Assert.assertTrue(URL.contains("/addHotel"));
    }

    @When("^BE User enters all hotel parameters for the new \"([^\"]*)\" hotel and hits Save$")
    public void user_enters_parameters_and_save(String hotelName) throws Throwable {
    	
    	supplierMainElements s = new supplierMainElements(driver);
    	
        //Entering Hotel Name
    	s.hotelNameField().sendKeys(hotelName);
    	
    	//assuming that facilities could be selected using drop-down list
    	Select dropOptions =  new Select(s.facilitiesDrop());    	
    	dropOptions.selectByVisibleText("Bar");
    	dropOptions.selectByVisibleText("Computer facility");
    	dropOptions.selectByVisibleText("Conference and meeting facilities");
    	dropOptions.selectByVisibleText("Disabled room");
    	dropOptions.selectByVisibleText("Fitness room");
    	dropOptions.selectByVisibleText("Health club");
    	
    	//populating changes 
    	s.addHotel().click();
    	
    	//all facilities available in drop-down
    	/*
    	Bar
    	Computer facility
    	Conference and meeting facilities
    	Disabled room
    	Fitness room
    	Health club
    	Laundry service 
    	 */
    }

    @Then("^New hotel gets populated with \"([^\"]*)\" message$")
    public void new_hotel_gets_populated_with_something_message(String shouldBeMessage) throws Throwable {
        
    	String message = driver.findElement(By.className("message")).getText();
        Assert.assertEquals(message, shouldBeMessage);
    }

    @And("^The \"([^\"]*)\" option is absent in the list of facilities$")
    public void option_is_absent_in_the_list(String invalidOption) throws Throwable {
        
    	//assuming that after 'Save' we can see the details page of the new hotel
    	//all facilities are shown as a table and added facilities are in the first column
    	
    		
    	List<WebElement> valuesFromTable = driver.findElements(By.xpath(".tableHead tb:nth-child(1)"));		
    		
    	for (int i=0; i<valuesFromTable.size(); i++)
    	{
    		String singleValue = valuesFromTable.get(i).getText();
    		
    		if (singleValue.equals(invalidOption)) 
    		{
    			Assert.assertTrue(false, "This option should not be selected!");
    		}
    		else
    		{
    			Assert.assertTrue(true);
    		}
    		
    	}
    	
    	driver.quit();
    	
    }



}
