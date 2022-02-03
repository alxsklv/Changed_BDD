package stepDefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Resources.lazyDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pageObjects.pageEdited_FE;




public class stepDefinition_UpdatedModuleCheck_FE {
    lazyDriver driver;
    pageEdited_FE pageEdited_FE;


    public stepDefinition_UpdatedModuleCheck_FE(lazyDriver driver, pageEdited_FE pageEdited_FE) 
    {
        this.driver = driver;		
        this.pageEdited_FE = pageEdited_FE;

    }


    @When("^Page is loaded$")
    public void page_is_loaded() throws Throwable {
    	String URL = driver.getCurrentUrl();
    	Assert.assertEquals(URL, "https://phptravels.net/cookies-policy");  //TODO remove hardocding and put variable defined through feature file 
    }

    @Then("User can see {string}, {string} on page")
    
    public void user_can_see_on_page(String titleCMS, String descriptionCMS) {
    	
    	String newTitle = pageEdited_FE.updatedTitle().getText();
    	String newDescription = pageEdited_FE.updatedDescription().getText();
    	
    	Assert.assertEquals(newTitle, titleCMS);
    	Assert.assertEquals(newDescription, descriptionCMS);
    	
    }

    @And("SEO keyword {string} and SEO description {string} are presented on page")
    public void seo_keyword_and_seo_description_are_presented_on_page(String seoKeyword, String seoDescription) {
    	
    	//TDD it should be something like this but SEO tags are always static at FE do it will not work 
    	List<WebElement> allSeoTags = driver.findElements((By) pageEdited_FE.seoTags());
    	
    	for (int i=0; i<allSeoTags.size(); i++)
        	{
        		String singleSEO = allSeoTags.get(i).getAttribute("content");
        		
        		if(singleSEO.contains("test_seo_keyword")) {
        			
        			Assert.assertTrue(true);
        		}
        		
        		else {
        			Assert.assertTrue(false, "We don't have our SEO tag from CMS");
        		}    	
    	
            }
    }
}
