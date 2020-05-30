package com.hrms.testbase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.hrms.utils.ConfigsReader;
import com.hrms.utils.Constant;

public class BaseClass {
	
	public static WebDriver driver;

	@BeforeMethod // to make this method run before every @Test method
	public static WebDriver setUp() {
		
		ConfigsReader.readProperties(Constant.CONFIGURATION_FILEPATH); // read our property file
		
		
		System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "true");
		
		
		switch(ConfigsReader.getProperty("browser").toLowerCase()) {
		
		case "chrome":
			System.setProperty("webdriver.chrome.driver", Constant.CHROME_DRIVER_PATH);
			driver= new ChromeDriver();
			break;
			
		case "firefox":
			System.setProperty("webdriver.gecko.driver", Constant.GECKO_DRIVER_PATH);
			driver=new FirefoxDriver();
			break;
			
		default:
			 throw new RuntimeException("Browser is not supported");
			 
		}
		//driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(Constant.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
		
		driver.get(ConfigsReader.getProperty("url"));
		
		
		//initilize all page objects as part of the setUp
		PageInitializer.initialize();
		
		
		
		return driver;
	}
	
	@AfterMethod  //to make this method to run after every @Test method 
	public static void tearDown() {
		if(driver !=null) {
			driver.quit();
			
		}
	}
}
