package com.test.pepperfry;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileReader;
import java.net.MalformedURLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;


public class Registeration {
  
	Initialization ini ;
	final static Logger logger = LogManager.getLogger(Login.class.getName());

	@Test 
  public void f() throws Exception {
	
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		   
		  DOMConfigurator.configure("log4j.xml");
	      logger.info("# # # # # # # # # # # # # # # # # # # # # # # # # # # ");
	      logger.info("Registeration TEST Has Started "+ dtf.format(now));
	    
	      
		String csvFile = "F:\\Mobile Testing\\Documents\\RegisterData.csv";
        String line = "";
        String cvsSplitBy = ",";

   	    //press register
	    Thread.sleep(3000);
		//ini.driver.tap(1, ini.driver.findElement(MobileBy.id("com.app.pepperfry:id/tv_register")), 1);
	    ini.driver.findElement(MobileBy.id("com.app.pepperfry:id/tv_register")).click();
	    
	    // read data from CSV File row by row
		BufferedReader br = new BufferedReader(new FileReader(csvFile));
		br.readLine(); // the header line
		 while ((line = br.readLine()) != null) {
			 String[] data = line.split(cvsSplitBy);
			 
			 //Scrolling Up
		    Dimension size=ini.driver.manage().window().getSize();
	        int y_start=(int)(size.height*0.30);
	        int y_end=(int)(size.height*0.60);
	        int x=size.width/2;
	       // ini.driver.swipe(x,y_start,x,y_end,4000);
			 
	        
	        //TouchActions action = new TouchActions(ini.driver);
	        //action.scroll(0,0);
	        //action.perform();

	        TouchAction ts = new TouchAction(ini.driver);
	       
	     
	        ts.press(x, y_start).moveTo(x, y_end).release().perform();
	        
			 
			Thread.sleep(3000);
			//ini.driver.tap(1,ini.driver.findElement(MobileBy.id("com.app.pepperfry:id/register_firstname")),1); // set firstname value
			ini.driver.findElement(MobileBy.id("com.app.pepperfry:id/register_firstname")).click();
			
	    	String fName = data[0];// get firstname column
	    	ini.driver.getKeyboard().sendKeys("");
	    	ini.driver.getKeyboard().sendKeys(fName);
			ini.driver.hideKeyboard();
			try{ini.driver.hideKeyboard();}catch(Exception ex){}
						
			Thread.sleep(3000);
			//ini.driver.tap(1,ini.driver.findElement(MobileBy.id("com.app.pepperfry:id/register_lastname")),1); //set secondname value
			ini.driver.findElement(MobileBy.id("com.app.pepperfry:id/register_lastname")).click();
			
			String sName = data[1];// get secondname column
			ini.driver.getKeyboard().sendKeys("");
			ini.driver.getKeyboard().sendKeys(sName);
			ini.driver.hideKeyboard();
			try{ini.driver.hideKeyboard();}catch(Exception ex){}
			
			//setting the gender value
		//	 com.app.pepperfry:id/btn_male
			// com.app.pepperfry:id/btn_female
			// com.app.pepperfry:id/btn_transgender
		
			Thread.sleep(3000);
			if(ini.getButtonbyXpathText(data[2])) ini.tapButtonElementbyXpathText(data[2]);
			
			Thread.sleep(3000);
			//ini.driver.tap(1,ini.driver.findElement(MobileBy.id("com.app.pepperfry:id/register_user_email")),1); //set email value
			ini.driver.findElement(MobileBy.id("com.app.pepperfry:id/register_user_email")).click();
			
			String email = data[3];// get email column
			ini.driver.getKeyboard().sendKeys("");
			ini.driver.getKeyboard().sendKeys(email);
			ini.driver.hideKeyboard();
			try{ini.driver.hideKeyboard();}catch(Exception ex){}
			
		
			Thread.sleep(3000);
			//ini.driver.tap(1,ini.driver.findElement(MobileBy.id("com.app.pepperfry:id/register_mobile_num")),1); //set mobile value
			ini.driver.findElement(MobileBy.id("com.app.pepperfry:id/register_mobile_num")).click();
			
			String mobile = data[4];// get mobile column
			ini.driver.getKeyboard().sendKeys("");
			ini.driver.getKeyboard().sendKeys(mobile);
			ini.driver.hideKeyboard();
			try{ini.driver.hideKeyboard();}catch(Exception ex){}
			
			
			Thread.sleep(3000);
			//ini.driver.tap(1,ini.driver.findElement(MobileBy.id("com.app.pepperfry:id/register_password")),1); //set password value
			ini.driver.findElement(MobileBy.id("com.app.pepperfry:id/register_password")).click();
			
			String Passval = data[5];// get password column
			ini.driver.getKeyboard().sendKeys("");
			ini.driver.getKeyboard().sendKeys(Passval);
			ini.driver.hideKeyboard();
			try{ini.driver.hideKeyboard();}catch(Exception ex){}

				
			Thread.sleep(3000);
			//press register button
			//ini.driver.tap(1,ini.driver.findElement(MobileBy.id("com.app.pepperfry:id/register_tv_singup")),1);
			ini.driver.findElement(MobileBy.id("com.app.pepperfry:id/register_tv_singup")).click();
			
			
			Thread.sleep(2000);
			
			//validate Error Messages
			if(data[13].equals("Invalid")) {
			
				// scroll up to be able to fetch the elements as they are not in the screen at this point
				ts.press(x, y_start).moveTo(x, y_end).release().perform();
				 
				//MobileElement FNError = (MobileElement)ini.driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/TextInputLayout[1]/android.widget.LinearLayout/android.widget.TextView"));
				//String s = FNError.getText();
				
				String eVal = data[6];
				if(ini.getElementbyXpathText(eVal)) { // FNErrorMessage		
					// test pass
		    		System.out.println("Correct FN Error Message");
		    		logger.info("Correct FN Error Message");
		  	      
		    	}
		    	else {
		    		// fail means either absence of the element or incorrect validation message 
		    		if(ini.isPresentByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/TextInputLayout[1]/android.widget.LinearLayout/android.widget.TextView"))
		    		{
		    			System.out.println("InCorrect FN Error Message, it should be"+data[6]);
		    			logger.info("InCorrect FN Error Message");
		    		}
		    		else {
		    			// if cell value is empty then correct else incorrect error message 
		    			if(data[6].equals("")) {
		    				System.out.println("Correct");
		    				logger.info("Correct");
		    			}
		    			else {
		    				System.out.println("InCorrect FN Error Message, it should be"+data[6]);
		    				logger.info("InCorrect FN Error Message");
		    			}		    			
		    		}		    		
		    	}
			    	
				 eVal = data[7];
				if(ini.getElementbyXpathText(eVal)) { // FNErrorMessage		
					// test pass
		    		System.out.println("Correct LN Error Message");
		    		logger.info("Correct LN Error Message");
		  	      
		    	}
		    	else {
		    		// fail means either absence of the element or incorrect validation message 
		    		if(ini.isPresentByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/TextInputLayout[2]/android.widget.LinearLayout/android.widget.TextView"))
		    		{
		    			System.out.println("InCorrect LN Error Message, it should be"+data[7]);
		    			logger.info("InCorrect LN Error Message");
		    		}
		    		else {
		    			// if cell value is empty then correct else incorrect error message 
		    			if(data[7].equals("")) {
		    				System.out.println("Correct");
		    				logger.info("Correct");
		    			}
		    			else {
		    				System.out.println("InCorrect LN Error Message, it should be"+data[7]);
		    				logger.info("InCorrect LN Error Message");
		    			}		    			
		    		}		    		
		    	}
			
			
				
				 eVal = data[8];
					if(ini.getElementbyXpathText(eVal)) { // EmailErrorMessage		
						// test pass
			    		System.out.println("Correct Email Error Message");
			    		logger.info("Correct Email Error Message");
			  	      
			    	}
			    	else {
			    		// fail means either absence of the element or incorrect validation message 
			    		if(ini.isPresentByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/TextInputLayout[1]/android.widget.LinearLayout/android.widget.TextView"))
			    		{
			    			System.out.println("InCorrect Email Error Message, it should be"+data[8]);
			    			logger.info("InCorrect Email Error Message");
			    		}
			    		else {
			    			// if cell value is empty then correct else incorrect error message 
			    			if(data[8].equals("")) {
			    				System.out.println("Correct");
			    				logger.info("Correct");
			    			}
			    			else {
			    				System.out.println("InCorrect Email Error Message, it should be"+data[8]);
			    				logger.info("InCorrect Email Error Message");
			    			}		    			
			    		}		    		
			    	}
			
			
					eVal = data[9];
					if(ini.getElementbyXpathText(eVal)) { // MobileErrorMessage		
						// test pass
			    		System.out.println("Correct Mobile Error Message");
			    		logger.info("Correct Mobile Error Message");
			  	      
			    	}
			    	else {
			    		// fail means either absence of the element or incorrect validation message 
			    		if(ini.isPresentByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/TextInputLayout[2]/android.widget.LinearLayout/android.widget.TextView"))
			    		{
			    			System.out.println("InCorrect Mobile Error Message, it should be"+data[9]);
			    			logger.info("InCorrect Mobile Error Message");
			    		}
			    		else {
			    			// if cell value is empty then correct else incorrect error message 
			    			if(data[9].equals("")) {
			    				System.out.println("Correct");
			    				logger.info("Correct");
			    			}
			    			else {
			    				System.out.println("InCorrect Mobile Error Message, it should be"+data[9]);
			    				logger.info("InCorrect Mobile Error Message");
			    			}		    			
			    		}		    		
			    	}
			
					 
				
					eVal = data[10];
					if(ini.getElementbyXpathText(eVal)) { // PassErrorMessage		
						// test pass
			    		System.out.println("Correct PASS Error Message");
			    		logger.info("Correct PASS Error Message");
			  	      
			    	}
			    	else {
			    		// fail means either absence of the element or incorrect validation message 
			    		if(ini.isPresentByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/TextInputLayout[3]/android.widget.LinearLayout/android.widget.TextView"))
			    		{
			    			System.out.println("InCorrect PASS Error Message, it should be"+data[10]);
			    			logger.info("InCorrect PASS Error Message");
			    		}
			    		else {
			    			// if cell value is empty then correct else incorrect error message 
			    			if(data[10].equals("")) {
			    				System.out.println("Correct");
			    				logger.info("Correct");
			    			}
			    			else {
			    				System.out.println("InCorrect PASS Error Message, it should be"+data[10]);
			    				logger.info("InCorrect PASS Error Message");
			    			}		    			
			    		}		    		
			    	}
			}
			else if(data[13].equals("InvalidP")) {
				/*if(ini.getElementbyXpathText(data[11])) // pop up textview		    			    	
		    	{
		    		// test pass 
		    		System.out.println("Correct EMAlreadyExists Error Message");
		    		logger.info("Correct EMAlreadyExists Error Message");
		    	}
				else {
					// means wrong message appears or its absence 
					if(ini.isPresentByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView"))
		    		{
		    			System.out.println("InCorrect POP Error Message, it should be"+data[11]);
		    			logger.info("InCorrect POP Error Message");
		    		}
		    		else {
		    			// if excel is empty then correct else incorrect error message 
		    			if(data[11].equals("")) {
		    				System.out.println("Correct POP");
		    				logger.info("Correct POP");
		    			}
		    			else {
		    				System.out.println("InCorrect POP Error Message, it should be"+data[11]);
		    				logger.info("InCorrect POP");
		    			}		    			
		    		}	
				}*/
				logger.info("Enter POP Screen Shot");
	    		String scrText = ini.readToastMessage();
	    		String msg = data[11];
	    		if(scrText.contains(msg))
	    		{
	    			System.out.println("Correct POP Message");
    				logger.info("Correct POP Message");
	    		}
	    		else
	    		{
	    			System.out.println("InCorrect POP Message");
    				logger.info("InCorrect POP Message");
	    		}
			}
	    	else if(data[14].equals("Valid")) { //validate toast message 
	    		// i'll need to take screenshot of the toast message to validate it
	    		logger.info("Enter Screen Shot");
	    		String scrText = ini.readToastMessage();
	    		String msg = data[12]+","+data[13];
	    		if(scrText.contains(msg))
	    		{
	    			System.out.println("Correct Toast Message");
    				logger.info("Correct Toast Message");
	    		}
	    		else
	    		{
	    			System.out.println("InCorrect Toast Message");
    				logger.info("InCorrect Toast Message");
	    		}
	    	}
		 }
		 br.close();
	}

	
	 @Parameters({ "udid","appPackage","appActivity", "platformName" , "URL"})	
	  @BeforeClass
	  public void beforeTest(String deviceName,String appPackage,String appActivity,String platformName,String URL) throws MalformedURLException, InterruptedException {
		  ini = new Initialization(deviceName, appPackage,appActivity,platformName,URL);
	  }


  @AfterClass
  public void afterTest() {
	  ini.driver.close();
	  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		
	  logger.info("# # # # # # # # # # # # # # # # # # # # # # # # # # # ");
      logger.info("Registeration TEST Has Ended "+ dtf.format(now));
    
  }

}
