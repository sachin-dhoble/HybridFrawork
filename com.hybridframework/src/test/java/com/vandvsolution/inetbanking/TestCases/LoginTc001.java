package com.vandvsolution.inetbanking.TestCases;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.vandvtechsolution.inetbanking.Testbase.TestBased;
import com.vandvtechsolution.inetbanking.pageObject.LoginPage;

public class LoginTc001 extends TestBased{
//@Test
//public void verifyLoginFunctionalityTc001 (){
//	
//	
//	LoginPage login = new LoginPage(driver);
//	login.setUsername("mngr395244");
//	login.setPassward("YrybEjY");
//	login.clickOnLoginBtn();
//	
//
//	
	

@Test
public void verifyLoginFunctionalityTc001 (){

	Test=extentreport.createTest("login functionslity");
	LoginPage login = new LoginPage(driver);
	login.setUsername(configdataprovider.getUserName());
	login.setPassward(configdataprovider.getPwrd());
	login.clickOnLoginBtn();
	

	
	
	
}
}