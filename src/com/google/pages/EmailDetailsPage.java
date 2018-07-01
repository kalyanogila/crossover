package com.google.pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.google.base.BaseTest;

public class EmailDetailsPage extends BaseTest {

	@FindBy(xpath="//div[text()='COMPOSE']")
	WebElement compose;
	
	@FindBy(xpath="//textarea[@name='to']")
	WebElement to;
	
	@FindBy(xpath="//input[@placeholder='Subject']")
	WebElement subject;
	
	@FindBy(xpath="//div[@aria-label='Message Body']")
	WebElement body;
	
	@FindBy(xpath="//div[text()='Send']")
	WebElement send;
	
	
	Logger log;
	
	public EmailDetailsPage()
	{
		PageFactory.initElements(driver, this);
		log= Logger.getLogger(EmailDetailsPage.class);	
	}
	
	
	public void clickCompose()
	{
		try {
			
		clickOnElement(compose);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void setTo(String emailid)
	{
		try {
			type(to,emailid);
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	
	public void setSubject(String setSubject)
	{
		try {
			type(subject,setSubject);
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	
	public void setBody(String setBody)
	{
		try {
			type(body,setBody);
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	
	public void clickSend()
	{
		try {
			clickOnElement(send);
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	
	public  ValidateEmail clickOnEmail(String subject)
	{
		try {
			
			List<WebElement> elements=getElements("//td[@class='xY a4W']/div/descendant::span[@class='bog']");
			
			for(WebElement ele:elements)
			{
				
				if(ele.getText().equalsIgnoreCase(subject))
						ele.click();
			}
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return new ValidateEmail();
	}
	
	
	

}
