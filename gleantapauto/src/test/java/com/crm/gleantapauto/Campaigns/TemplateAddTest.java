package com.crm.gleantapauto.Campaigns;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.crm.gleantapauto.pageobjects.WorkroomObjects;
import com.crm.gleantapauto.testscomponents.BaseTest;


public class TemplateAddTest extends BaseTest {
	
	@Test
public void addTemplate() throws Exception
{
		try {
	WorkroomObjects Wobj =logOb.loginApplication("Sagar@gleantap.com", "Select!8583");
	Wobj.FindWorkrooms();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.findElement(By.xpath("(.//a/span[contains(text(),'Campaigns')])[1]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath(".//span[contains(text(),'Templates')]")).click();
	driver.findElement(By.xpath(".//*[@class='btn btn-success']/i")).click();
	WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(30));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[contains(text(),' Select Foundation Template')]")));
	WebElement NewTemplate= driver.findElement(By.xpath("(.//figcaption)[1]"));
	Actions action=new Actions(driver);
	action.moveToElement(NewTemplate);
	action.release();
	driver.findElement(By.xpath("(//a[contains(text(),'Design From Scratch')])[1]")).click();
	
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//h1[@class='page-title']")));
	
	driver.findElement(By.xpath(".//input[@id='template_name']")).sendKeys("Automation-Template-for-titleAndParagraph");
	System.out.println("Entered Template Name");
	WebElement frame=driver.findElement(By.xpath(".//*[@id='bee-plugin-container']/iframe"));
	driver.switchTo().frame(frame);
	//AddTitle();
	//AddParagraph();
	AddMultipleContents();
	  WebElement element = driver.findElement(By.xpath(".//span[contains(text(),'SAVE')]"));
		
			Actions actions = new Actions(driver);
			actions.moveToElement(element).perform();    
	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//span[contains(text(),'SAVE')]")));
	 
	   if(driver.findElement(By.xpath(".//span[contains(text(),'SAVE')]")).isDisplayed())
	   {
     	  WebElement elementclick = driver.findElement(By.xpath(".//span[contains(text(),'SAVE')]"));
     	  JavascriptExecutor executor = (JavascriptExecutor)driver;
  		executor.executeScript("arguments[0].click();", elementclick);
  		System.out.println("Saved the Page");
     	   Thread.sleep(2000);
     	   //driver.switchTo().alert().accept();
     	   System.out.println("Clicked on Ok");
	   }
	   else {
		   System.out.println("Not able to click on Save button");
	   }
     	
     		
     	 
	}
		catch(Exception e)
		{
			System.out.println("Exception found"+e);
		}
}
 public void AddTitle() throws InterruptedException
 {
	 WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(30));
	 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@class='modules-wrapper undefined']/span[1]/div/div")));
		
		WebElement element = driver.findElement(By.xpath(".//*[@class='modules-wrapper undefined']/span[8]/div/div"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	  	WebElement pagetype= driver.findElement(By.xpath(".//*[@class='modules-wrapper undefined']/span[8]/div/div"));
		 
	     WebElement dropPage= driver.findElement(By.xpath(".//*[@role='presentation' and @class='undefined stageContent']/div/div/div[4]/div/div")); 
	    
	    
	     Actions builder=new Actions(driver);
	     
		   Thread.sleep(2000);
	  	 
		   builder.clickAndHold(pagetype).moveToElement(dropPage).release().build().perform();
 }
 public void AddParagraph() throws InterruptedException
 {
	
		 WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(30));
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@class='modules-wrapper undefined']/span[1]/div/div")));
		
	  	WebElement pagetype= driver.findElement(By.xpath(".//*[@class='modules-wrapper undefined']/span[2]/div/div"));
		 
	     WebElement dropPage= driver.findElement(By.xpath(".//*[@role='presentation' and @class='undefined stageContent']/div/div/div[4]/div/div")); 
	    
	    
	     Actions builder=new Actions(driver);
	     
		   Thread.sleep(2000);
	  	 
		   builder.clickAndHold(pagetype).moveToElement(dropPage).release().build().perform();
	 
 }
 
 public void AddMultipleContents() throws InterruptedException
 {
	 WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(30));
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@class='modules-wrapper undefined']/span/div/div"))); 
	 
	
	List<WebElement> content =driver.findElements(By.xpath(".//*[@class='modules-wrapper undefined']/span/div/div"));
	int i=content.size();
	System.out.println("Size of contents"+i);
	for(int j=1;j<=i;j++)
	{
		if(j==7)
		{
			WebElement element =driver.findElement(By.xpath(".//*[@class='modules-wrapper undefined']/span[" +j+"]/div/div"));
			((JavascriptExecutor)
				 driver).executeScript("arguments[0].scrollIntoView(true);", element);
			Actions actions = new Actions(driver); actions.moveToElement(element).perform();
		}

	
	  	WebElement pagetype= driver.findElement(By.xpath(".//*[@class='modules-wrapper undefined']/span["+j+"]/div/div"));
		 
	     WebElement dropPage= driver.findElement(By.xpath(".//*[@role='presentation' and @class='undefined stageContent']/div/div/div[4]/div/div")); 
	     Actions builder=new Actions(driver);
	     
		  // Thread.sleep(2000);
	  	 //builder.moveToElement(pagetype).click().build().perform();
	     builder.clickAndHold(pagetype).moveToElement(dropPage).release().build().perform();
		   System.out.println("content-->"+pagetype.getText());
		   
		
		 
			
	}
 }
}
