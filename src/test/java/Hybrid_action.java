import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hybrid_action {

	public static WebDriver driver;

	public static void openbrowser()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	public static void gotourl(String url)
	{
		driver.get(url);
	}
	public static void username(String username,String ulocator) throws InterruptedException
	{
		Thread.sleep(5000);
		driver.findElement(By.xpath(ulocator)).sendKeys(username);
	}
	public static void password(String password,String plocator) throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(By.xpath(plocator)).sendKeys(password);
	}
	public static void click(String blocator) throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(By.xpath(blocator)).click();
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
