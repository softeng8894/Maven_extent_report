import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Data_driven {

	public WebDriver driver;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFCell cell;
	public ExtentTest test;
	
	
	@BeforeMethod
	public void before()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://192.53.170.95/everywherelive-admin-api/admin");
	}
	
	@Test
	public void Test1() throws IOException, InterruptedException
	{
	    File file = new File("C:\\java\\Excel\\Testdata.xlsx");
	    FileInputStream fs = new FileInputStream(file);
	    workbook = new XSSFWorkbook(fs);
	    sheet = workbook.getSheetAt(0);
	    for(int i=0;i< sheet.getLastRowNum(); i++)
	    {
	    	cell = sheet.getRow(i).getCell(0);
	    	DataFormatter formatter = new DataFormatter();
	    	String username = formatter.formatCellValue(cell);
	    	cell = sheet.getRow(i).getCell(1);
	    	String password = formatter.formatCellValue(cell);
	    	Thread.sleep(10);
	    	try
	    	{
	    	driver.findElement(By.xpath("//*[@type='email']")).sendKeys(username);
	    	Thread.sleep(10);
	    	driver.findElement(By.xpath("//*[@type='password']")).sendKeys(password);
	    	Thread.sleep(10);
	    	driver.findElement(By.xpath("//*[@id='submit']")).click();
	    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    	driver.findElement(By.xpath("//*[@data-toggle='dropdown']")).click();
	    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    	driver.findElement(By.xpath("//*[@class='fas fa-sign-out-alt']")).click();
	    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    	
	    	sheet.getRow(i).createCell(2).setCellValue("Pass");
	    	FileOutputStream fo = new FileOutputStream(file);
	    	workbook.write(fo);
	    	}
	    	catch (Exception e) 
	    	{
	    		sheet.getRow(i).createCell(2).setCellValue("Fail");
		    	FileOutputStream fo = new FileOutputStream(file);
		    	workbook.write(fo);
		    	test.log(Status.FAIL,"Test Failed");
			}
	    }
	}
	
	@AfterMethod
	public void after()
	{
		driver.quit();
	}
}