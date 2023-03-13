import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Dynamic {

	public WebDriver driver;
	public ExtentSparkReporter htmlreporter;
	public ExtentReports extent;
	public ExtentTest test;

	@BeforeMethod
	public void report()
	{
		
	}

	@Test(priority = 1)
	public void Test1() throws IOException
	{
		driver = Common_class.BROWSER();
		Common_class.URL(driver);

		try
		{
			Common_class.PASSTESTDATA(driver);
			Common_class.CAPTURESS(driver, "pass.jpeg");
		}
		catch (Exception e)
		{
			Common_class.CAPTURESS(driver, "fail.jpeg");
			test.log(Status.FAIL,"Test Failed");
		}
		finally {

		}
	}
	@AfterMethod
	public void reportend()
	{
		driver.quit();
	}
}
