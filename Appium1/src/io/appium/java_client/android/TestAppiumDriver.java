package io.appium.java_client.android;
import java.awt.Point;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;


public class TestAppiumDriver {
	 io.appium.java_client.android.AndroidDriver driver; 
@BeforeMethod
public void setUp() throws MalformedURLException, InterruptedException{
	//Set up desired capabilities and pass the Android app-activity and app-package to Appium
	DesiredCapabilities dc = new DesiredCapabilities();
	
	
	dc.setCapability("deviceName", "2f12d624");
    dc.setCapability("appPackage", "com.app.pepperfry");
    dc.setCapability("appActivity", ".home.main.ui.SplashScreenActivity");
    dc.setCapability("platformName","Android");
        
    driver = new io.appium.java_client.android.AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
    
    //mDriver = new io.appium.java_client.android.AndroidDriver<>((dc);
    
    driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
	Thread.sleep(10000);
	
  }

@Test
public void testCal() throws Exception {
	  /*
	//press skip
	Thread.sleep(4000);
	driver.tap(1, driver.findElement(By.id("com.app.pepperfry:id/tv_skip")), 1);
	
	//press confirm
	Thread.sleep(4000);
	driver.tap(1, driver.findElement(By.id("com.app.pepperfry:id/ar_confirm")), 1);
	
	// press furniture
	Thread.sleep(4000);
	driver.tap(1, driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]")), 1);
	
	//press sofas and laug
	Thread.sleep(4000);
	driver.tap(1, driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[3]/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.ImageView")), 1);
	
// press sofas
	Thread.sleep(4000);
	List<WebElement> li = driver.findElementsByClassName("android.widget.LinearLayout");
	driver.tap(1, li.get(12), 1);
	
	//press on the orange icon
	Thread.sleep(4000);
	driver.tap(1, driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.widget.ImageView[1]")), 1);
	  
	Thread.sleep(4000);
	// press on wallview
	List<WebElement> li_wallwiew = driver.findElementsByClassName("android.widget.TextView");
	driver.tap(1,li_wallwiew.get(1),1);
 	
	Thread.sleep(4000);
	//press on the imageview
	List<WebElement> li_imageViews = driver.findElementsByClassName("android.widget.ImageView");
	driver.tap(1,li_imageViews.get(0),1);
 	
	Thread.sleep(4000);
	//work on the seekbar 
	List<WebElement> li_seeks = driver.findElementsByClassName("android.widget.SeekBar");
	driver.tap(1,li_seeks.get(0),1);
 	

	
	    WebElement seekBar = driver.findElementByClassName("android.widget.SeekBar");
	    //Get start point of seekbar.
	    int startX = seekBar.getLocation().getX();
	    System.out.println(startX);
	    //Get end point of seekbar.
	    int endX = seekBar.getSize().getWidth();
	    System.out.println(endX);
	    //Get vertical location of seekbar
	    int yAxis = seekBar.getLocation().getY();
	    //Set slidebar move to position.
	    // this number is calculated based on (offset + 3/4width)
	    int moveToXDirectionAt = 786;
	    System.out.println("Moving seek bar at " + moveToXDirectionAt+" In X direction.");
	    //Moving seekbar using TouchAction class.
	    TouchAction act=new TouchAction(driver);
	    act.press(startX,yAxis).moveTo(moveToXDirectionAt,yAxis).release().perform();
	
	
	
	
	
	
	
	Thread.sleep(4000);
    List<WebElement> li_camera = driver.findElementsByClassName("android.widget.ImageView");
	
    /*WebElement ele_image = li_camera.get(0);

     int x1=  li_camera.get(0).getLocation().getX();
     int y1= li_camera.get(0).getLocation().getY();

     System.out.println("x is "+x1+"y1 is "+y1);

     int x=ele_image.getLocation().getX()+ele_image.getSize().getWidth()/2;
     int y= ele_image.getLocation().getY()+ele_image.getSize().getHeight()/2;

     //Zoom
     TouchAction finger1= new TouchAction(driver);
     finger1.press(ele_image, x, y-20).moveTo(ele_image, x, y-200);

     TouchAction finger2= new TouchAction(driver);
     finger2.press(ele_image, x, y+20).moveTo(ele_image, x, y+200);

     MultiTouchAction action= new MultiTouchAction(driver);
     action.add(finger1).add(finger2).perform();

     Thread.sleep(8000);

     //Pinch
     TouchAction finger3= new TouchAction(driver);
     finger3.press(ele_image, x, y-200).moveTo(ele_image, x, y-20);

     TouchAction finger4= new TouchAction(driver);
     finger4.press(ele_image, x, y+200).moveTo(ele_image, x, y+20);

     MultiTouchAction action2= new MultiTouchAction(driver);
     action2.add(finger3).add(finger4).perform();
	 --------
	 
	 
	 
	// clicking on camera button 

	 driver.tap(1, li_camera.get(2), 1);
		
   */
   
	}

//

@AfterMethod
public void teardown(){
	//close the app
	driver.quit();
}



















}