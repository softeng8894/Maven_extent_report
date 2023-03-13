import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extent_report {

	public WebDriver driver;
	public ExtentSparkReporter htmlreporter;
	public ExtentReports extent;
	public ExtentTest test;

	int counter = 1;

	@BeforeMethod
	public void report()
	{
		if(counter == 1)
		{
			ExtentSparkReporter report = new  ExtentSparkReporter("C:\\JAVA\\Report\\index.html");
			extent = new ExtentReports();
			extent.attachReporter(report);
			counter++;
		}
	}

	@Test(priority = 1)
	public void Test1() throws IOException
	{
		driver = Common_class.BROWSER();
		driver.get("https://www.google.com/");

		try
		{
			driver.findElement(By.xpath("//*[@name='q']")).sendKeys("Automation master");
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("C:\\JAVA\\SS\\Google.jpeg"));
			ExtentTest logger = extent.createTest("Google Search");
			logger.log(Status.PASS,"Google search done").addScreenCaptureFromPath("C:\\JAVA\\SS\\Google.jpeg");
		}
		catch (Exception e)
		{
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("C:\\JAVA\\SS\\Google.jpeg"));
			ExtentTest logger = extent.createTest("Google Search");
			logger.log(Status.FAIL,"Google search done").addScreenCaptureFromPath("C:\\JAVA\\SS\\Google.jpeg");
			test.log(Status.FAIL,"Test Failed");
		}
		finally {

		}
	}

	@Test(priority = 2)
	public void Test2() throws IOException
	{
		driver = Common_class.BROWSER();
		driver.get("https://www.selenium.dev/");

		try
		{
			driver.findElement(By.xpath("//*[@class='nav-link'][1]")).click();
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("C:\\JAVA\\SS\\Selenium.jpeg"));
			ExtentTest logger = extent.createTest("Selenium official site");
			logger.log(Status.PASS,"Selenium done").addScreenCaptureFromPath("C:\\JAVA\\SS\\Selenium.jpeg");
		}
		catch (Exception e)
		{
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("C:\\JAVA\\SS\\Selenium.jpeg"));
			ExtentTest logger = extent.createTest("Selenium official site");
			logger.log(Status.FAIL,"Selenium  done").addScreenCaptureFromPath("C:\\JAVA\\SS\\Selenium.jpeg");
			test.log(Status.FAIL,"Test Failed");
		}
		finally {

		}
	}
	@AfterMethod
	public void reportend()
	{
		extent.flush();
		driver.quit();
	}
}
