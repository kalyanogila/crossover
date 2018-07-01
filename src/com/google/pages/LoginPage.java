package com.google.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.ClickElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.base.BaseTest;

public class LoginPage extends BaseTest {

	@FindBy(xpath="//input[@type='email']")
	WebElement email;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//div[@id='identifierNext']/content/span")
	WebElement emailNext;
	
	@FindBy(xpath="//div[@id='passwordNext']/content")
	WebElement passwordNext;
	
	Logger log;
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
		log= Logger.getLogger(LoginPage.class);
	}
	
	
	public void setEmail(String emailid)
	{
		try {
			type(email,emailid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void setPassword(String userpassword)
	{
		try {
			type(password,userpassword);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void clickOnEmailNext(String emailid)
	{
		try {
			setEmail(emailid);
			clickOnElement(emailNext);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public EmailDetailsPage clickOnPasswordNext(String userpassword)
	{
		try {
			setPassword(userpassword);
			clickOnElement(passwordNext);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			return new EmailDetailsPage();
		}
	}
	
	
	
	
	
	
}
