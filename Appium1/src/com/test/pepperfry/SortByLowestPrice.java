package com.test.pepperfry;

import java.net.MalformedURLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public class SortByLowestPrice {
  
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

		Thread.sleep(4000);
		Dimension size1 = ini.driver.manage().window().getSize();
    	int starty1 = (int) (size1.height * 0.80);
    	int endy1 = (int) (size1.height * 0.10);
    	int startx1 = size1.width / 2;
		
		TouchAction ts1 = new TouchAction(ini.driver);		       
        ts1.longPress(startx1, starty1).moveTo(startx1, endy1).release().perform();
		
		
		
		//press sofas and laug
		Thread.sleep(4000);
		ini.tapTextViewElementbyXpathText("Folding Chairs");
		//ini.driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[4]/android.widget.TextView")).click();
	
		// press sofas
		/*Thread.sleep(4000);
		List<MobileElement> li = ini.driver.findElements(MobileBy.className("android.widget.LinearLayout"));
		li.get(12).click();*/

		// press sort
		Thread.sleep(4000);
		ini.driver.findElement(MobileBy.id("com.app.pepperfry:id/viewSort")).click();
		
		//press highest price
		Thread.sleep(4000);
		ini.tapTextViewElementbyXpathText("Lowest Priced First");
		
		//retrieve all price textview 
		Thread.sleep(4000);
		
		int oldPrice =Integer.MIN_VALUE;
		Dimension size = ini.driver.manage().window().getSize();
    	int starty = 396;
		while(true) {
		
			List<MobileElement> lst = new ArrayList<MobileElement>();
			List<MobileElement> lstName= new ArrayList<MobileElement>();
			List<String> names = new ArrayList<String>();
			
			lst = ini.driver.findElements(MobileBy.id("com.app.pepperfry:id/youPayPrice"));
			
			
			lstName = ini.driver.findElements(MobileBy.id("com.app.pepperfry:id/clipItemName"));
			for(int k=0;k<lstName.size();k++) {
				names.add(lstName.get(k).getText());
			}
		       	
			
			
			//loop and validate if the value is <= 11600, if any case is wrong testcase fails 
			boolean failed = false;
			for(int i=0;i<lst.size();i++) {
				if(lst.size()>2) {
					i=lst.size()-1;
				}
				int price= Integer.parseInt((((MobileElement)lst.get(i)).getAttribute("text").replaceAll(",", "").split(" "))[1]);
				if(price < oldPrice) {
					//fails
					failed = true;
					break;
				}
				oldPrice=price;
			}
			if(failed) {
				//test cased failed
				System.out.println("Failed in numbers order");
				break;
			}
			else {
				//testcase passed
				System.out.println("Correct numbers order");
			}
			

			// scroll down to move to the next items 
			
        	int endy = starty+1091;
        	int startx = size.width / 2;
			
			TouchAction ts = new TouchAction(ini.driver);		       
	        ts.longPress(startx, 1516).moveTo(startx, 370).release().perform();
	        
	        endy=starty;
	        
	        if(ini.getElementbyXpathText("Your opinion matters to us!")) {
	        	new TouchAction(ini.driver).longPress(ini.driver.findElementByXPath("//android.widget.TextView[@text='Your opinion matters to us!']")).moveTo(size.width, endy).release().perform();
	        }
			//we can check on the old item name list if it is not the same as the old one then break from the loop
	        List<MobileElement> nowLstName = ini.driver.findElements(MobileBy.id("com.app.pepperfry:id/clipItemName"));			
	        
			List<String> nNames=new ArrayList<String>();
	        for(int k=0;k<nowLstName.size();k++) {
				nNames.add(nowLstName.get(k).getText());
			}
		
	        boolean notSame = false;
			
			if(names.size() == nNames.size()) {
				for(int i=0;i<names.size();i++) {
					if(! nNames.get(i).equals(names.get(i))) {
						notSame=true;
						break;
					}
				}
	        
			}
			else {
				notSame=true;
			}
			if(! notSame) {
				System.out.println("Same Lists are retrieved end of scrolling");
				break;
			}
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
