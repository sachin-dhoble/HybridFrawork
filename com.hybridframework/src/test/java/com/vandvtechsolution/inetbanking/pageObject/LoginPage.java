package com.vandvtechsolution.inetbanking.pageObject;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.vandvtechsolution.inetbanking.utility.Helper;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// login page object repository
	@FindBy(name = "uid")
	WebElement txt_username;

	@FindBy(name = "password")
	WebElement txt_passward;

	@FindBy(name = "btnLogin")
	WebElement loginBtn;

	public void setUsername(String username) {

		try {
			txt_username.clear();
			txt_username.sendKeys(username);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void setPassward(String pass) {
		try {
			txt_passward.clear();

			txt_passward.sendKeys("pass");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public HomePage clickOnLoginBtn() {
		try {
			loginBtn.click();
			if (driver.getTitle().equals(" Guru99 Bank Home Page")) {
                 Assert.assertTrue(true);
				Helper.captureScreenshot(driver);
				return new HomePage(driver);
			} else {
				if (Helper.AlertisPresent(driver)) {
					Alert alert = driver.switchTo().alert();
					System.out.println(alert.getText());
					alert.accept();

				}
				Assert.assertTrue(false);
				return new HomePage(driver);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return new HomePage(driver);
		}

	}

}
