package com.pageFactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FlightBookPage {
 WebDriver driver;
	
	By loc_cb_nonStopCheckBox=By.xpath("//p[text()='Non-stop']/ancestor::div[@class='pt-3']");
    By loc_lnk_indigoFlight=By.xpath("//div[@data-test-attrib='onward-view']//img[@alt='IndiGo']");
	By loc_btn_bookFlightButton=By.xpath("//button[text()='Book']");
	By loc_btn_searchFlights=By.id("SearchBtn");
	public FlightBookPage(WebDriver driver){
		this.driver=driver;
	}

    public void toCheckNonStopBox(){
    	try {
    		driver.findElement(loc_cb_nonStopCheckBox).click();
		} catch (Exception e) {
			driver.findElement(loc_btn_searchFlights).click();
		}
    	
    }
    
    public void selectDepartureFlight(){
    	List<WebElement> allIndigoFlights=driver.findElements(loc_lnk_indigoFlight);
 	   for (int i = 0; i < allIndigoFlights.size(); i++) 
 	   {
			WebElement strFlight=allIndigoFlights.get(2);
			strFlight.click();
		}
    	
    }
    
    public void toBookFlight(){
    	driver.findElement(loc_btn_bookFlightButton).click();
    }
}
