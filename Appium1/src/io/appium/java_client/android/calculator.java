package io.appium.java_client.android;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.android.AndroidDriver;
//import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.util.LoadLibs;

public class calculator {
	AndroidDriver driver;
	 static String scrShotDir = "screenshots";
	  File scrFile;
	  static File scrShotDirPath = new java.io.File("./"+ scrShotDir+ "//");
	  String destFile;
	  
@BeforeClass
public void setUp() throws MalformedURLException{
	//Set up desired capabilities and pass the Android app-activity and app-package to Appium
	DesiredCapabilities dc = new DesiredCapabilities();
	
	
	dc.setCapability("deviceName", "2f12d624");
    dc.setCapability("appPackage", "dev.team.spark.docontact");
    dc.setCapability("appActivity", ".LoginActivity");
	//  dc.setCapability("appPackage", "com.sourcey.materialloginexample");
     //dc.setCapability("appActivity", "com.sourcey.materiallogindemo.LoginActivity");
	 
    dc.setCapability("platformName","Android");
    
    
    driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), dc);
  //  driver.setLogLevel(Level.INFO);

	
	//capabilities.setCapability("BROWSER_NAME", "Android");
	//capabilities.setCapability("VERSION", "7.0"); 
	//capabilities.setCapability("deviceName","2f12d624");
	
   
   //capabilities.setCapability("appPackage", "dev.team.spark.docontact");
// This package name of your app (you can get it from apk info app)
	//capabilities.setCapability("appActivity","dev.team.spark.docontact.LoginActivity"); // This is Launcher activity of your app (you can get it from apk info app)
//Create RemoteWebDriver instance and connect to the Appium server
 //It will launch the Calculator App in Android Device using the configurations specified in Desired Capabilities
   
    //driver = new RemoteWebDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
}

@Test
public void testCal() throws Exception {
   //locate the Text on the calculator by using By.name()
	
  /* WebElement username=driver.findElement(By.id("dev.team.spark.docontact:id/email"));
   username.sendKeys("nehal.magdy@spark-sol.com");
   WebElement pass=driver.findElement(By.id("dev.team.spark.docontact:id/password"));
   pass.sendKeys("test1991");
   driver.navigate().back();
*/
   WebElement login=driver.findElement(By.id("dev.team.spark.docontact:id/email_sign_in_button"));
   login.click();
 
   driver.navigate().back();
   driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
   
	//driver.manage().timeouts().wait();
		
	

//driver.findElement(By.linkText("البريد الالكترونى غير صحيح"));
	
	

	/*WebElement username=driver.findElement(By.id("com.sourcey.materialloginexample:id/input_email"));
	   username.sendKeys("nehal");
	   WebElement pass=driver.findElement(By.id("com.sourcey.materialloginexample:id/input_password"));
	   pass.sendKeys("tes");
	  
	   //to close the keyboard 
	   driver.navigate().back();
	   
	WebElement login=driver.findElement(By.id("com.sourcey.materialloginexample:id/btn_login"));
	   login.click();
	 
	   driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
*/
	   try {
			driver.findElementByXPath("//*[@text='هذا الحقل مطلوب']");
			System.out.println("exist");
			}
			catch(Exception ex){
				System.out.println("doesn't appear");
			}

	   
   readToastMessage();
}

//

@AfterClass
public void teardown(){
	//close the app
	driver.quit();
}


public String takeScreenShot() {
	  File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); 
	  
	  SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
	  new File(scrShotDir).mkdirs(); // Create folder under project with name
	          // "screenshots" if doesn't exist
	  destFile = dateFormat.format(new Date()) + ".png"; // Set file name
	               // using current
	               // date time.
	  try {
	   FileUtils.copyFile(scrFile, new File(scrShotDir + "/" + destFile)); // Copy
	                    // paste
	                    // file
	                    // at
	                    // destination
	                    // folder
	                    // location
	  } catch (IOException e) {
	   System.out.println("Image not transfered to screenshot folder");
	   e.printStackTrace();
	  }
	  return destFile;
	 }


public String readToastMessage() throws TesseractException  
{
	driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	String imgName = takeScreenShot();
	//imgName = takeScreenShot();
	  String result = null;
	  File imageFile = new File(scrShotDirPath, imgName);
	  System.out.println("Image name is :" + imageFile.toString());
	  ITesseract instance = new Tesseract();

	  //instance.setDatapath("F:\\Mobile Testing\\appium\\tessdata");


	  instance.setLanguage("ara");
	  
	  File tessDataFolder = LoadLibs.extractTessResources("tessdata"); // Extracts
	                   // Tessdata
	                   // folder
	                   // from
	                   // referenced
	                   // tess4j
	                   // jar
	                   // for
	                   // language
	                   // support
	  instance.setDatapath(tessDataFolder.getAbsolutePath()); // sets tessData
	                // path 
	  
	  result = instance.doOCR(imageFile);
	  System.out.println(result);
	  return result;
	 }





}