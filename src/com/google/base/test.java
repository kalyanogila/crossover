package com.google.base;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class test {

	private static String date1="";
	private static String subject="";
	private static String body="";
	public static void navigate() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","C:\\workspace\\crossover\\lib\\chromedriver.exe");
		WebDriver driver=null;
		
		 driver=new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("http://www.gmail.com/");
		//Thread.sleep(5000);
		
		
		
		WebElement element=driver.findElement(By.xpath("//input[@type='email']"));
		
		 element.sendKeys("usercrossovertest1");
		
		 element=driver.findElement(By.xpath("//div[@id='identifierNext']/content/span"));
			
		 element.click();
		 Thread.sleep(5000);
		 element=driver.findElement(By.xpath("//input[@name='password']"));
		 
		 element.sendKeys("usercrossovertest123");
		

		 element=driver.findElement(By.xpath("//div[@id='passwordNext']/content"));
			
		 element.click();
		 Thread.sleep(8000);
		  element=driver.findElement(By.xpath("//div[text()='COMPOSE']"));
		 element.click();
		 
		 element=driver.findElement(By.xpath("//textarea[@name='to']"));
		 element.sendKeys("usercrossovertest1@gmail.com");
		 
		 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			date1=dateFormat.format(date);
			element=driver.findElement(By.xpath("//input[@placeholder='Subject']"));
			subject="subject"+date1;
			 element.sendKeys(subject);
		 element=driver.findElement(By.xpath("//div[@aria-label='Message Body']"));
		 body="body"+date1;
		 element.sendKeys(body);
		 
		 element=driver.findElement(By.xpath("//div[text()='Send']"));
		 element.click();
		 
Thread.sleep(10000);
		 
		 driver.close();
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		navigate();
		System.setProperty("webdriver.chrome.driver","C:\\workspace\\crossover\\lib\\chromedriver.exe");
		WebDriver driver=null;
		
		 driver=new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("http://www.gmail.com/");
		//Thread.sleep(5000);
		
		
		
		WebElement element=driver.findElement(By.xpath("//input[@type='email']"));
		
		 element.sendKeys("usercrossovertest1");
		
		 element=driver.findElement(By.xpath("//div[@id='identifierNext']/content/span"));
			
		 element.click();
		 Thread.sleep(5000);
		 element=driver.findElement(By.xpath("//input[@name='password']"));
		 
		 element.sendKeys("usercrossovertest123");
		

		 element=driver.findElement(By.xpath("//div[@id='passwordNext']/content"));
			
		 element.click();
		 Thread.sleep(8000);
		 
		
		 
		//div[@class='a1 aaA aMZ']
		 
		 //System.out.println("//table/tbody/tr/descendant::span[contains(text(),'"+date1+"')]");
		// element=driver.findElement(By.xpath("//table/tbody/tr/descendant::span[contains(text(),'"+date1+"')]"));
		 
		// element=driver.findElement(By.xpath("//table/tbody/tr/td/descendant::span[contains(text(),'subject2018/07/01 04:13:03')]"));
		 
		 element=driver.findElements(By.xpath("//span[@class='bog']")).get(1);
		 
		 Thread.sleep(10000);
		 
		 
		List<WebElement> elements=driver.findElements(By.xpath("//td[@class='xY a4W']/div/descendant::span[@class='bog']"));
		 
		
		for(WebElement ele:elements)
		{
			System.out.println(ele.getText());
			if(ele.getText().equalsIgnoreCase(subject))
					ele.click();
		}
			
		
	/*	 Wait<WebDriver> stubbornWait = new FluentWait<WebDriver>(driver)
				    .withTimeout(30, TimeUnit.SECONDS)
				    .pollingEvery(5, TimeUnit.SECONDS)
				    .ignoring(NoSuchElementException.class)
				    .ignoring(StaleElementReferenceException.class);

	stubbornWait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("//table/tbody/tr/td/descendant::span[contains(text(),'subject2018/07/01 04:13:03')]"))));
				
		*/	
		/*  WebDriverWait wait = new WebDriverWait(driver, 15);
		    wait.until(ExpectedConditions.visibilityOf(element));
		 
int attempts = 0;
    while(attempts < 2) {
        try {
           element.click();
           
            break;
        } catch(StaleElementReferenceException e) {
        }
        attempts++;
    }*/
   // element.click();
	 Thread.sleep(10000);  
		element=driver.findElement(By.xpath("//table[@role='presentation']/tr/td/descendant::div[contains(text(),'body')]"));
		
		if(element.getText().equalsIgnoreCase(body))
			System.out.println(element.getText());  
		
		
	element=driver.findElement(By.xpath("//table[@role='presentation']/tr/td/descendant::h2[contains(text(),'subject')]"));
	if(element.getText().equalsIgnoreCase(subject))
		System.out.println(element.getText());  
		

	}

}
