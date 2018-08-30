package io.appium.java_client.android;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;


public class TestSeek {
	AndroidDriver driver;
	// io.appium.java_client.android.AndroidDriver<WebElement> mDriver; 
@BeforeMethod
public void setUp() throws MalformedURLException, InterruptedException{
	//Set up desired capabilities and pass the Android app-activity and app-package to Appium
	DesiredCapabilities dc = new DesiredCapabilities();
	
	
	dc.setCapability("deviceName", "2f12d624");
    dc.setCapability("appPackage", "com.app.pepperfry");
    dc.setCapability("appActivity", ".home.main.ui.SplashScreenActivity");
    dc.setCapability("platformName","Android");
    
    driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), dc);
    
    //mDriver = new io.appium.java_client.android.AndroidDriver<>((dc);
    
    driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
	Thread.sleep(10000);
	
  }

@Test
public void testCal() throws Exception {
	WebDriverWait wait = new WebDriverWait(driver,20);
	   
	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("com.app.pepperfry:id/tv_skip"))));

	WebElement skip=driver.findElement(MobileBy.id("com.app.pepperfry:id/tv_skip"));
	skip.click();
	
	 driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		Thread.sleep(10000);
		
	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("com.app.pepperfry:id/ar_confirm"))));

   WebElement confirmGo=driver.findElement(MobileBy.id("com.app.pepperfry:id/ar_confirm"));
   confirmGo.click();

   driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
  	Thread.sleep(10000);
  	
  wait.until(ExpectedConditions.visibilityOf(driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]"))));
 
   WebElement furniture=driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]"));
   furniture.click();
  
   
   driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
  	Thread.sleep(10000);
  	
   wait.until(ExpectedConditions.visibilityOf(driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[3]/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.ImageView"))));
   
   WebElement sofas_Loung=driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[3]/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.ImageView"));
   sofas_Loung.click();
   
   driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
  	Thread.sleep(10000);
  	
  	
  	//WebElement abc = driver.findElement(MobileBy.xpath("=/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]"));
  	//int x = abc.getLocation().getX();
  	//int y = abc.getLocation().getY();

  	//TouchAction action = new TouchAction((MobileDriver)driver);
  	//action.press(x,y).moveTo(x+90,y).release().perform();
  	
  	// clicking on sofas 
  	 List<WebElement> li = driver.findElementsByClassName("android.widget.LinearLayout");
	 li.get(12).click();
	
	 
	 
  	
  	
   //wait.until(ExpectedConditions.visibilityOf(driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]"))));
                                                                                 

   //WebElement sofas=driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]"));
   //sofas.click();
   
   
   driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
 	Thread.sleep(10000);
 	
 		   
 	wait.until(ExpectedConditions.visibilityOf(driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.widget.ImageView[1]"))));
   
   WebElement imageIcon=driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.widget.ImageView[1]"));
   imageIcon.click();	   
		   

  
   
	
	 List<WebElement> li_camera = driver.findElementsByClassName("android.widget.ImageView");
	
	 
	 WebElement ele_image = li_camera.get(0);

/*
     int x1= ele_image.getLocation().getX();
     int y1= ele_image.getLocation().getY();

     System.out.println("x is "+x1+"y1 is "+y1);

     int x=ele_image.getLocation().getX()+ele_image.getSize().getWidth()/2;
     int y= ele_image.getLocation().getY()+ele_image.getSize().getHeight()/2;

     //Zoom
     TouchAction finger1= new TouchAction(mDriver);
     finger1.press(ele_image, x, y-20).moveTo(ele_image, x, y-200);

     TouchAction finger2= new TouchAction(mDriver);
     finger2.press(ele_image, x, y+20).moveTo(ele_image, x, y+200);

     MultiTouchAction action= new MultiTouchAction(mDriver);
     action.add(finger1).add(finger2).perform();

     Thread.sleep(8000);

     //Pinch
     TouchAction finger3= new TouchAction(mDriver);
     finger3.press(ele_image, x, y-200).moveTo(ele_image, x, y-20);

     TouchAction finger4= new TouchAction(mDriver);
     finger4.press(ele_image, x, y+200).moveTo(ele_image, x, y+20);

     MultiTouchAction action2= new MultiTouchAction(mDriver);
     action2.add(finger3).add(finger4).perform();
	 */
	 
	 
	 
	// clicking on camera button 
	 li_camera.get(2).click();
	
	 
   
   
	}

//

@AfterMethod
public void teardown(){
	//close the app
	driver.quit();
}


}