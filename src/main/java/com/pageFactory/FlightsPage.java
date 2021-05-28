package com.pageFactory;





import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.generic.BaseTest;

import com.generic.Wrapper_Function;

public class FlightsPage {
	WebDriver driver;
	
	
	By loc_txt_enterCity_From=By.xpath("//input[@id='FromTag']");
	By loc_lnk_selectCity=By.tagName("li");
	By loc_txt_enterCity_To=By.xpath("//input[@id='ToTag']");
	By loc_inp_departDate=By.xpath("//input[@title='Depart date']");
	By loc_inp_returnDate=By.xpath("//input[@id='ReturnDate']/following::a[@class='calendarIcon']/i[text()='Cal']");
	By loc_lnk_selectDate=By.xpath("//td[@data-year='2021']");
	By loc_drp_adultDropDown=By.id("Adults");
	By loc_btn_searchFlights=By.xpath("//input[@id='SearchBtn']");
	Wrapper_Function objWrapper_Function=PageFactory.initElements(BaseTest.driver, Wrapper_Function.class);
	
	
	public FlightsPage(WebDriver driver){
		this.driver=driver;
	}
	
	public void commonSelectRadioButtonTripType(String strTripType){
		By loc_rbTripType_RoundTrip=By.xpath("//strong[text()='"+strTripType+"']/preceding-sibling::input[1]");
		driver.findElement(loc_rbTripType_RoundTrip).click();
	}
    
	public void enterDepartureCity(){
	    
        String strActualCityName="Mumbai, IN - Chatrapati Shivaji Airport (BOM)";
        WebElement departCity=driver.findElement(loc_txt_enterCity_From);
        departCity.sendKeys("Mumbai");
        departCity.sendKeys(Keys.ENTER);
        objWrapper_Function.selectCity(loc_lnk_selectCity, strActualCityName);

        objWrapper_Function.setImplicitwait(10);
    }

	public void enterDestinationCity(){
		
		   String strActualCityName="New Delhi, IN - Indira Gandhi Airport (DEL)";
	        WebElement destinationCity=driver.findElement(loc_txt_enterCity_To);
	        destinationCity.sendKeys("Delhi");
	        destinationCity.sendKeys(Keys.ENTER);
	        objWrapper_Function.selectCity(loc_lnk_selectCity, strActualCityName);
	      
	        objWrapper_Function.setImplicitwait(10);
	}
	
	public void toSelectDepartureDate() {
 	    driver.findElement(loc_inp_departDate).click();
    	objWrapper_Function.selectDate(loc_lnk_selectDate, 30);
   	
    	
	}
	 
	public void toSelectArrivalDate(){
		driver.findElement(loc_inp_returnDate).click();

		objWrapper_Function.selectDate(loc_lnk_selectDate, 1);
	
		
	}
	
	
	/*public void toSelectDepartAndReturnDate(String strDate){
		 driver.findElement(loc_inp_departDate).click();
		 List<WebElement> departureDate=driver.findElements(loc_lnk_selectDate);
		 
		 for (int i = 0; i < departureDate.size(); i++) {
			 if(i<5){
				 continue;
				 }
			 else{
				 strDate=departureDate.get(i).getText();
				 departureDate.get(i).click();
				 break;
			 }
			
		}
		 driver.findElement(loc_inp_returnDate).click();
		 List<WebElement> returnDate=driver.findElements(loc_lnk_selectDate);
		 for (int i = 0; i < returnDate.size(); i++) {
			 if(i<1){
				 continue;
				 }
			 else{
				 strDate=returnDate.get(i).getText();
				 returnDate.get(i).click();
				 break;
			 }
			
		}
		 objWrapper_Function.setImplicitwait(10);
	}*/
	
	public void toSelectAdultCount(String strAdult){
		WebElement adultDropDown=objWrapper_Function.setExplicitlyWait(loc_drp_adultDropDown);
		objWrapper_Function.selectValueFromdropdown(adultDropDown, strAdult);
		objWrapper_Function.setImplicitwait(10);
	}
	
	public void toClickSearchFlights() throws InterruptedException{
		driver.findElement(loc_btn_searchFlights).click();
		Thread.sleep(10000);
		//wait until page is loaded
		String title = driver.getTitle();
		System.out.println(title);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.titleIs(title));
	}

}
