package com.pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class TravellersDetailPage {

	WebDriver driver;
	JavascriptExecutor objJSE;
	By loc_cb_chechBox=By.xpath("//p[text()='I accept the terms and conditions of this policy']");
	By loc_btn_continueButton=By.xpath("//button[text()='Continue']");
	public TravellersDetailPage(WebDriver driver){
		this.driver=driver;
	}
	
	public void toAcceptTermsAndCondition(){
	objJSE=(JavascriptExecutor)driver;
	 objJSE.executeScript("scroll(0,500)");
	driver.findElement(loc_cb_chechBox).click();
	
	}
	
	public void toClickOnContinue(){
		objJSE=(JavascriptExecutor)driver;
		 objJSE.executeScript("scroll(0,500)");
		 driver.findElement(loc_btn_continueButton).click();
	}
	
	
}
