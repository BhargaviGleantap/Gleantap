package com.crm.gleantapauto.FormsPages;

import java.time.Duration;
import java.util.List;
import java.util.ListIterator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.crm.gleantapauto.pageobjects.WorkroomObjects;
import com.crm.gleantapauto.testscomponents.BaseTest;

public class AddPagesTest extends BaseTest {
	 String FormName="StartfromScratch";
	//StartfromScratch
	
	@Test
	public void createPage() throws Exception
	{
		try {
		
		
		WorkroomObjects Wobj =logOb.loginApplication("Sagar@gleantap.com", "Select!8583");
		Wobj.FindWorkrooms();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath(".//span[contains(text(),'Forms & Pages')]")).click();
		driver.findElement(By.xpath(".//a[@class='animsition-link']/child::span[contains(text(),'Pages')]")).click();
		driver.findElement(By.xpath(".//button[@id='fromscratchbtn']")).click();
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[contains(text(),'Pick a Template to Continue')]")));
		if(driver.findElement(By.xpath(".//*[contains(text(),'Pick a Template to Continue')]")).isDisplayed())
		{
			WebElement page= driver.findElement(By.xpath("(.//figcaption)[1]"));
			Actions action=new Actions(driver);
			action.moveToElement(page);
			driver.findElement(By.xpath("(//a[contains(text(),'Start')])[1]")).click();	
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='page']")));
			Thread.sleep(3000);
			WebElement frametest=driver.findElement(By.xpath(".//*[@id='editor-container']/iframe"));
		
			
			if(element.isDisplayed())
			{
				driver.switchTo().frame(frametest);
				//Thread.sleep(5000);
	 
				 WebElement pagetype= driver.findElement(By.xpath(".//div[@class='blockbuilder-tool blockbuilder-content-tool'][2]/div[2]"));
				 String text2= driver.findElement(By.xpath(".//div[@class='blockbuilder-tool blockbuilder-content-tool'][2]/div[3]/span")).getText();
				 System.out.println(text2);
					
	        WebElement dropPage= driver.findElement(By.xpath(".//div[@class='blockbuilder-placeholder-empty']")); 
	       // action.
	        String Text =driver.findElement(By.xpath(".//div[@class='blockbuilder-placeholder-empty']/div/div")).getText();
	       	System.out.println(Text);	
	      
	       	Actions builder = new Actions(driver);
	       	builder.clickAndHold(pagetype).moveToElement(dropPage).release().build().perform();
		   Thread.sleep(2000);
	      
			System.out.println("Form Drop DOwn");
			//WebElement FormDrop=driver.findElement(By.xpath(".//div[@class='u_content_custom_gleantap_forms']"));
			//FormDrop.click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//h3[contains(text(),'No Form Selected')]")));
			WebElement formText=driver.findElement(By.xpath(".//div[@class='blockbuilder-layer-selector blockbuilder-layer-selector-first']"));
			String Formtext1=driver.findElement(By.xpath(".//h3[contains(text(),'No Form Selected')]")).getText();
			
			System.out.println(Formtext1);
			formText.click();
			if(Formtext1.equalsIgnoreCase("No Form Selected"))
			{
				
				driver.findElement(By.xpath(".//*[contains(text(),'Choose Form')]")).click();
				Select Advanceform= new Select(driver.findElement(By.xpath(".//*[@class='select_form form-control']")));
				Advanceform.selectByVisibleText(FormName);
				System.out.println("Selected the advanced form");
				
				  driver.findElement(By.xpath(".//*[@id='useForm']")).click();
				  System.out.println("Clicked on add");
				  Thread.sleep(2000);
			
			}
			else {
				System.out.println("Advanced forms not selected");
			}
			
		 driver.switchTo().defaultContent();
		}
			driver.findElement(By.xpath(".//*[@id='page_name']")).click();
		driver.findElement(By.xpath(".//*[@id='page_name']")).sendKeys("AutoPage-Advanceforms");
		
	
		System.out.println("Entered the page name");
		WebElement elementclick = driver.findElement(By.xpath(".//*[@id='save_page']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", elementclick);
		driver.findElement(By.xpath(".//*[@id='save_page']")).click();
		System.out.println("Saved the Page");
		Thread.sleep(2000);
		 WebElement AutoPage= driver.findElement(By.xpath(".//*[@id='load-campaigns']/div[1]/div/div[@class='campaign-title']/a"));
		 
		wait.until(ExpectedConditions.visibilityOf(AutoPage));
		String PageName=AutoPage.getText();
		if(PageName.equalsIgnoreCase("AutoPage-Advanceforms"))
		{
			System.out.println("Page added successfully ");
			//this code added because two pages are getting created
			/*
			 * driver.findElement(By.xpath("(.//*[@class='form-link listBtn'])[1]/i")).click
			 * ();
			 * driver.findElement(By.xpath("(.//*[@class='dropdown-menu-forms show'])/a[6]")
			 * ).click(); driver.switchTo().alert().accept();
			 * System.out.println("Duplicate page deleted"); driver.findElement(By.xpath(
			 * ".//*[@id='load-campaigns']/div[1]/div[5]/div/label")).click();
			 * System.out.println("Toggled on the auto page");
			 */
		}
		else {
			System.out.println("Added Page not visible");
		}
	}
		}
		catch(Exception e)
		{
			System.out.println("Exception Caught"+e);
		}
	}
	
	 
	
}
