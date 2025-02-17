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
@Test

public class KeyWordCampaignTest extends BaseTest{
	
	String Keywordtext="Thanks for submitting for the auto keyword campaign";

	public void CreateKeyWordCampaign() throws InterruptedException
	{
		WorkroomObjects Wobj =logOb.loginApplication("Sagar@gleantap.com", "Select!8583");
		Wobj.FindWorkrooms();
		
		driver.findElement(By.xpath("(.//a/span[contains(text(),'Campaigns')])[1]")).click();
		driver.findElement(By.xpath(".//span[contains(text(),'Keyword Campaigns')]")).click();
		driver.findElement(By.xpath(".//*[@class='btn btn-success']/child::i")).click();
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(30));
		WebElement camapign=driver.findElement(By.xpath(".//h1[@class='page-title']"));
		wait.until(ExpectedConditions.visibilityOf(camapign));
		driver.findElement(By.xpath(".//*[@id='campaign_name']")).click();
		driver.findElement(By.xpath(".//*[@id='campaign_name']")).sendKeys("AutoKeyword Camapign");
		Actions Scroll= new Actions(driver);
		WebElement save=driver.findElement(By.xpath(".//*[@id='inboundsavebtn']"));
		Scroll.moveToElement(save);
		save.click();
		System.out.println("Clicked on COntinue button");
		WebElement Keyword=driver.findElement(By.xpath(".//a[contains(text(),'Personalize')]"));
		wait.until(ExpectedConditions.visibilityOf(Keyword));
		
		Scroll.moveToElement(Keyword);
		driver.findElement(By.xpath(".//input[@id='inbound_keyword0']")).sendKeys("AutoKeyword");
		System.out.println("Entered the keyword");
		driver.findElement(By.xpath(".//*[@id='autoresponder0']")).sendKeys(Keywordtext);
		System.out.println("entered the keyword text");
		driver.findElement(By.xpath(".//*[@id='inboundsavebtn2']")).click();
		System.out.println("Entered teh continue button for 2nd time");
		WebElement Tags=driver.findElement(By.xpath("(.//*[contains(text(),'Tags')])[2]"));
		wait.until(ExpectedConditions.visibilityOf(Tags));
		driver.findElement(By.xpath(".//button[contains(text(),'Confirm')]")).click();
		System.out.println("Clicked on confirm button");
}
}
