package com.crm.gleantapauto.Audience;

import java.time.Duration;
import java.time.LocalDate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.crm.gleantapauto.pageobjects.WorkroomObjects;
import com.crm.gleantapauto.testscomponents.BaseTest;


public class AddContactAsProspectTest extends BaseTest {
	
	  LocalDate currentDate = LocalDate.now();  
     // System.out.println("Current Date: " + currentDate);  
	@Test
	public void AddContactAsProspectTest() throws InterruptedException
	{
		WorkroomObjects Wobj =logOb.loginApplication("Sagar@gleantap.com", "Select!8583");
		Wobj.FindWorkrooms();
		
		driver.findElement(By.xpath("(.//a/span[contains(text(),'Audience')])[1]")).click();
		driver.findElement(By.xpath(".//a/span[contains(text(),'Contacts')]")).click();
		driver.findElement(By.xpath(".//*[@id='add-new-lead-toggle']")).click();
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(30));
		WebElement AddNewContact=driver.findElement(By.xpath(".//span[contains(text(),'Add New Contact')]"));
		wait.until(ExpectedConditions.visibilityOf(AddNewContact));
		String FirstName=prop.getProperty("firstname");
		System.out.println("FirstName");
		driver.findElement(By.xpath(".//*[@name='first_name']")).sendKeys();
		System.out.println("Entered First Name");
		driver.findElement(By.xpath(".//*[@name='last_name']")).sendKeys(prop.getProperty("lastname"));
		System.out.println("Entered last  Name");
		
	}
	

}
