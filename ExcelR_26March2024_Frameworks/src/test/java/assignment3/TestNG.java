package assignment3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNG {
	WebDriver driver;
	
	@DataProvider(name= "dataSet")
	public Object[][] Name()	
	{
		
		Object[][] data = new Object[1][2];
	
		data [0] [0] = "shivp@gmail.com";
		data [0][1] = "shivp123";
		return data;
	}
	
	
	@BeforeSuite
	public void setup() 
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/login.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}
	
	@Test(dataProvider ="dataSet")
	public void Login(String username, String password) throws InterruptedException 
	{
		WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
		email.sendKeys(username);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement passwod = driver.findElement(By.xpath("//input[@id='passwd']"));
		passwod.sendKeys(password);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//button[@id='SubmitLogin']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
		
	@AfterSuite
	public void closebrowser() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.close();
	}

}
