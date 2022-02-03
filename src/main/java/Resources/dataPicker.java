package Resources;

import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageObjects.hotelSelectionPage;



   public class dataPicker 
   {
	   
	   private WebDriver driver;
	   hotelSelectionPage hotelSelectionPage;

	   public dataPicker(WebDriver driver, hotelSelectionPage hotelSelectionPage) 
	   {		
		this.driver = driver;
		this.hotelSelectionPage = hotelSelectionPage;
	   }	

		

	public void dateSelection(int day, WebElement field) throws InterruptedException {
		
	 
    	
//      This loop works fine but for some reason it can select the month for checkIn field only and fails for CheckPut field 
//    	dateFrame.findElement(By.className("switch")).click();
//    	System.out.println("this is after");
//    	
//    	List<WebElement> elements = driver.findElements(By.cssSelector("#fadein > div:nth-child(21) > div.datepicker-months > table > tbody > tr > td > .month"));
//
//		for (int i=0; i<elements.size();i++)	
//		{			
//
//			//Selecting the month
//				if(elements.get(i).getText().equals(month))
//				{ 
//					elements.get(i).click();
//				} 
//
//		}
    	
		//field.click();
		//Thread.sleep(1000);
		
		List<WebElement> days = driver.findElements(By.xpath("//tbody/tr/td[contains(@class, 'day')]"));
		
		for (int i=0; i<days.size();i++)
		{

				if(days.get(i).getText().equals(Integer.toString(day)))
				{ 
					days.get(i).click();
					break;
				} 
		}

	}	
	
	

}
