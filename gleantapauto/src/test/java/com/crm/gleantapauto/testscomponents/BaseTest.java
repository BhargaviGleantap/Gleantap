package com.crm.gleantapauto.testscomponents;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.crm.gleantapauto.Login.loginTest;
import com.crm.gleantapauto.pageobjects.loginObjects;



public class BaseTest {
	
	public WebDriver driver;
	public loginObjects logOb;
	public loginTest logverify;
	public static Properties prop;
	public BaseTest()
	{
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/resources/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * public String getScreenshot(String testCaseName,WebDriver driver)throws
	 * IOException { TakesScreenshot ts=(TakesScreenshot)driver; File
	 * source=ts.getScreenshotAs(OutputType.FILE); File file =new
	 * File(System.getProperty("user.dir")+"//reports//"+testCaseName + ".png");
	 * 
	 * FileHandler.copy(source,file ); System.out.println("Screenshot taken");
	 * return System.getProperty("user.dir") + "//reports//"+testCaseName + ".png";
	 * 
	 * 
	 * }
	 */
	
	public WebDriver initializeDriver()
	{
		System.setProperty("Webdriver.chrome.Driver", "C:\\Users\\HP\\OneDrive\\Documents\\chromedriver-win64");
		 driver= new ChromeDriver();
		return driver;
	}
	@BeforeMethod(alwaysRun=true)
   public loginObjects LaunchApplication() throws InterruptedException
   {
	    driver =initializeDriver();
	    logOb = new loginObjects(driver);
		logOb.Navigate();
		return logOb;
	}
  
   @AfterMethod(alwaysRun=true)
	
	public void tearDown()
	{
		driver.close();
	}
  
}
