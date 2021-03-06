package com.test.pepperfry;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.util.LoadLibs;

public class Initialization {
	 public AndroidDriver driver; 
	 DesiredCapabilities dc;
	 static String scrShotDir = "screenshots";
	  File scrFile;
	  static File scrShotDirPath = new java.io.File("./"+ scrShotDir+ "//");
	  String destFile;
	  
	 public Initialization(String deviceName,String appPackage,String appActivity,String platformName, String URL) throws MalformedURLException, InterruptedException {
		dc = new DesiredCapabilities();
		
		dc.setCapability("deviceName", deviceName);
		dc.setCapability("udid", deviceName);
	    dc.setCapability("appPackage", appPackage);
	    dc.setCapability("appActivity", appActivity);
	    dc.setCapability("platformName",platformName);
	    driver = new io.appium.java_client.android.AndroidDriver<>(new URL(URL), dc);
		   
		/*dc.setCapability("deviceName", "2f12d624");
	    dc.setCapability("appPackage", "com.app.pepperfry");
	    dc.setCapability("appActivity", ".home.main.ui.SplashScreenActivity");
	    dc.setCapability("platformName","Android");
	       
	    driver = new io.appium.java_client.android.AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
	    */
	    driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		Thread.sleep(10000);
	 }
	 public MobileElement getElementbyNameIndex(String elemTypeClassName, int elementIndex) throws InterruptedException {
		 List<MobileElement> lst = driver.findElements(MobileBy.className(elemTypeClassName));		
		 return lst.get(elementIndex);
	 }
	 public boolean getElementbyXpathText(String text) throws InterruptedException {
		 try {
			 driver.findElementByXPath("//android.widget.TextView[@text='"+ text +"']");	
			 return true;
		 }
		 catch(Exception e) {
			 return false;
		 }
	 }
	 public boolean getButtonbyXpathText(String text) throws InterruptedException {
		 try {
			 driver.findElementByXPath("//android.widget.Button[@text='"+ text +"']");	
			 return true;
		 }
		 catch(Exception e) {
			 return false;
		 }
	 }
	 public void tapButtonElementbyXpathText(String text) throws InterruptedException {
			 driver.findElementByXPath("//android.widget.Button[@text='"+ text +"']").click();	
	 }
	 public void tapTextViewElementbyXpathText(String text) throws InterruptedException {
		 driver.findElementByXPath("//android.widget.TextView[@text='"+ text +"']").click();	
 }
	 public boolean isPresentByXpath (String xpath) {
		 try{
			 driver.findElementByXPath(xpath);	
			 return true;
		 }
		 catch(Exception e){
			 return false;
		 }
		 
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
	//driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
	
      String imgName = takeScreenShot();
      imgName = takeScreenShot();
      imgName = takeScreenShot();
      imgName = takeScreenShot();
      imgName = takeScreenShot();
      imgName = takeScreenShot();
      imgName = takeScreenShot();
      imgName = takeScreenShot();
      imgName = takeScreenShot();
      
      String result = null;
	  File imageFile = new File(scrShotDirPath, imgName);
	  System.out.println("Image name is :" + imageFile.toString());
	  ITesseract instance = new Tesseract();
	  //instance.setLanguage("ara");
	  
	  File tessDataFolder = LoadLibs.extractTessResources("tessdata"); // Extracts
	  instance.setDatapath(tessDataFolder.getAbsolutePath()); // sets tessData
	  result = instance.doOCR(imageFile);
	  System.out.println(result);
	  return result;
	 }

	 public boolean compareTwoLists (List<String> old , List<String> newL) {
		 if(old.size() != newL.size())
			 return false;
		 
		 for(int i=0;i<old.size();i++) {
			 String oldVal = old.get(i);
			 String newVal = newL.get(i);
			 if(! oldVal.equals(newVal)) {
				 return false;
			 }
		 }
		 
		 return true;
	 }


}

