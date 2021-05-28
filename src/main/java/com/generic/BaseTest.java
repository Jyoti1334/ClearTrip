package com.generic;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BaseTest{
 public static WebDriver driver=null;
  public static Properties objConfig;
	 
	 public  void initializeWebBrowser() {
			
	   System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/main/resources/chromedriver.exe");
	   driver=new ChromeDriver();
	   loadConfigProperties();
	   
	 driver.get(objConfig.getProperty("AUT_URL"));
	//driver.get("https://www.cleartrip.com/");
	//driver.get("https://www.cleartrip.com/flights/results?origin=Mumbai,+IN+-+Chatrapati+Shivaji+Airport+(BOM)&from=BOM&destination=New+Delhi,+IN+-+Indira+Gandhi+Airport+(DEL)&to=DEL&depart_date=30/05/2021&return_date=31/05/2021&adults=2&childs=0&infants=0&class=Economy&airline=&carrier=&intl=n&sd=1622085831497&rnd_one=R");
	   driver.manage().window().maximize();
 			
	    }
		public static void loadConfigProperties(){
			
	  
	          objConfig = new Properties();
	        
	            try {
	    InputStream input= new FileInputStream(System.getProperty("user.dir")+"/src/main/java/configFile/config.properties");
	                objConfig.load(input);
	               
	            } catch (IOException e) {
	                System.out.println(e);
	            }
	      }
	 
		

      public  void tearDown(){
		
		driver.close();
	  }

}





