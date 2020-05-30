package com.hrms.testbase;

import com.hrms.pages.AddEmployeePageElements;
import com.hrms.pages.DashboardPageElements;
import com.hrms.pages.LoginPageElements;
import com.hrms.pages.PersonalDetailsPageElements;

public class PageInitializer extends BaseClass {

	
	//declaring variables (elements)
	
	
	public static LoginPageElements login;
	public static AddEmployeePageElements addEmp;
	public static DashboardPageElements dashboard;
	public static PersonalDetailsPageElements pdetails;
	
	
	
	
	//initializing variables 
	public static void initialize() {
		
		 login = new LoginPageElements();
		 dashboard = new DashboardPageElements();
		 addEmp = new AddEmployeePageElements();
		 pdetails = new PersonalDetailsPageElements();
		
	}
	
	
	
	
}
