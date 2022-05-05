package com.vandvtechsolution.inetbanking.pageObject;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vandvtechsolution.inetbanking.utility.Helper;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "New Customer")
	WebElement NewCustomerLink;

	@FindBy(linkText = "Edit Customer")
	WebElement EditCustomerLink;

	@FindBy(linkText = "New Account")
	WebElement NewAccountLink;

	@FindBy(linkText = "Log out")
	WebElement logout_Link;

	public NewCustomerpage clickonNewCustomerLink()
   {
	   try {
		   NewCustomerLink.click();
		   return new NewCustomerpage();
	   }
	   catch(Exception e)
	   {
		   e.printStackTrace();
		   return null;
	   }
   }
	public EditCustomerpage clickonEditcstomerLink()
	   {
		   try {
			   EditCustomerLink.click();
			   return new EditCustomerpage();
			   
		   }
		   catch(Exception e) {
			   e.printStackTrace();
			   return null;
			   
		   }
	   }
	public NewCustomerpage clickonNewCustomerlink()
		   {
			   try {
				   NewAccountLink.click();
				   return new NewCustomerpage();
			   }
			   catch(Exception e) {
				   e.printStackTrace();
				   return null;
				   
			   }
		   }
	public void clickonLogoutLink() {
		try {
			logout_Link.click();
			if(Helper.AlertisPresent(driver)) {
				Alert alert = driver.switchTo().alert();
			System.out.println	(alert.getText());
			alert.accept();
			}
			
		} catch (Exception e) {

		}
	}

}