package com.generic;

import java.util.Random;

public class Utilities {
	String strUppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	String strLowercase = "abcdefghijklmnopqrstuvwxyz";
//	String strNumber="0123456789";
//	String strCode="99"+"98"+"97"+"91"+"90"+"77"+"78"+"75"+"80"+"96";
//	
	StringBuilder builder = new StringBuilder();
	Random num=new Random();
	/*to generate random string*/
	public String getRandomString(int count){
		
		while (count-- != 0) 
		{
		int intCharacter = (int)(Math.random()*(strUppercase.concat(strLowercase)).length());
		builder.append((strUppercase.concat(strLowercase)).charAt(intCharacter));
		}
		return builder.toString();
		}
		
	/*to generate random number*/
	public String getRandomNumber(int start, int end){
		int intRandomNumber= start + (int) Math.round(Math.random() * (end - start));
		return Integer.toString(intRandomNumber);	
	}
	  
    /*to generate random moblie no */
    public String getRandomMobileNumber(){
    	String strCode[]={"99","98","97","91","90","77","78","75","80","96"};
    	
    	String strRandom=(strCode[new Random().nextInt(strCode.length)]);
    	int strDigit=(int)((Math.random()*90000000)+10000000);
    	String strMobileNo=strRandom+Integer.toString(strDigit);
    	return strMobileNo;
    	
    	
    }
    /*to generate random emailid */
    public String getRandomEmailId() {
        // TODO Auto-generated method stub
        return getRandomString(4) + getRandomNumber(0, 9) + "@gmail.com";
    }
    
    
   
  

}
