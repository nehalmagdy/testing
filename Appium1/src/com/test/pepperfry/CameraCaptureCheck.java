package com.test.pepperfry;
import org.testng.annotations.Test;

import com.lowagie.text.pdf.codec.Base64.InputStream;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileCommand;
import io.appium.java_client.MobileElement;
import net.sourceforge.tess4j.TesseractException;

import org.testng.annotations.Parameters;

import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class CameraCaptureCheck {
	Initialization ini;

	@Test 
  public void f() throws InterruptedException, TesseractException, ParseException {
	  
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
			// press on roomview
			List<MobileElement> li_wallwiew = ini.driver.findElementsByClassName("android.widget.TextView");
			li_wallwiew.get(0).click();
			
			// press the capture button
			List<WebElement> li_camera = ini.driver.findElementsByClassName("android.widget.ImageView");
			li_camera.get(2).click();
			
			// check file existance on device
			String time = ini.driver.getDeviceTime();
		
			String value = ini.readToastMessage();
			if(value.contains("Pic added into your Gallery")) {
				// correct Message
				System.out.println("Correct Message");
			}
			else {
				// wrong
				System.out.println("Wrong Message or not exist");
			}
			
			
			SimpleDateFormat  dtf = new SimpleDateFormat("EEE MMM dd hh:mm:ss z yyyy",Locale.US);  
			Date con = dtf.parse(time);
			dtf = new SimpleDateFormat("yyyy-MM-dd hh:mm a");  
		    String d = dtf.format(con);
		    //String path = "/storage/emulated/0/Pepperfry/"+d+".png";
		    
		    
		    //byte[] imageFile = ini.driver.pullFile(path);
		  
		    
		    byte[]imageFolder = ini.driver.pullFolder("/storage/emulated/0/Pepperfry/");
		    
		    // not all files are retrieved and the names are partially returned (not the whole name !!!) when the name contains ':'
		     
		    ZipInputStream zipStream = new ZipInputStream(new ByteArrayInputStream(imageFolder));
		    ZipEntry entry = null;
		    boolean found = false;
		   try {
				while ((entry = zipStream.getNextEntry()) != null) {

					// the name is returned till the hours only !!, as the : is not accepted in the file name 
					    String entryName = entry.getName();
					    System.out.println(entryName);
					    if(entryName.equals(d+".png")) {
					    	// successs and file is generated in the path
					    	found = true;
					    	break;
					    }				    
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   if(!found) {
			   // file is not generated and failed
			   System.out.println("The file was not generated with the required name");
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
