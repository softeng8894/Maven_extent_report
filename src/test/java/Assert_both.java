import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;

public class Assert_both {

	public WebDriver driver;
	public ExtentTest test;

	@Test(priority = 1)
	public void Test1() throws IOException
	{
		SoftAssert soft = new SoftAssert();
		
		driver = Common_class.BROWSER();
		driver.manage().window().maximize();
		driver.get("https://www.selenium.dev/");

		//soft assertion
		soft.assertTrue(driver.getTitle().contains("Selenium"));

		//hard assertion
		Assert.assertTrue(driver.findElement(By.xpath("//*[@class='nav-link'][1]")).isDisplayed());
		driver.findElement(By.xpath("//*[@class='nav-link'][1]")).click();
		
		soft.assertAll();
	}

	@AfterMethod
	public void aftermethod()
	{
		driver.quit();
	}
}
