package com.vandvsolution.inetbanking.TestCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vandvtechsolution.inetbanking.Testbase.TestBased;
import com.vandvtechsolution.inetbanking.pageObject.LoginPage;

public class login_tc002 extends TestBased {

	
	
	@DataProvider
	public Object[][] getData(){
		
		
	return ExcelDataprovider.getExcelTestData("sheet2");
	
		
	}
	@Test( dataProvider="getdata")
	public void verifyLoginFunctionality(Object username,Object passward) {
		
		
		LoginPage login = new LoginPage(driver);
		login.setUsername((String)username);
		login.setPassward((String)passward);
		login.clickOnLoginBtn();
	}
	
	

}
