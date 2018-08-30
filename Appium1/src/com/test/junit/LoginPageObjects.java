package com.test.junit;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.pepperfry.ConfigFileReader;
import com.test.pepperfry.Initialization;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import net.sourceforge.tess4j.TesseractException;

public class LoginPageObjects {
	
	Initialization ini;
	
	@FindBy(id = "com.app.pepperfry:id/tv_login")
   MobileElement Login;

	@FindBy(id = "com.app.pepperfry:id/login_username")
	MobileElement username;
	
	@FindBy(id="com.app.pepperfry:id/login_pwd")
	MobileElement password;
	
	@FindBy(id="com.app.pepperfry:id/login_action_txt")	
	MobileElement loginbtn;
	
/*	//final String text="";
	
	//@FindBy(xpath="//android.widget.TextView[@text='"+ text +"']")
	//MobileElement UNError;	
	
	//@FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.RelativeLayout/TextInputLayout[1]/android.widget.LinearLayout/android.widget.TextView")
	//MobileElement UNErrorField;
	
	//final String ptext="";
	
	//@FindBy(xpath="//android.widget.TextView[@text='"+ ptext +"']")
	//MobileElement passError;
	
	//@FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.RelativeLayout/TextInputLayout[2]/android.widget.LinearLayout/android.widget.TextView")
	//MobileElement passErrorField;
	*/

	public LoginPageObjects() throws MalformedURLException, InterruptedException {
		ConfigFileReader r = new ConfigFileReader();		 
		ini = new Initialization(r.getudid(), r.getAppPackage(),r.getAppActivity(),r.getPlatformName(),r.getApplicationUrl());
        PageFactory.initElements(new AppiumFieldDecorator(ini.driver),this);
    }
	
	public void test() throws IOException, InterruptedException, TesseractException {		
	
		Login.click();		
		
		String csvFile = "F:\\Mobile Testing\\Documents\\LoginData.csv";
        String line = "";
        String cvsSplitBy = ",";
		
		BufferedReader br = new BufferedReader(new FileReader(csvFile));
		br.readLine(); // the header line
		 while ((line = br.readLine()) != null) {
			 
			String[] data = line.split(cvsSplitBy);
			Thread.sleep(3000);
				
			String UNval = data[0];// get username column
			username.clear();
			//username.sendKeys("");
			username.sendKeys(UNval);
			try{ini.driver.hideKeyboard();
			ini.driver.hideKeyboard();}catch(Exception ex) {}
			
			Thread.sleep(3000);
			String Passval = data[1];// get password column
			password.clear();
			//password.sendKeys("");//to clear old values
			password.sendKeys(Passval);		
			try{ini.driver.hideKeyboard();//close the popup button and the keyboard
			ini.driver.hideKeyboard();}catch(Exception ex) {}
			
			Thread.sleep(4000);
			
			//press login button
			loginbtn.click();
			
			Thread.sleep(4000);
			validateErrorMessages(data);
			
			//validate Error Messages
			
	    }  
		 br.close();
	}	
	public void validateErrorMessages(String[] data) throws TesseractException, InterruptedException {
		
		if(data[6].equals("Invalid")) {
			String eVal = data[2];
			
			//text = eVal;			
			if(ini.getElementbyXpathText(eVal)) { // UNErrorMessage		
				// test pass
	    		System.out.println("Correct UN Error Message");
			}
	    	else {
	    		// fail means either absence of the element or incorrect validation message 
	    		if(ini.isPresentByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.RelativeLayout/TextInputLayout[1]/android.widget.LinearLayout/android.widget.TextView"))
		    	{
	    			System.out.println("InCorrect UN Error Message, it should be"+data[2]);
	    		}
	    		else {
	    			// if cell value is empty then correct else incorrect error message 
	    			if(data[2].equals("")) {
	    				System.out.println("Correct");
	    			}
	    			else {
	    				System.out.println("InCorrect UN Error Message, it should be"+data[2]);
	    			}		    			
	    		}		    		
	    	}
		    
			//ptext=data[3];
			if(ini.getElementbyXpathText(data[3])) { // PassErrorMessage		
	    		// test pass
	    		System.out.println("Correct Password Error Message");
	    	}
	    	else {
	    		// fail means either absence of the element or incorrect validation message 
	    		if(ini.isPresentByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.RelativeLayout/TextInputLayout[2]/android.widget.LinearLayout/android.widget.TextView"))
		    	{
	    			System.out.println("InCorrect Password Error Message, it should be"+data[3]);
	    		}
	    		else {
	    			// if excel is empty then correct else incorrect error message 
	    			if(data[3].equals("")) {
	    				System.out.println("Correct");
	    			}
	    			else {
	    				System.out.println("InCorrect Password Error Message, it should be"+data[3]);
	    			}		    			
	    		}		    		
	    	}
		}
		else if(data[6].equals("InvalidP")) {
			String scrText = ini.readToastMessage();
    		String msg = data[4];
    		if(scrText.contains(msg))
    		{
    			System.out.println("Correct POP Message");
			}
    		else
    		{
    			System.out.println("InCorrect POP Message");
			}
		}
    	else if(data[7].equals("Valid")) { //validate toast message 
    		// i'll need to take screenshot of the toast message to validate it
    		String scrText = ini.readToastMessage();
    		String msg = data[5]+", "+data[6];
    		if(scrText.contains(msg))
    		{
    			System.out.println("Correct Toast Message");
			}
    		else
    		{
    			System.out.println("InCorrect Toast Message");
			}
    	}
	}
}
