import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Keyword_action {

	public static WebDriver driver;

	public static void openbrowser()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	public static void gotourl()
	{
		driver.get("http://192.53.170.95/everywherelive-admin-api/admin");
	}
	public static void username() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@type='email']")).sendKeys("admin@everywherelive.com");
	}
	public static void password() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@type='password']")).sendKeys("Admin@123");
	}
	public static void click() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='submit']")).click();
	}
	public static void logout() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//*[@data-toggle='dropdown']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//*[@class='fas fa-sign-out-alt']")).click();
	}
	public static void closebrowser() throws InterruptedException
	{
		driver.quit();
	}

}
