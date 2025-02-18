package com.crm.gleantapauto.Campaigns;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.crm.gleantapauto.pageobjects.WorkroomObjects;
import com.crm.gleantapauto.testscomponents.BaseTest;

public class EmailCampaignsAsapTest extends BaseTest{
	
	@Test
	public void CreateAndSendAsapCampaign() throws InterruptedException
	{
		WorkroomObjects Wobj =logOb.loginApplication("Sagar@gleantap.com", "Select!8583");
		Wobj.FindWorkrooms();
		
		driver.findElement(By.xpath("(.//a/span[contains(text(),'Campaigns')])[1]")).click();
		driver.findElement(By.xpath(".//span[contains(text(),' Email Campaigns')]")).click();
		driver.findElement(By.xpath(".//*[@class='btn btn-success']/child::i")).click();
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(30));
		WebElement camapign=driver.findElement(By.xpath(".//h1[@class='page-title']"));
		wait.until(ExpectedConditions.visibilityOf(camapign));
		WebElement Campname=driver.findElement(By.xpath(".//input[@id='campaign_name']"));
		Campname.click();
		Campname.sendKeys("AutoCampaignASAP");
		WebElement select= driver.findElement(By.xpath(".//*[@name='campaign_objective']"));
		select.click();
		Select objective= new Select(select);
		objective.selectByVisibleText("Milestone");
		driver.findElement(By.xpath(".//*[@id='saveCampaign']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[text()='Create your Content']")));
		WebElement subject= driver.findElement(By.xpath(".//*[@id='subject1']"));
		subject.click();
		subject.sendKeys("Auto Subject");
		
		WebElement preheader= driver.findElement(By.xpath(".//*[@id='preheader1']"));
		preheader.click();
		preheader.sendKeys("Auto preheadear");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//a[text()='My Templates']")));
		Actions action=new Actions(driver);
		WebElement template =driver.findElement(By.xpath(".//a[text()='My Templates']"));
		action.moveToElement(template);
		driver.findElement(By.xpath(".//a[text()='My Templates']")).click();
		
	System.out.println("clicked on my templates");
	
	WebElement test=driver.findElement(By.xpath("(.//*[@id='email-template-list'])[2]/li[1]/div/figure"));
	wait.until(ExpectedConditions.visibilityOf(test));
	 action.moveToElement(test);
		driver.findElement(By.xpath("(.//*[@id='email-template-list'])[2]/li[1]/div/child::figure/child::figcaption/child::a[2]")).click();
		Thread.sleep(5000);
		WebElement frame=driver.findElement(By.xpath(".//*[@id='bee-plugin-container']/child::iframe"));
         driver.switchTo().frame(frame);
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//span[contains(text(),'SAVE')]/parent::button")));
		 WebElement save =driver.findElement(By.xpath(".//span[contains(text(),'SAVE')]/parent::button"));
		 save.click();
		
		 driver.switchTo().defaultContent();
		Thread.sleep(3000);
		 
	
		WebElement saveandContinue= driver.findElement(By.xpath(".//*[@id='saveCampaign']"));
		wait.until(ExpectedConditions.visibilityOf(saveandContinue));
		
		saveandContinue.click();
		System.out.println("clicked on the 2nd save & continue");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='search-all-segment']")));
		driver.findElement(By.xpath(".//*[@id='search-all-segment']")).click();
		String segmentname ="Bhargavi email segment";
		driver.findElement(By.xpath(".//*[@id='search-all-segment']")).sendKeys(segmentname);
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='btn-search-all-segment']")).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(.//*[@class='create-campaign-segmentation-item'])[1]")));
		WebElement segment= driver.findElement(By.xpath("(.//*[@class='create-campaign-segmentation-item'])[1]/span[1]"));
		String selectedsegment =segment.getText();
		System.out.println("selectedsegment is " +selectedsegment );
		if(segmentname.equalsIgnoreCase(selectedsegment))
		{
			driver.findElement(By.xpath("(.//*[@class='create-campaign-segmentation-item'])[1]")).click();
			System.out.println("Segment selected successfully");
			
		}
		else {
			System.out.println("unable to click on segment");
		}
		driver.findElement(By.xpath(".//*[@id='saveCampaign']")).click();
		System.out.println("clicked on the 3rd save & continue");
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[contains(text(),'Review & Send')]")));
		driver.findElement(By.xpath(".//*[contains(text(),'Send Campaign')]")).click();
		System.out.println("clicked on Send Campaign");
		
	}

}
