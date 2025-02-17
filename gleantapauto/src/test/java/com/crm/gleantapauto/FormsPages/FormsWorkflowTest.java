package com.crm.gleantapauto.FormsPages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.crm.gleantapauto.pageobjects.WorkroomObjects;
import com.crm.gleantapauto.testscomponents.BaseTest;

public class FormsWorkflowTest extends BaseTest{
	@Test
	public void AddWorkflows() throws InterruptedException
	{
	
	WorkroomObjects Wobj =logOb.loginApplication("Sagar@gleantap.com", "Select!8583");
	Wobj.FindWorkrooms();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.findElement(By.xpath(".//span[contains(text(),'Forms & Pages')]")).click();
	driver.findElement(By.xpath(".//a[@class='animsition-link']/child::span[contains(text(),'Forms')]")).click();
	//driver.findElement(By.xpath(".//button[@id='fromscratchbtn']")).click();
	driver.findElement(By.xpath(".//*[@id='custom_form_search']")).click();
	driver.findElement(By.xpath(".//*[@id='custom_form_search']")).sendKeys("StartfromScratch");
	Thread.sleep(2000);
	driver.findElement(By.xpath("(.//*[@class='form-link listBtn'])[1]/i")).click();
	driver.findElement(By.xpath("(.//a[@title='Workflows'])[1]")).click();
	Thread.sleep(2000);
	/*
	 * driver.findElement(By.xpath("(.//*[@class='form-link listBtn']/i)[1]")).click
	 * (); driver.findElement(By.
	 * xpath(".//*[@class='dropdown-menu-forms reverse show']/a[5]")).click();
	 */
	driver.findElement(By.xpath("(.//label[contains(text(),' Notify Internal User ')]/../../following-sibling::div/label)[1]")).click();
	
	driver.findElement(By.xpath("(.//*[@placeholder='Enter email address separated by comma'])[1]")).sendKeys("bhargavi@gleantap.com");
	
	
	driver.findElement(By.xpath("(.//label[contains(text(),' SMS & Email Auto-Response  ')]/../../following-sibling::div/label)[1]")).click();
	
	Select select =new Select(driver.findElement(By.xpath("(.//*[@name='auto_response_type'])[1]")));
	select.selectByVisibleText("EMAIL");
	Thread.sleep(2000);
	driver.findElement(By.xpath("(.//input[@placeholder='Subject'])[1]")).sendKeys("Form Auto response subject");
	driver.findElement(By.xpath("(.//*[@name='auto_response_email'])[1]")).sendKeys("Auto response email for forms");
	Actions actions = new Actions(driver);
	WebElement save=driver.findElement(By.xpath("(.//*[contains(text(),'Save')])[1]"));
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",save);
	
	actions.moveToElement(save).perform();
	save.click();
	System.out.println("CLicked on save");
	
	
	
	
	
	}

}
