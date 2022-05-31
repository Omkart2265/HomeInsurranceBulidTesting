package PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	WebDriver driver;
	@FindBy (xpath = "(//a[ @class='signed'])[1]")
	private WebElement profile;
	
	@FindBy (xpath = "//span[text()='Sign out']")
	private WebElement logOut;
	
	 
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void profile() throws InterruptedException {
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		act.moveToElement(profile).perform();
		profile.click();
		 
	}
	
	public void logOut() throws InterruptedException {
		Thread.sleep(2000);
		logOut.click() ;
	}
	
	 
}
