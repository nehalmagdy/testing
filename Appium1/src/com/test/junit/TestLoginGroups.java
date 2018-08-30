package com.test.junit;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.MalformedURLException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.test.pepperfry.Initialization;

import io.appium.java_client.MobileBy;


public class TestLoginGroups {
  
	Initialization ini ;
	//final static Logger logger = LogManager.getLogger(Login.class.getName());

	//@AndroidFindBy(id="")
	//@iOSFindBy(xpath="")
	//public MobileElement test;
	
	@Test (groups="Regression")
  public void f() throws Exception {
	
		//  DOMConfigurator.configure("log4j.xml");
	      //logger.info("# # # # # # # # # # # # # # # # # # # # # # # # # # # ");
	      //logger.info("Login TEST Has Started");
	    
	      
		String csvFile = "F:\\Mobile Testing\\Documents\\LoginData.csv";
        String line = "";
        String cvsSplitBy = ",";

   	    //press Login
	    Thread.sleep(3000);
		//ini.driver.tap(1, ini.driver.findElement(MobileBy.id("com.app.pepperfry:id/tv_login")), 1);
	    
	    //how to get content-desc, resource-id
	   /* MobileElement e = (MobileElement)ini.driver.findElement(MobileBy.id("com.app.pepperfry:id/tv_login"));
	    String s = e.getAttribute("contentDescription");
	    s=e.getAttribute("name");
	    s = e.getAttribute("resourceId");
		   */
	    ini.driver.findElement(MobileBy.id("com.app.pepperfry:id/tv_login")).click();
	    
	    
	    
	    
	    // read data from CSV File row by row
		BufferedReader br = new BufferedReader(new FileReader(csvFile));
		br.readLine(); // the header line
		 while ((line = br.readLine()) != null) {
			 String[] data = line.split(cvsSplitBy);
			
			 Thread.sleep(3000);
	    	//ini.driver.tap(1,ini.driver.findElement(MobileBy.id("com.app.pepperfry:id/login_username")),1); // set username value
			 ini.driver.findElement(MobileBy.id("com.app.pepperfry:id/login_username")).click();
	    	String UNval = data[0];// get username column
	    	ini.driver.getKeyboard().sendKeys("");
	    	ini.driver.getKeyboard().sendKeys(UNval);
			ini.driver.hideKeyboard();
			ini.driver.hideKeyboard();
			
			
			Thread.sleep(3000);
			//ini.driver.tap(1,ini.driver.findElement(MobileBy.id("com.app.pepperfry:id/login_pwd")),1); //set password value
			ini.driver.findElement(MobileBy.id("com.app.pepperfry:id/login_pwd")).click();
			String Passval = data[1];// get password column
			ini.driver.getKeyboard().sendKeys("");
			ini.driver.getKeyboard().sendKeys(Passval);
			ini.driver.hideKeyboard();
			ini.driver.hideKeyboard();
			
			
			//press login button
			//ini.driver.tap(1,ini.driver.findElement(MobileBy.id("com.app.pepperfry:id/login_action_txt")),1);
			ini.driver.findElement(MobileBy.id("com.app.pepperfry:id/login_action_txt")).click();

			//validate Error Messages
			if(data[6].equals("Invalid")) {
				String eVal = data[2];
				if(ini.getElementbyXpathText(eVal)) { // UNErrorMessage		
					// test pass
		    		System.out.println("Correct UN Error Message");
		    //		logger.info("Correct UN Error Message");
		  	      
		    	}
		    	else {
		    		// fail means either absence of the element or incorrect validation message 
		    		if(ini.isPresentByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.RelativeLayout/TextInputLayout[1]/android.widget.LinearLayout/android.widget.TextView"))
		    		{
		    			System.out.println("InCorrect UN Error Message, it should be"+data[2]);
		    	//		logger.info("InCorrect UN Error Message");
		    		}
		    		else {
		    			// if cell value is empty then correct else incorrect error message 
		    			if(data[2].equals("")) {
		    				System.out.println("Correct");
		    		//		logger.info("Correct");
		    			}
		    			else {
		    				System.out.println("InCorrect UN Error Message, it should be"+data[2]);
		    			//	logger.info("InCorrect UN Error Message");
		    			}		    			
		    		}		    		
		    	}
			    	
				if(ini.getElementbyXpathText(data[3])) { // PassErrorMessage		
		    		// test pass
		    		System.out.println("Correct Password Error Message");
		    		//logger.info("Correct PASS Error Message");
		    	}
		    	else {
		    		// fail means either absence of the element or incorrect validation message 
		    		if(ini.isPresentByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.RelativeLayout/TextInputLayout[2]/android.widget.LinearLayout/android.widget.TextView"))
		    		{
		    			System.out.println("InCorrect Password Error Message, it should be"+data[3]);
		    			//logger.info("InCorrect PASS Error Message");
		    		}
		    		else {
		    			// if excel is empty then correct else incorrect error message 
		    			if(data[3].equals("")) {
		    				System.out.println("Correct");
		    				//logger.info("Correct");
		    			}
		    			else {
		    				System.out.println("InCorrect Password Error Message, it should be"+data[3]);
		    				//logger.info("InCorrect PASS Error Message");
		    			}		    			
		    		}		    		
		    	}
			}
			else if(data[6].equals("InvalidP")) {
				/*if(ini.getElementbyXpathText(data[4])) // pop up textview		    			    	
		    	{
		    		// test pass 
		    		System.out.println("Correct PASS/UN Error Message");
		    		logger.info("Correct PASS/UN Error Message");
		    	}
				else {
					// means wrong message appears or its absence 
					if(ini.isPresentByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView"))
		    		{
		    			System.out.println("InCorrect POP Error Message, it should be"+data[4]);
		    			logger.info("InCorrect Error Message");
		    		}
		    		else {
		    			// if excel is empty then correct else incorrect error message 
		    			if(data[4].equals("")) {
		    				System.out.println("Correct");
		    				logger.info("Correct POP");
		    			}
		    			else {
		    				System.out.println("InCorrect Error Message, it should be"+data[4]);
		    				logger.info("InCorrect POP");
		    			}		    			
		    		}	
				}*/
				String scrText = ini.readToastMessage();
	    		String msg = data[4];
	    		if(scrText.contains(msg))
	    		{
	    			System.out.println("Correct POP Message");
    				//logger.info("Correct POP Message");
	    		}
	    		else
	    		{
	    			System.out.println("InCorrect POP Message");
    				//logger.info("InCorrect POP Message");
	    		}
			}
	    	else if(data[7].equals("Valid")) { //validate toast message 
	    		// i'll need to take screenshot of the toast message to validate it
	    		//logger.info("Enter Screen Shot");
	    		String scrText = ini.readToastMessage();
	    		String msg = data[5]+", "+data[6];
	    		if(scrText.contains(msg))
	    		{
	    			System.out.println("Correct Toast Message");
    				//logger.info("Correct Toast Message");
	    		}
	    		else
	    		{
	    			System.out.println("InCorrect Toast Message");
    				//logger.info("InCorrect Toast Message");
	    		}
	    	}
	    	
	    }  
		 br.close();
		 
  }
  
	
	
	@Test(groups="smoke")
	 public void fi() throws Exception {
			
	   	    //press Login
		    Thread.sleep(3000);
			//ini.driver.tap(1, ini.driver.findElement(MobileBy.id("com.app.pepperfry:id/tv_login")), 1);
		    
		    //how to get content-desc, resource-id
		   /* MobileElement e = (MobileElement)ini.driver.findElement(MobileBy.id("com.app.pepperfry:id/tv_login"));
		    String s = e.getAttribute("contentDescription");
		    s=e.getAttribute("name");
		    s = e.getAttribute("resourceId");
			   */
		    ini.driver.findElement(MobileBy.id("com.app.pepperfry:id/tv_login")).click();
	  }
	  	
	
  @Parameters({ "udid","appPackage","appActivity", "platformName" , "URL"})	
  @BeforeClass(alwaysRun=true)
  public void beforeTest(String deviceName,String appPackage,String appActivity,String platformName,String URL) throws MalformedURLException, InterruptedException {
	  ini = new Initialization(deviceName, appPackage,appActivity,platformName,URL);
  }

  @AfterClass(alwaysRun=true)
  public void afterTest() {
	  ini.driver.close();
	  //logger.info("# # # # # # # # # # # # # # # # # # # # # # # # # # # ");
      //logger.info("Login TEST Has Ended");
    
  }

}
