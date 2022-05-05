package com.vandvtechsolution.inetbanking.Testbase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.vandvtechsolution.inetbanking.utility.ConfigDataprovider;
import com.vandvtechsolution.inetbanking.utility.ExceldataProvider;
import com.vandvtechsolution.inetbanking.utility.Helper;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBased {

	public WebDriver driver;
	static String configdatapath = "./config/config.properties";
	static String Exceldatapath="./TestData/abc.XLSX";

	public ConfigDataprovider configdataprovider;
	public ExceldataProvider ExcelDataprovider;
	public ExtentHtmlReporter htmlReport;
	public ExtentReports extentreport;
	public ExtentTest Test;

	@BeforeSuite 
	public void init() {
		configdataprovider = new ConfigDataprovider(configdatapath);
		ExcelDataprovider = new ExceldataProvider(Exceldatapath);
		String extendreportpath= System.getProperty("user.dir")+"//Report//inetbanking_html_"+Helper.getDateAndTime()+"html";
		htmlReport = new ExtentHtmlReporter("extendreportpath");
		
		htmlReport.config().setDocumentTitle("Automatin Report");
		htmlReport.config().setReportName("functional test report");
		htmlReport.config().setTheme(Theme.DARK);
		
		extentreport = new ExtentReports();
		extentreport.attachReporter(htmlReport);
		extentreport.setSystemInfo("Hostname", "local host");
		extentreport.setSystemInfo("os", "Windows10");
		extentreport.setSystemInfo("Browser", "chrome");
		extentreport.setSystemInfo("Envirement", "Regression");
		extentreport.setSystemInfo("testername", "Sachin");
		

	}
 
	@BeforeTest
	@Parameters({ "browser" })
	public void setUp(@Optional("firefox") String brname) {

		if (brname.equals("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (brname.equals("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else {
			System.out.print("System not match please check system");
		}

		driver.manage().window().maximize();
		driver.get(configdataprovider.getURL());

	}

	@AfterTest
	public void tearDown(ITestResult result) throws IOException {
		if(result.getStatus()==ITestResult.FAILURE) {
			
			Test.fail("test case failed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			
		}else if(result.getStatus()==ITestResult.SKIP) {
			Test.log(Status.SKIP, "Test case skipped");
			
		}
		else if(result.getStatus()==ITestResult.SUCCESS) {
			Test.log(Status.PASS, "Test case skipped");
			
		}
	    
		driver.quit();
	}
	
	@AfterTest
	public void FlushReport() {
		
		extentreport.flush();
		
	}
}