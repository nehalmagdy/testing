package com.test.structure.core;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.test.pepperfry.ConfigFileReader;

import io.appium.java_client.android.AndroidDriver;

public class BaseSetup {
	
	 private static AndroidDriver driver; 
	 private static DesiredCapabilities dc;

    @BeforeClass (alwaysRun=true)
    public static void setup() throws MalformedURLException{
        initDriver();
    }

    public static AndroidDriver getDriver() throws MalformedURLException {
    	//setup();
        return driver;
    }

    private static void initDriver() throws MalformedURLException{
        System.out.println("Inside initDriver method");

        dc = new DesiredCapabilities();
		
        ConfigFileReader r = new ConfigFileReader();		 
	  
		dc.setCapability("deviceName", r.getudid());
		dc.setCapability("udid", r.getudid());
	    dc.setCapability("appPackage", r.getAppPackage());
	    dc.setCapability("appActivity", r.getAppActivity());
	    dc.setCapability("platformName",r.getPlatformName());
	    driver = new io.appium.java_client.android.AndroidDriver<>(new URL(r.getApplicationUrl()), dc);
    }

    @AfterClass (alwaysRun=true)
    public static void tearDown(){
        driver.quit();
    }
	
    //@Override
    //protected void finalize() throws Throwable {
    	/// TODO Auto-generated method stub
    	//tearDown();
    //}
}
