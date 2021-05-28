package com.scripts;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.generic.BaseTest;
import com.pageFactory.FlightBookPage;
import com.pageFactory.FlightsPage;
import com.pageFactory.HomePage;



public class TestClearTrip extends BaseTest {
	public HomePage objHomePage;
	public FlightsPage objFlightsPage;
	public FlightBookPage objFlightBookPage;
	public void initilizePages(){
		objHomePage=new HomePage(driver);
		objFlightsPage=new FlightsPage(driver);
		objFlightBookPage=new FlightBookPage(driver);
	 }
	 
	
	@BeforeTest
	 public  void initializeWebEnvironment() {
			this.initializeWebBrowser();
			this.initilizePages();
		   }
@Test(priority=1)
	public void verifyFlightPage() throws InterruptedException {
	   
		objHomePage.toClickFlightsTab();
		objFlightsPage.commonSelectRadioButtonTripType(objConfig.getProperty("strTripType"));
		objFlightsPage.enterDepartureCity();
		objFlightsPage.enterDestinationCity();
		objFlightsPage.toSelectDepartureDate();
		objFlightsPage.toSelectArrivalDate();
		//objFlightsPage.toSelectDepartAndReturnDate("27");
		objFlightsPage.toSelectAdultCount("2");
		objFlightsPage.toClickSearchFlights();
	}
@Test(priority=2) 
    public void verifyFlightBookPage(){
    	objFlightBookPage.toCheckNonStopBox();
    	objFlightBookPage.selectDepartureFlight();
    }

}
