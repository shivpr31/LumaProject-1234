package assignment4;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MasterClass {

	
	@Test
	public void results() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		ApachePOI ap = new ApachePOI (driver);
		ap.url();
		ap.enterUserName("Admin");
		ap.enterPassword("admin123");
		ap.ClickLoginBTN();
		Alert a = driver.switchTo().alert();
		a.accept();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
 	

	}

}
