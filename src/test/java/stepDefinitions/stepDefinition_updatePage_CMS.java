package stepDefinitions;

import Resources.lazyDriver;
import Resources.scrollActions;
import io.cucumber.java.en.And;

import io.cucumber.java.en.When;


import org.openqa.selenium.Keys;

import pageObjects.adminPageCMS;
import pageObjects.loginPageCMS;
import pageObjects.pagesPageCMS;



public class stepDefinition_updatePage_CMS {
    lazyDriver driver;
    pagesPageCMS pagesPageCMS;
    loginPageCMS loginPageCMS;
    adminPageCMS adminPageCMS;
	public scrollActions actions;

    public stepDefinition_updatePage_CMS(lazyDriver driver,
                                         pagesPageCMS pagesPageCMS,
                                         pageObjects.loginPageCMS loginPageCMS,
                                         adminPageCMS adminPageCMS, 
                                         scrollActions actions
                                         ) 
    {
        this.driver = driver;		
        this.pagesPageCMS = pagesPageCMS;
        this.loginPageCMS = loginPageCMS;
        this.adminPageCMS = adminPageCMS;
        this.actions = actions;
    }



    @And("^User navigates on CMS > Pages page$")
    public void user_navigates_on_cms_pages_page() 
    {
        this.adminPageCMS.cmsMenu().click();
        this.adminPageCMS.pagesSubmenu().click();
    }

    @And("User clicks Edit button on first page in list")
    public void user_clicks_edit_button_on_first_page_in_list() throws InterruptedException 
    {
    	pagesPageCMS.firstPageInList().click();
    }

    @And("User sets page title to {string}")
    public void user_sets_page_title(String title) 
    {    	
    	pagesPageCMS.pageTitle().click();
    	pagesPageCMS.pageTitle().sendKeys(Keys.chord(Keys.CONTROL, "a"));
    	pagesPageCMS.pageTitle().sendKeys(title);    	
    }


    @And("^User sets permalink to \"([^\"]*)\"$")
    public void user_sets_permalink_to_something(String permalink) throws InterruptedException 
    {
    	pagesPageCMS.permaLink().click();
    	Thread.sleep(1000);
    	pagesPageCMS.permaLink().sendKeys(Keys.chord(Keys.CONTROL, "a"));
    	pagesPageCMS.permaLink().sendKeys(permalink);
    }

    @And("User sets description to {string}")
    public void user_sets_description(String description) throws InterruptedException 
    {
    	driver.switchTo().frame(0);
    	pagesPageCMS.descriptionField().sendKeys(Keys.chord(Keys.CONTROL, "a"));
    	pagesPageCMS.descriptionField().sendKeys(description);
    	driver.switchTo().defaultContent();
    }

    @And("User sets SEO keywords to {string}")
    public void user_sets_seo_keywords(String seoKeyword) throws InterruptedException 
    {
 //   	driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
    	actions.scrollToElement(pagesPageCMS.seoKey()); //it is possible that Description content is huge and button is invisible. 
    	pagesPageCMS.seoKey().sendKeys(Keys.chord(Keys.CONTROL, "a")); 
    	pagesPageCMS.seoKey().sendKeys(seoKeyword);
    }

    @And("User sets SEO description to {string}")
    public void user_sets_seo_description(String seoDescription) throws InterruptedException 
    {
    	pagesPageCMS.seoDescription().sendKeys(Keys.chord(Keys.CONTROL, "a"));
    	pagesPageCMS.seoDescription().sendKeys(seoDescription);
    }

    @When("Update button is clicked")
    public void update_button_is_clicked() throws InterruptedException 
    {
    	pagesPageCMS.submitChanges().click();
    }

}
