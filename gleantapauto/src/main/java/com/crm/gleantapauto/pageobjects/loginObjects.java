package com.crm.gleantapauto.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class loginObjects {
	
	WebDriver driver;
	public WorkroomObjects WorkObj;
	
	public loginObjects(WebDriver driver)
	{
		   //super(driver);
			this.driver=driver;
			PageFactory.initElements(driver, this);
			
	}
		
	@FindBy(xpath="//input[@name='username']")
	WebElement userid;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//button[contains(text(),'Sign in')]")
	WebElement submit;
	
	public WorkroomObjects loginApplication(String email ,String pwd)
	{
		userid.sendKeys(email);
		password.sendKeys(pwd);
		submit.click();
		WorkroomObjects WorkObj = new WorkroomObjects(driver);
		return WorkObj;
		
	}
	
	public void Navigate()
	{
		driver.navigate().to("https://app2.gleantap.com/");
		//driver.navigate().to("https://test.gleantap.com/");
		driver.manage().window().maximize();
	}

}
