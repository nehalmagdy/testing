package com.test.pepperfry;
import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class AddCartFunctionality {
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
		
		//press the "addToCart" icon of the first item card 
		Thread.sleep(4000);		
		List<MobileElement> addCartIconsList = ini.driver.findElements(MobileBy.id("com.app.pepperfry:id/imvAddToCart"));
		int iCount = addCartIconsList.size();
		if(iCount>0) {
			// here i need to know if the user liked (will be added to the wishlist) or disliked the item (will be removed from the wishlist)
			//press like icon
			
			int count = Integer.parseInt(ini.driver.findElement(By.id("com.app.pepperfry:id/tvCartCount")).getText());
			addCartIconsList.get(0).click();		
			int newCount = Integer.parseInt(ini.driver.findElement(By.id("com.app.pepperfry:id/tvCartCount")).getText());
			
			if(newCount == count+1) {
				//correctCount
			}
			else {
				//wrongCount
			}
	
			// get item name			
			List<MobileElement> wishIconsNameList = ini.driver.findElements(MobileBy.id("com.app.pepperfry:id/clipItemName"));	
			String x = wishIconsNameList.get(0).getText();
			 
			//open cart and check if that item exists 
			ini.driver.findElement(By.id("com.app.pepperfry:id/tvCartCount")).click();
			if (ini.getElementbyXpathText(x)) {
				// added to cart 
				System.out.println(x);
			}
			else { 
				//wrong and test fails
				System.out.println("fails");
			}
		
			//adding value to the spinner  --> selecting quantity
			ini.driver.findElement(MobileBy.id("com.app.pepperfry:id/quantity_dropdown")).click();
			if(ini.getElementbyXpathText("2")) {
				ini.tapTextViewElementbyXpathText("2");
			}

			//issue of sendkeys --> it send the value in other controls too textview !!!!!
			//ini.driver.findElement(MobileBy.id("com.app.pepperfry:id/quantity_dropdown")).sendKeys("2");
			// it works (Y)
			//new TouchAction((MobileDriver) ini.driver).press(wishIconsNameList.get(0)).waitAction().release().perform();
	           
			
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
  }

}
