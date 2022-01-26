package stepDefinitions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Resources.baseResources;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class stepDefinition_PermissionPerTab extends baseResources {

	@When("^User selects (.+) from navigation bar$")
    public void user_selects_about(String tabname) throws Throwable {
		driver.findElement(By.xpath("//div[contains(text(),'"+tabname+"')]")).click();
		
		//make sure that URL has changed
        WebDriverWait wait = new WebDriverWait(driver,30);
    	wait.until(ExpectedConditions.urlContains(tabname));    	
    		
    }

    @Then("^Page becomes available with (.+) title on it except for Membership$")
    public void about_page_becomes_available(String tabname) throws Throwable {	
    	
    	//checks if URL contains proper ending 
    	String URL = driver.getCurrentUrl();
		Assert.assertTrue(URL.contains(tabname));

		
		//most like, it was necessary to use 'But' in feature file and write separate test for
		//the case when access to the section should be blocked but I used 'if-else' instead to exclude separate test
		if (tabname.equals("Membership")) 
		{
			//lets imagine that we get some pop up when permission is denied 
			//we should check its text and accept it after
			Alert alert = driver.switchTo().alert();
			
			String deniedMessage = alert.getText();
			Assert.assertEquals(deniedMessage, "Access Denied");
			
			alert.accept();
		}
		
		else 
		{
		String currentPageTitle = driver.findElement(By.xpath("//div[contains(text(),'"+tabname+"')]")).getText();
		Assert.assertEquals(currentPageTitle, tabname);
		}
		
		driver.quit();
    }

}
