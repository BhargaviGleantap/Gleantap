package com.crm.gleantapauto.Tasks;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.crm.gleantapauto.pageobjects.WorkroomObjects;
import com.crm.gleantapauto.testscomponents.BaseTest;

public class AddTaskTest extends BaseTest{

	@SuppressWarnings("deprecation")
	@Test
public void addTask() throws InterruptedException, IOException

{
	WorkroomObjects Wobj =logOb.loginApplication("Sagar@gleantap.com", "Select!8583");
	Wobj.FindWorkrooms();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	 driver.findElement(By.xpath(".//a/span[contains(text(),'Tasks')]")).click();
	 driver.findElement(By.xpath("//*[@id=\"add-task-on-page-toggle\"]")).click();
	 if(driver.findElement(By.xpath("//span[contains(text(),'Add a Task') and @class='popup-center-title']")).isDisplayed())
	 {
		 //appointment title
		 driver.findElement(By.xpath("//*[@title='Task Title']")).click();
		 driver.findElement(By.xpath("//*[@title='Task Title']")).sendKeys("Task");
		 
		 driver.findElement(By.xpath("//input[@title='Due On']")).sendKeys(prop.getProperty("CreatedDate"));
		 driver.findElement(By.xpath(".//*[@title='Task Assigned To']")).click();
		 Select assignedTo = new Select(driver.findElement(By.xpath(".//*[@title='Task Assigned To']")));
		 assignedTo.selectByVisibleText("Bhargavi market");
		 driver.findElement(By.xpath(".//*[@list='task_contact_persons']")).click();
		 driver.findElement(By.xpath(".//*[@list='task_contact_persons']")).sendKeys("testquote (bhargavi@gleantap.com)");
		 Thread.sleep(2000);
		 Actions action=new Actions(driver);
		 action.clickAndHold();
		 List<WebElement> Contactperson= driver.findElements(By.xpath(".//*[@id='task_contact_persons']/child::option"));
			System.out.println("size" + Contactperson.size());
             if (Contactperson.size()!=0)
             {
            	 ListIterator<WebElement> itr=Contactperson.listIterator();
            	 while(itr.hasNext())
            		 
            	 {

					  int index=itr.nextIndex(); 
					  String CPmatch =itr.next().getAttribute("value");
					  System.out.println(index + CPmatch);
					  WebElement key =driver.findElement(By.xpath(".//*[@id='task_contact_persons']/child::option[\"+(index+1)+\"]"));

					if (CPmatch.equalsIgnoreCase("testquote (bhargavi@gleantap.com)")) {
				
						 action.click().contextClick(key);
			
						break;
					}
            			 
            	 }
            	 
       // driver.findElement(By.xpath(".//*[@id='task_contact_persons']/child::option[\"+(index+1)+\"]")).sendKeys(Keys.ENTER);     	 
             }
           Thread.sleep(2000);
            // driver.findElement(By.xpath(".//*[@title='Task Type']")).click();
		 Select TaskType = new Select(driver.findElement(By.xpath(".//select[@class='select task_type']")));
		 TaskType.selectByVisibleText("test-01");
		 driver.findElement(By.xpath(".//*[@title='Task Description']")).sendKeys(" Testing Task Notes");
		driver.findElement(By.xpath(".//*[@title='Task Attachment']")).click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec("D:\\Gleantap-functional\\FileUpload.exe");
		Thread.sleep(5000);
		 driver.findElement(By.xpath(".//*[contains(@class,'add-task-on-page-submit')]")).submit();
		 Thread.sleep(5000);
		 System.out.println("Task added sucessfully");
	  
	
	
}
	 else {
		 System.out.println("unable to click on Add Task button");
	 }
}

}

