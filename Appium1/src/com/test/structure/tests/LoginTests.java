package com.test.structure.tests;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.annotations.Test;

import com.test.structure.Pages.LoginPage;
import com.test.structure.core.Driver;

import net.sourceforge.tess4j.TesseractException;

public class LoginTests extends Driver{

    public LoginTests() throws MalformedURLException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Test
    public void testLogin() throws InterruptedException, IOException, TesseractException
    {
        LoginPage loginPage = new LoginPage();
        loginPage.validateLoginPage();
    }
}