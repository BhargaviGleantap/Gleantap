package com.crm.gleantapauto.pageobjects;

import java.time.Duration;
import java.util.List;
import java.util.ListIterator;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WorkroomObjects {
	

	WebDriver driver;
	
	public WorkroomObjects(WebDriver driver)
	{
		   //super(driver);
			this.driver=driver;
			PageFactory.initElements(driver, this);
			
	}
	public void FindWorkrooms() 
	{
		driver.findElement(By.xpath(".//a[@id='listview']")).click();
		List<WebElement> workroom = driver.findElements(By.xpath(".//*[@class='table']/tbody/tr/td/h5/a"));
		if (workroom.size() != 0) {
			int wsize = workroom.size();
			System.out.println("Total workrooms are" + wsize);
			ListIterator<WebElement> itr = workroom.listIterator();
			while (itr.hasNext()) {
				int index = itr.nextIndex();
				String WRname1 = itr.next().getText();

				if (WRname1.equalsIgnoreCase("Test APP")) {
					System.out.println("Into teh if block");
					System.out.println(index + " :" + WRname1);
					WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
					 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(.//*[@class='table']/tbody/tr/td/h5/a)["+index+"]")));
					driver.findElement(By.xpath("(.//*[@class='table']/tbody/tr/td/h5/a)["+(index+1)+"]")).sendKeys(Keys.ENTER);
					  System.out.println("Working");
					  break;
				}
				
			}
			
		}

		else {
			System.out.println("No workrooms found");
		}
	
		
	}
		
	
	

}
