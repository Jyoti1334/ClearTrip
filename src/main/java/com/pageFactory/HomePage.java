package com.pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage {
	WebDriver driver;
	By loc_lnk_flightLink=By.xpath("//ul/following::li[@class='flightApp']");
	public HomePage(WebDriver driver){
		this.driver=driver;
	}
	
	public void toClickFlightsTab(){
		
		driver.findElement(loc_lnk_flightLink).click();
		
		String strCurrentUrl=driver.getCurrentUrl();
		System.out.println("Current Url :"+strCurrentUrl);
	}
}
