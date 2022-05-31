package PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	
	WebDriver driver;
	
	@FindBy (xpath = "//a[text()='Sign in']")
	private WebElement signIn;
	
	@FindBy (xpath = "(//input[@type='number'])[2]")
	private WebElement mobileNO;
	
	@FindBy (xpath = "(//span[ text()='Sign in with Password'])[2]")
	private WebElement signInWithPassword;
	
	@FindBy (xpath = "//input[@type='password']")
	private WebElement enterPassword;
	
	@FindBy (xpath = "//span[text()='Sign in']")
	private WebElement logIn;
	
	
	public Loginpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void signIn() {
		signIn.click();
		 
	}
	
	public void mobileNO() throws InterruptedException {
		Thread.sleep(500);
		mobileNO.sendKeys("7507094826");
	}
	
	public void signInWithPassword()   {
		 
		signInWithPassword.click();
	}
	
	public void enterPassword() throws InterruptedException {
		 
		Thread.sleep(500);
		enterPassword.sendKeys("Omkya@789");
	}
	
	 
	
	public void logIn() {
		logIn.click() ;
	}
	
	public void login() throws InterruptedException {
		Thread.sleep(500);
		signIn.click();
		Thread.sleep(1000);
		mobileNO.sendKeys("7507094826");
		signInWithPassword.click();
		Thread.sleep(500);
		enterPassword.sendKeys("Omkya@789");
		logIn.click() ;
		Thread.sleep(1000);
	 
	
	
			
	}		

}
