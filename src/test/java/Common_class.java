import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Common_class {

	public static WebDriver BROWSER()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}
	public static WebDriver URL(WebDriver driver)
	{
		driver.get("http://192.53.170.95/everywherelive-admin-api/admin");
		return driver;
	}
	public static void CAPTURESS(WebDriver driver,String filename) throws IOException
	{
		TakesScreenshot ss = (TakesScreenshot)driver;
		File file = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file,new File("C:\\java\\DSS\\"+ filename +""));
	}
	public static void PASSTESTDATA(WebDriver driver)
	{
		driver.findElement(By.xpath("//*[@type='email']")).sendKeys("admin@everywherelive.com");
		driver.findElement(By.xpath("//*[@type='password']")).sendKeys("Admin@123");
		driver.findElement(By.xpath("//*[@id='submit']")).click();
	}
}
