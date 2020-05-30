package com.hrms.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

public class LoginTest extends CommonMethods{

	@BeforeMethod
	public void openBrowser() {
		setUp();
		initialize();
		
		
	}
	
	@AfterMethod
	public void closeBrowser() {
		tearDown();
	
	}
	
	@Test
	public void validAdminLogin() {
	//	LoginPageElements login = new LoginPageElements();
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));
		click(login.loginBtn);	
	
			
	//	DashboardPageElements dashboard = new DashboardPageElements();
		
		String expectedUser="Welcome Admin";
		String actualUser=dashboard.welcome.getText();
		AssertJUnit.assertEquals(actualUser, expectedUser, "Admin is NOT Logged in");
		AssertJUnit.assertTrue(actualUser.contains(ConfigsReader.getProperty("username")));
			
	}
	
	// When user enters valid username and invalid password “Invalid credentials” error message
	
	@Test 
	public void invalidPasswordLogin() {
//		LoginPageElements  login = new LoginPageElements();
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, "uiuguig");
		click(login.loginBtn);
		
		String expected="Invalid credentials";
		
		AssertJUnit.assertEquals(login.errorMsg.getText(), expected, "Error message text is not matched");
		
		
	}
	//	When user enters valid username and empty password “Password cannot be empty” 
	 //      error message should be displayed. 
	
	@Test   (enabled= true)
	public void emptyUsernameLogin() {
//		LoginPageElements login = new LoginPageElements();
		sendText(login.password, ConfigsReader.getProperty("password"));
		click(login.loginBtn);
		
		String expected= "Username cannot be empty";
		
		AssertJUnit.assertEquals(login.errorMsg.getText(), expected, "Error message is not matched");
		
	}
	
	
	
	
	
}
