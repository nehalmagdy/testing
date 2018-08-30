package com.test.hybrid;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class TestHybrid {

	public static AndroidDriver driver;
	public static DesiredCapabilities cap = new DesiredCapabilities();
 
	@BeforeTest
	public void startAppium() throws MalformedURLException, InterruptedException{
		System.out.println("setUP() :: driver.AndroidDriver() executed");
		//cap.setCapability("platformVersion","4.4.4");
		cap.setCapability("platformName","Android");
		cap.setCapability("deviceName","2f12d624");
		cap.setCapability("appActivity","com.snc.test.webview.activity.MainActivity");
		cap.setCapability("appPackage","com.snc.test.webview2");
		driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"),cap);
	}
	@Test
	public void AppLogin() throws InterruptedException{
	
		//driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]")).click();
		
		Thread.sleep(4000);
		Set<String> availableContexts1 = driver.getContextHandles();
		System.out.println("Total No of Context Found Before reaching WebView = "+ availableContexts1.size());
		System.out.println("Context Name is "+ availableContexts1);
 
		Thread.sleep(4000);
		
		MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("Open navigation drawer");
		el1.click();
		MobileElement el2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.support.v7.widget.LinearLayoutCompat[1]/android.widget.CheckedTextView");
		el2.click();
		MobileElement el3 = (MobileElement) driver.findElementById("com.android.packageinstaller:id/permission_allow_button");
		el3.click();
		el3.click();
		el3.click();
		MobileElement el5 = (MobileElement) driver.findElementById("android:id/button1");
		el5.click();
		
		availableContexts1 = driver.getContextHandles();
		System.out.println("Total No of Context Found Before reaching WebView = "+ availableContexts1.size());
		System.out.println("Context Name is "+ availableContexts1);
 
		for(String context : availableContexts1) {
			if(context.contains("WEBVIEW")){
				System.out.println("Context Name is " + context);
				// 4.3 Call context() method with the id of the context you want to access and change it to WEBVIEW_1
				//(This puts Appium session into a mode where all commands are interpreted as being intended for automating the web view)
				driver.context(context);
				break;
			}
		}

		Thread.sleep(4000);
		
		driver.findElementByXPath("//*[@id='tsf']/div[2]/div[1]/div[1]/div/div[1]/input").clear();
		driver.findElementByXPath("//*[@id='tsf']/div[2]/div[1]/div[1]/div/div[1]/input").sendKeys("Appium Testing");
		driver.findElementByXPath("//*[@id='tsf']/div[2]/div[1]/div[1]/button").click();
	 
	
		// to go back to the Native context
		for(String context : availableContexts1) {
			if(context.contains("NATIVE")){
				System.out.println("We are Back to " + context);
				driver.context(context);				
			}
		}
		
	}
 
	@AfterTest(alwaysRun= true)
	public void tearDown(){
		driver.quit();
		System.out.println("tearDown() :: driver.quit() executed");
	}
	
}
