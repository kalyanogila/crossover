package com.google.tests;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.base.BaseTest;
import com.google.pages.EmailDetailsPage;
import com.google.pages.LoginPage;
import com.google.pages.ValidateEmail;
import com.sun.jna.platform.win32.OaIdl.VARDESC;

public class EmailTest extends BaseTest{

	LoginPage loginPage;
	Logger log;
	EmailDetailsPage emailDetailsPage;
	ValidateEmail validateEmail;
	
	String date1;
	public EmailTest()
	{
		super();
	}
	
	
	@BeforeMethod
	public void setUp() {
		initialization();
		log=Logger.getLogger(EmailTest.class);
		loginPage = new LoginPage();
		
		
	}
	
	@Test
	public void sendEmail()
	{
		loginPage.clickOnEmailNext(prop.getProperty("emailid1"));
		emailDetailsPage=loginPage.clickOnPasswordNext(prop.getProperty("password1"));
		
		emailDetailsPage.clickCompose();
		
		emailDetailsPage.setTo(prop.getProperty("emailid2"));
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		 date1=dateFormat.format(date);
		String subject="subject"+date1;
		String body="body"+date1;
		
		emailDetailsPage.setSubject(subject);
		emailDetailsPage.setBody(body);
		
		emailDetailsPage.clickSend();
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	@Test
	public void validateSentEmail()
	{
		loginPage.clickOnEmailNext(prop.getProperty("emailid2"));
		emailDetailsPage=loginPage.clickOnPasswordNext(prop.getProperty("password2"));
		
		  validateEmail=emailDetailsPage.clickOnEmail("subject"+date1);
		
		 Assert.assertEquals(validateEmail.getSubject(), "subject"+date1); 
		 Assert.assertEquals(validateEmail.getBody(), "body"+date1); 
		 
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
