package com.test.pepperfry;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileReader;
import java.net.MalformedURLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

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


public class FilterByPrice {
  
	Initialization ini ;
	final static Logger logger = LogManager.getLogger(Login.class.getName());

	@Test 
  public void f() throws Exception {
		
		
		//press skip
		Thread.sleep(4000);
		ini.driver.findElement(MobileBy.id("com.app.pepperfry:id/tv_skip")).click();
		
		//press confirm
		Thread.sleep(4000);
		//String indVal = ini.driver.findElement(MobileBy.id("com.app.pepperfry:id/ar_confirm")).getAttribute("text");
		ini.driver.findElement(MobileBy.id("com.app.pepperfry:id/ar_confirm")).click();
		
		
		// press furniture
		Thread.sleep(4000);
		ini.driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]")).click();

		//press sofas and laug
		Thread.sleep(4000);
		ini.driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[3]/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.ImageView")).click();
	
		// press sofas
		Thread.sleep(4000);
		List<MobileElement> li = ini.driver.findElements(MobileBy.className("android.widget.LinearLayout"));
		li.get(12).click();

		// press filter
		Thread.sleep(4000);
		ini.driver.findElement(MobileBy.id("com.app.pepperfry:id/viewFilter")).click();
		
		//press price 
		Thread.sleep(4000);
		ini.tapTextViewElementbyXpathText("Price");

		//press Rs. 11600 And Below
		Thread.sleep(4000);
		ini.tapTextViewElementbyXpathText("Rs. 11600 And Below");
		
		//press Apply
		Thread.sleep(4000);
		ini.driver.findElement(MobileBy.id("com.app.pepperfry:id/tvApply")).click();
		
		
		//retrieve all price textview 
		Thread.sleep(4000);
		
		List<MobileElement> oldLstName=new ArrayList<MobileElement>();
		
		while(true) {
		
			List<MobileElement> lst = new ArrayList<MobileElement>();
			List<MobileElement> lstName= new ArrayList<MobileElement>();
			
			//while(ini.driver.findElements(MobileBy.id("com.app.pepperfry:id/youPayPrice")).size()==0)
			lst = ini.driver.findElements(MobileBy.id("com.app.pepperfry:id/youPayPrice"));
			
			//while(ini.driver.findElements(MobileBy.id("com.app.pepperfry:id/clipItemName")).size()==0)
			lstName = ini.driver.findElements(MobileBy.id("com.app.pepperfry:id/clipItemName"));
				
			
			//we can check on the old item name list if it is not the same as the old one then break from the loop
			boolean notSame = false;
			
			if(lstName.size() == oldLstName.size()) {
				for(int i=0;i<lstName.size();i++) {
					String itemName =  lstName.get(i).getText();
					String oldItemName =  oldLstName.get(i).getText();	
					if(! itemName.equals(oldItemName)) {
						notSame=true;
						break;
					}
				}
	        
			}

			if(! notSame) {
				break;
			}
			
			
			//loop and validate if the value is <= 11600, if any case is wrong testcase fails 
			boolean failed = false;
			for(int i=0;i<lst.size();i++) {
				if(!(Integer.parseInt((((MobileElement)lst.get(i)).getAttribute("text").replaceAll(",", "").split(" "))[1]) <= 11600)) {
					//fails
					failed = true;
					break;
				}
			}
			if(failed) {
				//test cased failed
				break;
			}
			else {
				//testcase passed
			}
			

			// scroll down to move to the next items 
			Dimension size = ini.driver.manage().window().getSize();
        	int starty = (int) (size.height * 0.80);
        	int endy = (int) (size.height * 0.20);
        	int startx = size.width / 2;
			
			TouchAction ts = new TouchAction(ini.driver);		       
	        ts.longPress(startx, starty).moveTo(startx, endy).release().perform();
	        
	        //While (driver.findElements(By.id51(“your_id”)).size()==0){
	        
		}
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
