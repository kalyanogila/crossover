package com.google.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.base.BaseTest;

public class ValidateEmail extends BaseTest{

	
	@FindBy(xpath="//table[@role='presentation']/tr/td/descendant::div[contains(text(),'body')]")
	WebElement body;
	
	@FindBy(xpath="//table[@role='presentation']/tr/td/descendant::h2[contains(text(),'subject')]")
	WebElement subject;
	
	
	Logger log;
	
	
	public ValidateEmail()
	{
		PageFactory.initElements(driver, this);
		log= Logger.getLogger(ValidateEmail.class);	
	}
	
	public String getSubject()
	{
		return subject.getText();
	}
	
	
	
	public String getBody()
	{
		return body.getText();
		
	}
	
	
}
