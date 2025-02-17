package com.crm.gleantapauto.Campaigns;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.crm.gleantapauto.pageobjects.WorkroomObjects;
import com.crm.gleantapauto.testscomponents.BaseTest;

public class SMSCampaignsAsapTest extends BaseTest {
	
	@SuppressWarnings("deprecation")
	@Test
	
	public void SMSCampaignAsap() throws InterruptedException, IOException
	{
		WorkroomObjects Wobj =logOb.loginApplication("Sagar@gleantap.com", "Select!8583");
		Wobj.FindWorkrooms();
		
		driver.findElement(By.xpath("(.//a/span[contains(text(),'Campaigns')])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//span[contains(text(),'SMS Campaigns')]")).click();
		driver.findElement(By.xpath(".//*[@class='btn btn-success']/child::i")).click();
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(30));
		WebElement NewSMSCamapaign= driver.findElement(By.xpath(".//h1[contains(text(),'New SMS Campaign')]"));
		wait.until(ExpectedConditions.visibilityOf(NewSMSCamapaign));
		driver.findElement(By.xpath(".//*[@id='campaignname']")).sendKeys("AutoSMSCampaignASAP");
		String SMSMessage="Testing Auto SMS Campaign";
		System.out.println(SMSMessage);
		WebElement TextMessage=driver.findElement(By.xpath(".//*[@id='messagedetails0']"));
		TextMessage.click();
		TextMessage.sendKeys(SMSMessage);
		driver.findElement(By.xpath(".//*[@id='imgmedia']/div")).click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec("D:\\Gleantap-functional\\FileUpload.exe");
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='smssavebtn']")).click();
		Thread.sleep(500);
		WebElement Audience=driver.findElement(By.xpath(".//*[contains(text(),'Calculate Target Audience')]"));
		wait.until(ExpectedConditions.visibilityOf(Audience));
		Select objSelect =new Select(driver.findElement(By.xpath(".//*[@id='inboundcampaign']")));
		objSelect.selectByVisibleText("None");
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='search-all-segment']")));
		driver.findElement(By.xpath(".//*[@id='search-all-segment']")).click();
		String segmentname ="Google Audience Test";
		driver.findElement(By.xpath(".//*[@id='search-all-segment']")).sendKeys(segmentname);
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
		driver.findElement(By.xpath(".//*[@id='smsDraftBtn2']/following-sibling::*")).click();
		System.out.println("clicked on 2nd continue");
		((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
		WebElement TimeTrigger=driver.findElement(By.xpath(".//*[@id='tab3']"));
		wait.until(ExpectedConditions.visibilityOf(TimeTrigger));
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@class='radio-custom radio-primary']/input[@id='send_asap_part']")).click();
		driver.findElement(By.xpath(".//*[@id='savebtn3']")).click();
		System.out.println("clicked on 3rd continue");
		Thread.sleep(1000);
		//WebElement Confirm=driver.findElement(By.xpath(".//*[@id='tab4']"));
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");
		driver.findElement(By.xpath(".//*[@id='confirm_btn']")).click();
		System.out.println("completed the SMS Campaign");
	}

}
