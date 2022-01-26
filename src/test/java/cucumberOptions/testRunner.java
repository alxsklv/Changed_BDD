package cucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)
@CucumberOptions(
		features = {
				   "src/test/java/features/LoginTo_FE.feature",
				   "src/test/java/features/Profile_GeneralCheck_FE.feature",
				   "src/test/java/features/ProfileChange_FE.feature",
				   "src/test/java/features/permissionChecks_FE.feature",
				   "src/test/java/features/selectBestHotel_FE.feature",	
				   
				   //it is important that checkNewHotel test comes after addNewHotel item
				   "src/test/java/features/addNewHotel_Supplier.feature",
				   "src/test/java/features/checkNewHotel_EN_and_FRS_FE.feature",
				   
				   //test to check basic functionality of CMS 
				   "src/test/java/features/basicChecks_CMS.feature",
				   
				   //E2E test to check SEO tags 
				   //this test includes tear-down step to remove added hotel to be able to reuse this test suite
				   "src/test/java/features/seo_E2E_CMS_and_FE.feature"				   
					},
		
		glue="stepDefinitions",
		stepNotifications = true
		)
public class testRunner {

}
