package com.crm.gleantapauto.FormsPages;

import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.crm.gleantapauto.pageobjects.WorkroomObjects;
import com.crm.gleantapauto.testscomponents.BaseTest;


public class AddFormsTest extends BaseTest{
	String Formname1="AutomationFormNewsletter";
	String Formname2="AutomationLeadCapture";
	String Formname3="FeedbackSurveyForm";
	String Formname4="StartfromScratch";
	
	@Test
	public void CreateFromScratch() throws InterruptedException, IOException, AWTException

	{
		NavigateToForm();
		driver.findElement(By.xpath(".//span[contains(text(),'Start from Scratch')]")).click();
		String form=driver.findElement(By.xpath(".//div[@class='leads-title']")).getText();
		System.out.println("FOrm name"+form);
		if(form.equalsIgnoreCase("Create a Form"))
		{
			driver.findElement(By.xpath(".//input[@name='form-name']")).sendKeys(Formname4);
			driver.findElement(By.xpath(".//input[@name='form-title']")).sendKeys("AutomationTitle");
			driver.findElement(By.xpath(".//input[@name='form-subtitle']")).sendKeys("AutomationSubTitle");
			driver.findElement(By.xpath(".//input[@value='Confirmation message']")).click();
			driver.findElement(By.xpath(".//input[@name='confirm_message']")).sendKeys("Thank you for filling the form");
			WebElement create= driver.findElement(By.xpath(".//h3[contains(text(),'Create')]"));
			Actions action=new Actions(driver);
			action.moveToElement(create);
			driver.findElement(By.xpath(".//input[@id='email-preview']")).click();
			driver.findElement(By.xpath("(.//a[@title='Remove Element'])[1]")).click();
			 Thread.sleep(500);
			driver.findElement(By.xpath("(.//label[contains(text(),'Optin')])[1]")).click();
			driver.findElement(By.xpath("(.//a[@title='Remove Element'])[1]")).click();
			FormControls();
		
		}
}
	public void NavigateToForm()
	{
		WorkroomObjects Wobj =logOb.loginApplication("Sagar@gleantap.com", "Select!8583");
		Wobj.FindWorkrooms();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath(".//span[contains(text(),'Forms & Pages')]")).click();
		driver.findElement(By.xpath(".//a[@class='animsition-link']/child::span[contains(text(),'Forms')]")).click();
		driver.findElement(By.xpath(".//button[@id='fromscratchbtn']")).click();
		
	}
	public void FormControls() throws InterruptedException, AWTException
	{
		Actions action=new Actions(driver);
		List<WebElement> formelements= driver.findElements(By.xpath(".//*[@class='frmb-control ui-sortable']/li"));
	   	 int i=formelements.size();
	   	 System.out.println("size"+ i);
        for(int j=1;j<=i;j++)
        {
           if(j==22)
           {
        	 System.out.println("Skipping the signature part");  
           }
           else {
       	   WebElement form= driver.findElement(By.xpath(".//*[@class='frmb-control ui-sortable']/li["+j+"]"));
       	   action.moveToElement(form);
       	   form.click();
       	  
           }
       		
       	 }
         
        
        action.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).perform();
        Thread.sleep(5000);
        WebElement save= driver.findElement(By.xpath(".//*[@id='save_form']"));
       save.click();
       
       WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@class='leads-title']")));
       String formtext=driver.findElement(By.xpath(".//*[@class='leads-title']")).getText();
       System.out.println("Saving The form"+ formtext);
       Thread.sleep(1000);
       action.sendKeys(Keys.HOME).build().perform();
       driver.findElement(By.xpath(".//*[@id='save_form']")).click();
       WebElement close= driver.findElement(By.xpath(".//span[contains(text(),'Your form has been successfully created.')]//following-sibling::button"));
       close.click();
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@class='campaigns-list']")));
       String Automatedform=driver.findElement(By.xpath(".//*[@class='campaign-title'][1]/a")).getText();
       if(Automatedform.equalsIgnoreCase(Formname4))
       {
    	   System.out.println("Form Created sucessfully");
       }
      
       
	}

	@Test
	public void leadCaptureForm() throws InterruptedException


	{
		NavigateToForm();
		driver.findElement(By.xpath(".//span[contains(text(),'Lead Capture')]")).click();
		String form=driver.findElement(By.xpath(".//div[@class='leads-title']")).getText();
		System.out.println("FOrm name"+form);
		if(form.equalsIgnoreCase("Create a Form"))
		{
			driver.findElement(By.xpath(".//input[@name='form-name']")).sendKeys(Formname2);
			driver.findElement(By.xpath(".//input[@name='form-title']")).sendKeys("AutomationTitle");
			driver.findElement(By.xpath(".//input[@name='form-subtitle']")).sendKeys("AutomationSubTitle");
			driver.findElement(By.xpath(".//input[@value='Confirmation message']")).click();
			driver.findElement(By.xpath(".//input[@name='confirm_message']")).sendKeys("Thank you for filling the form");
			WebElement create= driver.findElement(By.xpath(".//h3[contains(text(),'Create')]"));
			Actions action=new Actions(driver);
			action.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).perform();
	        Thread.sleep(5000);
	        WebElement save= driver.findElement(By.xpath(".//*[@id='save_form']"));
	       //action.moveToElement(save);
	       save.click();
	       
	       WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@class='leads-title']")));
	       String formtext=driver.findElement(By.xpath(".//*[@class='leads-title']")).getText();
	       System.out.println("Saving The form"+ formtext);
	       action.sendKeys(Keys.HOME).build().perform();
	       driver.findElement(By.xpath(".//*[@id='save_form']")).click();
	       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@class='campaigns-list']")));
	       String Automatedform=driver.findElement(By.xpath(".//*[@class='campaign-title'][1]/a")).getText();
	       if(Automatedform.equalsIgnoreCase(Formname2))
	       {
	    	   System.out.println("Form Created sucessfully");
	       }
	      
	       
		
		}
	}
	
	@Test
	public void FeedbackSurveyForm() throws InterruptedException
	{

			NavigateToForm();
			driver.findElement(By.xpath(".//span[contains(text(),'Feedback Survey')]")).click();
			String form=driver.findElement(By.xpath(".//div[@class='leads-title']")).getText();
			System.out.println("FOrm name"+form);
			if(form.equalsIgnoreCase("Create a Form"))
			{
				driver.findElement(By.xpath(".//input[@name='form-name']")).sendKeys(Formname3);
				driver.findElement(By.xpath(".//input[@name='form-title']")).sendKeys("AutomationTitle");
				driver.findElement(By.xpath(".//input[@name='form-subtitle']")).sendKeys("AutomationSubTitle");
				driver.findElement(By.xpath(".//input[@value='Confirmation message']")).click();
				driver.findElement(By.xpath(".//input[@name='confirm_message']")).sendKeys("Thank you for filling the form");
				WebElement create= driver.findElement(By.xpath(".//h3[contains(text(),'Create')]"));
				Actions action=new Actions(driver);
				action.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).perform();
		        Thread.sleep(5000);
		        WebElement save= driver.findElement(By.xpath(".//*[@id='save_form']"));
		       //action.moveToElement(save);
		       save.click();
		       
		       WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@class='leads-title']")));
		       String formtext=driver.findElement(By.xpath(".//*[@class='leads-title']")).getText();
		       System.out.println("Saving The form"+ formtext);
		       driver.findElement(By.xpath(".//*[@id='save_form']")).click();
		       Thread.sleep(3000);
		       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@class='campaigns-list']")));
		       String Automatedform=driver.findElement(By.xpath(".//*[@class='campaign-title'][1]/a")).getText();
		       if(Automatedform.equalsIgnoreCase(Formname3))
		       {
		    	   System.out.println("Form Created sucessfully");
		       }
		
			}
		}
	
	
}
