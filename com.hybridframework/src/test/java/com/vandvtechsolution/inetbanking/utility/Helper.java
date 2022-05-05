package com.vandvtechsolution.inetbanking.utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {

	public static String captureScreenshot(WebDriver driver) {
		String Screenshotpath = System.getProperty("user.dir") + "//Screenshot//inetbanking_" + getDateAndTime()
				+ ".png";
		try {
			File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyDirectory(source, new File(Screenshotpath));
			System.out.println("Screenshot takes successfully");
			return Screenshotpath;
		} catch (Exception e) {
			System.out.println("not able to capture screenshot");
			return null;
		}

	}
 
	public static String getDateAndTime() {
		SimpleDateFormat customDate = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate = new Date();
		return customDate.format(currentDate);
	}

	public static boolean AlertisPresent(WebDriver driver) {
		try {
			driver.switchTo().alert().accept();
			return true;
		} catch (Exception e) {
			return false;

		}

	}

}
