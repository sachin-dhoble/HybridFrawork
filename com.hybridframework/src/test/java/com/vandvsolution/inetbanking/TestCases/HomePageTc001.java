//package com.vandvsolution.inetbanking.TestCases;
//
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import com.vandvtechsolution.inetbanking.Testbase.TestBased;
//import com.vandvtechsolution.inetbanking.pageObject.HomePage;
//import com.vandvtechsolution.inetbanking.pageObject.LoginPage;
//import com.vandvtechsolution.inetbanking.utility.Helper;
//
//public class HomePageTc001 extends TestBased {
//	HomePage homepage;
//@Test(priority=1)
//public void verifyLoginFunctionalityTc001 (){
//
//	
//	LoginPage login = new LoginPage(driver);
//	login.setUsername(configdataprovider.getUserName());
//	login.setPassward(configdataprovider.getPwrd());
//	homepage =login.clickOnLoginBtn();
//
//}
//
//@Test(priority=2)
//public void navigtedToEditCustomerpage() {
//	homepage.clickonEditcstomerLink();
//	
//}
//
//@Test(priority=3)
//public void verifyLogoutLink() {
//	homepage.clickonLogoutLink();
//	if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
//		Assert.assertTrue(true);
//		
//	}else {
//		Assert.assertTrue(true);
//	}
//	
//}
//}
