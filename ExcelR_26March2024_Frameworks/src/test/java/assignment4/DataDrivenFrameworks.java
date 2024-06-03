package assignment4;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class DataDrivenFrameworks {
	
	public static void main(String[] args) throws IOException {
		  
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/V4/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//FilePath 
		String filepath ="D:\\Exceltest.xlsx";
		FileInputStream fis = new FileInputStream(filepath);
		
		//Excel - Data Driven
		XSSFWorkbook workbook = new XSSFWorkbook (fis);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
			
			int rows = sheet.getLastRowNum();
			System.out.println("Total no of rows: "+ rows);
			
			for (int r=1; r<=rows;r++) {
				XSSFRow row= sheet.getRow(r);
				XSSFCell usernm=row.getCell(0);
				
				XSSFCell pass =row.getCell(1);
				//XSSFCell result = row.createCell(2);
				
				
				System.out.println(" Username ------>"+usernm+ "       Password------>" +pass );
				
			
				//Apache POI
				ApachePOI ap = new ApachePOI (driver);
				ap.url();
				ap.enterUserName(usernm.toString());
				ap.enterPassword(pass.toString());
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
				ap.ClickLoginBTN();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				
				ap.ClickLogoutBTN();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
				
				
				Alert a = driver.switchTo().alert();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
				
				a.accept();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
				
			
				fis.close();
				//workbook.close();				
			}
			}     
	}


