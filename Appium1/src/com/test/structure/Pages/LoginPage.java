package com.test.structure.Pages;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.structure.core.Driver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import net.sourceforge.tess4j.TesseractException;

public class LoginPage extends Driver{

    PageObjects loginPage;


    public LoginPage() throws MalformedURLException {
        super();
        loginPage = new PageObjects();
        PageFactory.initElements(new AppiumFieldDecorator(driver),loginPage);
    }

    public void validateLoginPage() throws InterruptedException, IOException, TesseractException {
    Thread.sleep(3000);
	loginPage.Login.click();		
	
	String csvFile = "F:\\Mobile Testing\\Documents\\LoginData.csv";
    String line = "";
    String cvsSplitBy = ",";
	
	BufferedReader br = new BufferedReader(new FileReader(csvFile));
	br.readLine(); // the header line
	 while ((line = br.readLine()) != null) {
		 
		String[] data = line.split(cvsSplitBy);
		Thread.sleep(3000);
			
		String UNval = data[0];// get username column
		loginPage.username.clear();
		loginPage.username.sendKeys(UNval);
		try{driver.hideKeyboard();
		driver.hideKeyboard();}catch(Exception ex) {}
		
		Thread.sleep(3000);
		String Passval = data[1];// get password column
		loginPage.password.clear();
		//password.sendKeys("");//to clear old values
		loginPage.password.sendKeys(Passval);		
		try{driver.hideKeyboard();//close the popup button and the keyboard
		driver.hideKeyboard();}catch(Exception ex) {}
		
		Thread.sleep(4000);
		
		//press login button
		loginPage.loginbtn.click();
		
		Thread.sleep(4000);
		validateErrorMessages(data);
		
		//validate Error Messages
		
    }  
	 br.close();
}	
    
    private void validateErrorMessages(String[] data) throws TesseractException, InterruptedException {
	
	if(data[6].equals("Invalid")) {
		String eVal = data[2];
		
		//text = eVal;			
		if(getElementbyXpathText(eVal)) { // UNErrorMessage		
			// test pass
    		System.out.println("Correct UN Error Message");
		}
    	else {
    		// fail means either absence of the element or incorrect validation message 
    		if(isPresentByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.RelativeLayout/TextInputLayout[1]/android.widget.LinearLayout/android.widget.TextView"))
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
		if(getElementbyXpathText(data[3])) { // PassErrorMessage		
    		// test pass
    		System.out.println("Correct Password Error Message");
    	}
    	else {
    		// fail means either absence of the element or incorrect validation message 
    		if(isPresentByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.RelativeLayout/TextInputLayout[2]/android.widget.LinearLayout/android.widget.TextView"))
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
		String scrText = readToastMessage();
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
		String scrText = readToastMessage();
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

    class PageObjects {
    	//@iOSFindBy()
    	@AndroidFindBy(id="com.app.pepperfry:id/tv_login")
    	//@FindBy(id = "com.app.pepperfry:id/tv_login")
    	   MobileElement Login;
    	
    	@AndroidFindBy(id = "com.app.pepperfry:id/login_username")
		MobileElement username;		
	
    	@AndroidFindBy(id="com.app.pepperfry:id/login_pwd")
		MobileElement password;		
	
    	@AndroidFindBy(id="com.app.pepperfry:id/login_action_txt")	
		MobileElement loginbtn;

    }
}
