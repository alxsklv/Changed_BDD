package stepDefinitions;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Resources.baseResources;


import io.cucumber.java.en.When;
import pageObjects.hotelDetailsPage_FE;

public class stepDefinition_tagsCheck_FE extends baseResources {
	
    @When("^List of tags for found hotel is extracted and compared against the list from CMS$")
    public void list_of_tags_extracted() throws Throwable {
        
    	hotelDetailsPage_FE h = new hotelDetailsPage_FE(driver);
    	
    	//going to details page of the hotel
    	//this is the section that contains the list of the tags added via SEO in CMS
    	h.detailsButton().click();
    	
    	//getting all "#" and converting to list of strings
    	List<WebElement> seoTags= driver.findElements(By.tagName("a"));
    	List<String> stringSeoTags = new ArrayList<String>();
    	for(WebElement e : seoTags){
    		stringSeoTags.add(e.getText());
    	}
    	
    	//rude way to check if all tags from CMS are present at FE
    	//TODO reuse CMS list of tags for comparison instead of hardcoding the list    	
    	List<String> cmsSeoTags = Arrays.asList("Close to city center", "Free transfer", "Smoke free", "Free cancelation");
    	
    	if (stringSeoTags.containsAll(cmsSeoTags)) {
    		Assert.assertTrue(true);
    	}
    	
    	else {
    		Assert.assertTrue(false, "Not all tags are found");
    	}  	   
    	
    	driver.quit();
    	
    }    


}
