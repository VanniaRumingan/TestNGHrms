package com.hrms.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrms.pages.AddEmployeePageElements;
import com.hrms.pages.DashboardPageElements;
import com.hrms.pages.LoginPageElements;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

public class AddEmployeeTest extends CommonMethods {

	
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
	public void addEmployeePage() {
		

		LoginPageElements login = new LoginPageElements();

 		login.username.sendKeys(ConfigsReader.getProperty("username"));
 		login.password.sendKeys(ConfigsReader.getProperty("password"));
 		login.loginBtn.click();

 		DashboardPageElements board = new DashboardPageElements();

 		board.PIM.click();
 		jsClick(board.addEmp);

 		AddEmployeePageElements emp1 = new AddEmployeePageElements();
 		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
 		dashboard.navigateToAddEmployee();
 		wait(7);

 	}
		
		
//		sendText(addEmp.empFirstName, ConfigsReader.getProperty("employeeFirstname"));
//		sendText(addEmp.empLasttName, ConfigsReader.getProperty("employeeLastname"));
//		sendText(addEmp.addPhoto, ConfigsReader.getProperty("filePath"));
//		waitAndClick(addEmp.saveEmp);
		
		
		//add assertion to verify that employee has been added succussfully 
		
	
}
