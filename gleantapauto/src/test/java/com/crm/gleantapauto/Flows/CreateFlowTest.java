package com.crm.gleantapauto.Flows;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.crm.gleantapauto.pageobjects.WorkroomObjects;
import com.crm.gleantapauto.testscomponents.BaseTest;

public class CreateFlowTest extends BaseTest{
	
	@Test
	public void AddFlow( ) throws InterruptedException 
	{
	
	WorkroomObjects Wobj =logOb.loginApplication("Sagar@gleantap.com", "Select!8583");
	Wobj.FindWorkrooms();
	WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(30));
	driver.findElement(By.xpath(".//span[contains(text(),'Flows')]")).click();
	WebElement FlowsPage= driver.findElement(By.xpath(".//div[contains(text(),'Flow name')]"));
	wait.until(ExpectedConditions.visibilityOf(FlowsPage));
	driver.findElement(By.xpath(".//*[@class='btn btn-success']")).click();
	System.out.println("Clicked on the Add Flow button");
	driver.findElement(By.xpath(".//*[@id='automation_name']")).sendKeys("AutoFlow");
	WebElement element = driver.findElement(By.xpath(".//*[@id='nextstep']"));
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	Actions actions = new Actions(driver);
	actions.moveToElement(element).perform();
	System.out.println("Moved to the next button");
	element.click();
	System.out.println("CLicked on next button");
	WebElement enroll=driver.findElement(By.xpath(".//*[@id='campaign-step-2']"));
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",enroll);
	
	actions.moveToElement(enroll).perform();
	enroll.click();
	driver.findElement(By.xpath(".//*[@id='search_segment']")).sendKeys("bhargavi email segment");
	driver.findElement(By.xpath(".//*[@class='searchBtn create-campaign-segmentation-search-button']")).click();
	Thread.sleep(2000);
	WebElement checkbox=driver.findElement(By.xpath("(.//*[@class='create-campaign-segmentation-item'])[1]"));
	//((JavascriptExecutor)driver).executeScript("document.querySelector(arguments[0],':before').click();",checkbox);
	
	//actions.moveToElement(checkbox).click().build().perform();
	checkbox.click();
	System.out.println("Clicked the checkbox");
	WebElement Save= driver.findElement(By.xpath(".//*[@id='nextstep']"));
((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",Save);
	
	actions.moveToElement(Save).perform();
	Save.click();
	
	
	
	}
}