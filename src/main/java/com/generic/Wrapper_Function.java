package com.generic;




import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Wrapper_Function   {
	 WebDriver driver;

	
	 Select select;
	 public Wrapper_Function(WebDriver driver){
		 this.driver=driver;
	 }
	
	/**
	 * Method to set implicit Wait
	 * @param intSecond
	 */
       public  void setImplicitwait(int intSecond){
		
    	   driver.manage().timeouts().implicitlyWait(intSecond, TimeUnit.SECONDS);
	   }
      
    
       /**
        * Method to set Explicit Wait
        * @param locator
        * @return
        */
       public WebElement setExplicitlyWait(By locator){
   	    Integer timeoutLimitSeconds = 20;
   	    WebDriverWait wait = new WebDriverWait(BaseTest.driver, timeoutLimitSeconds);
   	    try {
   	        wait.until(ExpectedConditions.elementToBeClickable(locator));
   	    }
   	    catch(TimeoutException e){
   	        throw new NoSuchElementException(locator.toString());
   	    }
   	    WebElement element = BaseTest.driver.findElement(locator);
   	    return element;
   	}
     
       
       /**
        * Method to selectDate from DatePicker Calender
        * @param locator
        * @param index
        */
       public void selectDate(By locator,int index){
    	   List<WebElement> allDates=driver.findElements(locator);
    	   for (int i = 0; i < allDates.size(); i++) 
    	   {
    		   if(i==index){
    			   
    		   
			WebElement strDate=allDates.get(index);
			strDate.click();
			break;
    		   }
		}
    	 
    	   
       }
       
       /**
        * Method to select actual City name airpot details
        * @param locator
        * @param strActualCity
        */
       public void selectCity(By locator, String strActualCity){
    List<WebElement> selectToCityOption=driver.findElements(locator);
	        
	        for(WebElement option:selectToCityOption){
	            
	            System.out.println(option);
	            if(option.getText().equals(strActualCity)){
	                System.out.println("selecting :"+strActualCity);
	                option.click();
	                break;
	            }
	        }
       }
       
       /**
        * method to set static date
        * @param driver
        * @param element
        * @param strVal
        */
       public void selectDateByJS(WebDriver driver, WebElement element,String strVal){
    	   JavascriptExecutor jse=((JavascriptExecutor)driver);
    	   jse.executeScript("argument[0].setAttribute('value','"+strVal+"');", element);
       }
       
       /**
        * Method to select dropdown
        * @param element
        * @param value
        */
       public void selectValueFromdropdown(WebElement element, String value) {
       	  try{
       	   Select objDropdown = new Select(element);
       	 objDropdown.selectByVisibleText(value);
       	  }catch(Exception e)
       	  {
       		  System.out.println(e);
       	  }
          }
       
//       public void toSelectDate(int index){
//    	   Date dt = new Date();
//    	   Calendar calendar = Calendar.getInstance();
//    	   calendar.setTime(dt);
//    	   calendar.add(Calendar.DATE, index);
//    	   dt = calendar.getTime();
//    	  // String departdate = new SimpleDateFormat("dd/mm/yyyy").format(dt);
//       }
}
