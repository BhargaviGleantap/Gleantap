package com.crm.gleantapauto.Sales;

import java.time.Duration;
import java.util.List;
import java.util.ListIterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.crm.gleantapauto.pageobjects.WorkroomObjects;
import com.crm.gleantapauto.testscomponents.BaseTest;
import com.crm.gleantapauto.testscomponents.TodaysDate;

public class AddappointmentTest extends BaseTest {
	WorkroomObjects Wobj;
	String CPmatch;
	
	@Test
	public void addappointment() throws InterruptedException {
		Wobj = logOb.loginApplication(prop.getProperty("username"), prop.getProperty("password"));
		Wobj.FindWorkrooms();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath(".//a/span[contains(text(),'Appointments')]")).click();
		driver.findElement(By.xpath("//*[@id=\"add-appointment-on-page-toggle\"]")).click();
		if (driver.findElement(By.xpath("//*[contains(text(),'Create Appointment')]")).isDisplayed()) {
			// appointment title
			driver.findElement(By.xpath("//*[@title='Appointment Title']")).click();
			driver.findElement(By.xpath("//*[@title='Appointment Title']")).sendKeys("AppoTest");
			driver.findElement(By.xpath(".//*[@title='Appointment Assigned To']")).click();
			Thread.sleep(2000);
			Select assignedTo = new Select(driver.findElement(By.xpath(".//*[@title='Appointment Assigned To']")));
			assignedTo.selectByVisibleText("Bhargavi market");
			Thread.sleep(2000);
			//System.out.println(date1.getTodaysLocalDate());
			/*
			 * driver.findElement(By.xpath("//input[@title='Appointment Due On']"))
			 * .sendKeys(date1.getTodaysLocalDate());
			 */
			driver.findElement(By.xpath("//input[@title='Appointment Due On']")).sendKeys(prop.getProperty("CreatedDate"));
			driver.findElement(By.xpath(".//*[@id='appointment_start_time']")).sendKeys("10:30");
			driver.findElement(By.xpath(".//*[@id='appointment_end_time']")).sendKeys("11:30");
			driver.findElement(By.xpath(".//*[@list='appointment_contact_persons']")).click();
			driver.findElement(By.xpath(".//*[@list='appointment_contact_persons']")).sendKeys("testquote (bhargavi@gleantap.com)");
			//driver.findElement(By.xpath(".//*[@list='appointment_contact_persons']")).sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			 Actions action=new Actions(driver);
			 action.clickAndHold();
		
			List<WebElement> Contactperson = driver
					.findElements(By.xpath(".//*[@id='appointment_contact_persons']/child::option"));
			// System.out.println("COntact person sizze"+ Contactperson);
			if (Contactperson.size() != 0) {

				System.out.println("size" + Contactperson.size());			  
				  ListIterator<WebElement> itr=Contactperson.listIterator();
				  
				  while(itr.hasNext())
				  
				  { 
					  int index=itr.nextIndex(); 
					  String CPmatch =itr.next().getAttribute("value");
					  System.out.println(index + CPmatch);
					  WebElement key =driver.findElement(By.xpath(
							  ".//*[@id='appointment_contact_persons']/child::option[\"+(index+1)+\"]"));

					if (CPmatch.equalsIgnoreCase("testquote (bhargavi@gleantap.com)")) {
				
						 action.click().contextClick(key);
			
						break;
					}
				  }
				  
					driver.findElement(By.xpath(".//*[@id='contact_invite']")).click();
					Select appointmentType = new Select(driver.findElement(By.xpath(".//*[@title='Appointment Type']")));
					appointmentType.selectByVisibleText("ZOOM");
					driver.findElement(By.xpath(".//*[@title='Appointment Notes']")).sendKeys(" Testing Notes");
					driver.findElement(By.xpath(".//*[contains(@class,'add-appointment-on-page-submit')]")).submit();
					Thread.sleep(5000);
					//if()
					System.out.println("Appointment created sucessfully");

		} else {
			System.out.println("unable to click on Add appointments button");
		}
		}
		}

}
