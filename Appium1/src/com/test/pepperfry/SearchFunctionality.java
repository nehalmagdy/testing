package com.test.pepperfry;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidKeyCode;


public class SearchFunctionality {
  
	Initialization ini ;
	//final static Logger logger = LogManager.getLogger(Login.class.getName());

	@Test 
  public void f() throws Exception {
		
		
		//press skip
		Thread.sleep(4000);
		ini.driver.findElement(MobileBy.id("com.app.pepperfry:id/tv_skip")).click();
		
		//press confirm
		Thread.sleep(4000);
		ini.driver.findElement(MobileBy.id("com.app.pepperfry:id/ar_confirm")).click();
		
		
		String searchKeyword = "sof in";
		
		//press the search button 
		ini.driver.findElement(MobileBy.id("com.app.pepperfry:id/search")).click();
		
		// Enter the search keywork and search
		ini.driver.findElement(MobileBy.id("android:id/search_src_text")).sendKeys(searchKeyword+"\n");
		
		//retrieve all names textview 
		Thread.sleep(4000);
		
		
		
		
		//834,1314
		// this was done because it doesn't return any item from the search results unless i moved to any activity and return back !!!!
		TouchAction ts1 = new TouchAction(ini.driver);		       
        ts1.press(834,1314).release().perform();    
        Thread.sleep(4000);
        ini.driver.pressKeyCode(AndroidKeyCode.BACK);
		
        List<String> oldL = new ArrayList<String>();
        List<MobileElement> lstName= new ArrayList<MobileElement>();
        List<String> NewlstName = new ArrayList<String>();
        
        do {
		
			Thread.sleep(4000);	
			lstName = ini.driver.findElements(By.id("com.app.pepperfry:id/clipItemName"));
				
			//loop and validate if the value is <= 11600, if any case is wrong testcase fails 
			boolean failed = false;
			for(int i=0;i<lstName.size();i++) {
				for(int k=0;k<searchKeyword.split(" ").length;k++) {
					if(! ((MobileElement)lstName.get(i)).getAttribute("text").toLowerCase().contains(searchKeyword.split(" ")[k].toLowerCase())) {
						failed = true;
						break;
					}
				}
			}
			if(failed) {
				//test cased failed
				break;
			}
			else {
				//testcase passed
			}
			
			
			if(ini.getElementbyXpathText("Your opinion matters to us!")) {
				Dimension size = ini.driver.manage().window().getSize();		    	
	        	new TouchAction(ini.driver).longPress(ini.driver.findElementByXPath("//android.widget.TextView[@text='Your opinion matters to us!']")).moveTo(size.width,1660).release().perform();
	        }
			
			 for(int l=0;l<lstName.size();l++) {
	        	oldL.add(new String(lstName.get(l).getAttribute("text")));
	        }
			 
			// scroll down to move to the next items 
			Dimension size = ini.driver.manage().window().getSize();
        	int starty = (int) (size.height * 0.80);
        	int endy = (int) (size.height * 0.20);
        	int startx = size.width / 2;
			
			TouchAction ts = new TouchAction(ini.driver);		       
	        ts.longPress(startx, starty).moveTo(startx, endy).release().perform();
	        
	        Thread.sleep(4000);
	       
	       lstName = ini.driver.findElements(By.id("com.app.pepperfry:id/clipItemName"));
	       for(int l=0;l<lstName.size();l++) {
	        	NewlstName.add(new String(lstName.get(l).getAttribute("text")));
	        }
	      
	        
		}while(! ini.compareTwoLists(oldL, NewlstName));
	}
	
	  @BeforeClass
	  public void beforeTest() throws MalformedURLException, InterruptedException {
		 ConfigFileReader r = new ConfigFileReader();		 
		 ini = new Initialization(r.getudid(), r.getAppPackage(),r.getAppActivity(),r.getPlatformName(),r.getApplicationUrl());
	  }


  @AfterClass
  public void afterTest() {
	  ini.driver.close();
	 // DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
	//	LocalDateTime now = LocalDateTime.now();  
		
	 // logger.info("# # # # # # # # # # # # # # # # # # # # # # # # # # # ");
      //logger.info("Registeration TEST Has Ended "+ dtf.format(now));
    
  }

}
