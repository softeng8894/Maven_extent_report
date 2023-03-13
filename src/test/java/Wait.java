import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Wait {

	public WebDriver driver;
	public ExtentTest test;

	@Test(priority = 1)
	public void implicit() throws IOException
	{
		driver = Common_class.BROWSER();
		driver.manage().window().maximize();
		driver.get("https://www.selenium.dev/");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		try
		{
			driver.findElement(By.xpath("//*[@class='nav-link'][1]")).click();
		}
		catch (Exception e)
		{
			System.out.print(e);
			test.log(Status.FAIL,"Test failed");
		}
		finally {
			driver.quit();
		}
	}

	@Test(priority = 2)
	public void explicit() throws IOException
	{
		driver = Common_class.BROWSER();
		driver.manage().window().maximize();
		driver.get("https://www.selenium.dev/");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		try
		{
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='nav-link'][1]")));
			element.click();
		}
		catch (Exception e)
		{
			System.out.print(e);
			test.log(Status.FAIL,"Test failed");
		}
		finally {
			driver.quit();
		}
	}

	@Test(priority = 3)
	public void fluent() throws IOException
	{
		driver = Common_class.BROWSER();
		driver.manage().window().maximize();
		driver.get("https://www.selenium.dev/");

		FluentWait <WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);

		try
		{
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='nav-link'][1]")));
			element.click();
		}
		catch (Exception e)
		{
			System.out.print(e);
			test.log(Status.FAIL,"Test failed");
		}
		finally {
			driver.quit();
		}
	}
}
