package com.test.pepperfry;
import org.testng.annotations.Test;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.util.List;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class ControlSeekBar {
	Initialization ini;

	@Test 
  public void f() throws InterruptedException {
	  
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
		
		
		
		
		 	//press on the orange icon
			Thread.sleep(4000);
			ini.driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.widget.ImageView[1]")).click();
			  
			
			//pressing the permission button twice for the two permissions
			Thread.sleep(4000);
			ini.driver.findElement(MobileBy.id("com.android.packageinstaller:id/permission_allow_button")).click();
			ini.driver.findElement(MobileBy.id("com.android.packageinstaller:id/permission_allow_button")).click();
			
			
			Thread.sleep(4000);
			// press on wallview
			List<MobileElement> li_wallwiew = ini.driver.findElementsByClassName("android.widget.TextView");
			li_wallwiew.get(1).click();
		 	
			Thread.sleep(4000);
			//press on the imageview --> bg of the image to select color
			List<MobileElement> li_imageViews = ini.driver.findElementsByClassName("android.widget.ImageView");
			li_imageViews.get(0).click();
		 	
			Thread.sleep(4000);			 
			//moving the seekbar to some location to change the color
			  //Locate SeekBar element.
			  MobileElement seekBar=(MobileElement) ini.driver.findElements(MobileBy.className("android.widget.SeekBar")).get(0);
			  //Get start point of seekbar.
			  int startX = seekBar.getLocation().getX();
			  System.out.println(startX);
			  //Get end point of seekbar.
			  int endX = seekBar.getSize().getWidth();
			  System.out.println(endX);
			  //Get vertical location of seekbar.
			  int yAxis = seekBar.getLocation().getY();
			  
			  //Set sllebar move to position. 
			  //endX * 0.6 means at 60% of seek bar width.
			  int moveToXDirectionAt = (int) (endX * 0.6);
			  System.out.println("Moving seek bar at " + moveToXDirectionAt+" In X direction.");
			  
			  //Moving seekbar using TouchAction class.
			  TouchAction act=new TouchAction(ini.driver);  
			  act.longPress(endX,yAxis).moveTo(moveToXDirectionAt,yAxis).release().perform();  
			  	
			  
			  //pressing the save button
			  ini.driver.findElement(MobileBy.id("com.app.pepperfry:id/txt_color_ok")).click();
			  

	  
			  
			  
			  //scrolling
			  /*
			   	WebElement abc = driver.findElement(MobileBy.AccessibilityId(locator));
				int x = abc.getLocation().getX();
				int y = abc.getLocation().getY();
				
				TouchAction action = new TouchAction(driver);
				action.press(x,y).moveTo(x+90,y).release().perform();
			   */
			  
			  
	  
  }
	
	 @Parameters({ "udid","appPackage","appActivity", "platformName" , "URL"})	
	  @BeforeClass
	  public void beforeTest(String deviceName,String appPackage,String appActivity,String platformName,String URL) throws MalformedURLException, InterruptedException {
		  ini = new Initialization(deviceName, appPackage,appActivity,platformName,URL);
	  }


  @AfterClass
  public void afterTest() {
	  ini.driver.close();
  }

}