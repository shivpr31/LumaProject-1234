package assignment4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApachePOI {
	
	WebDriver driver;
	
	public ApachePOI(WebDriver idriver)
	{
		driver=idriver;
		//Page Factory =class
		PageFactory.initElements(driver, this);
	}

	@FindBy (name="uid") WebElement username;
	@FindBy (name="password") WebElement password;
	@FindBy (name="btnLogin") WebElement login;
	@FindBy (linkText="Log out") WebElement logout;

			
	
	public void url()
	{
		driver.get("http://demo.guru99.com/V4/");
	}
	
	
	public void enterUserName(String pm)
	{
		username.sendKeys(pm);
	}
	
	public void enterPassword(String am)
	{
		password.sendKeys(am);
	}
	
	public void ClickLoginBTN()
	{
		login.click();
	}
	
	public void ClickLogoutBTN()
	{
		logout.click();
	}
	
}
