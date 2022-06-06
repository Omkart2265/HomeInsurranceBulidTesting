package TestClasses;
 

 

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Browsers.Base;
 
import PomClasses.HomePage;
import PomClasses.Loginpage;
 


import java.io.File;
 
 

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

 
 
 


public class TestingClass {
	WebDriver driver;
	Loginpage loginpage;
	HomePage homePage;
	SoftAssert soft;
	
	 
	static ExtentTest test;
	static ExtentHtmlReporter reporter;
	
	 
	@Parameters ("browserName")
	@BeforeTest
	public void lounchBrowser(String browser) {
		
		reporter = new ExtentHtmlReporter("test-output"+File.separator+"ExtendReport"+File.separator+"extendReport.html");
		ExtentReports extend = new ExtentReports();
		extend.attachReporter(reporter);
		
		System.out.println(browser);
		
		if(browser.equals("Chrome"))
		{
			driver = Base.openChromeBrowser();
		}
		if(browser.equals("Firefox"))
		{
			driver =Base.openFirefoxBrowser();
		}
		if(browser.equals("Edge"))
		{
			driver =Base.openEdgeaeBrowser();
		}
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}
	
	@BeforeClass
	public void createPomObjects() {
		driver = new ChromeDriver();
		loginpage =new Loginpage(driver);
		homePage = new HomePage(driver);
		soft = new SoftAssert();
		
	}
	
	 
	
	@BeforeMethod
	public void login() throws InterruptedException {
		driver.get("https://www.policybazaar.com/");
		driver.manage().window().maximize();
		
		loginpage.login();
		 
	}
		@Test
		public void verifyUrl() throws InterruptedException {
			
			String url = driver.getCurrentUrl();
			System.out.println(url);
			String title = driver.getTitle();
			System.out.println(title);
			
			soft.assertEquals("https://www.policybazaar.com/", url);
			soft.assertEquals("Insurance - Compare & Buy Insurance Plans – Health, Term, Life, Car", title);
			soft.assertAll();
						 
		}
		@AfterMethod
		public void logout() throws InterruptedException {
			 
			homePage.profile();
			homePage.logOut();
			 
		}
		
		@AfterClass
		public void clearObjects() {
			homePage =  null;
			loginpage = null;
			soft = null;
		}
		
		
		@AfterTest
		public void closedBrowser() {
			driver.close();
			driver = null;
			System.gc();
		}		
		
		 
	

	 

  
}
