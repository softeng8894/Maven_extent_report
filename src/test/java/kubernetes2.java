import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class kubernetes2 {
	
	@Test(priority = 1)
	public void chrome1() throws IOException
	{
		ChromeOptions chromeoption = new ChromeOptions();
		chromeoption.setCapability("browserName","chrome");
		
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://127.0.0.1:60622"),chromeoption);
		driver.manage().window().maximize();
		driver.get("https://www.selenium.dev/");
		System.out.println("chrome1");
		driver.quit();
	}
	@Test(priority = 2)
	public void chrome2() throws IOException
	{
		ChromeOptions chromeoption = new ChromeOptions();
		chromeoption.setCapability("browserName","chrome");
		
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://127.0.0.1:60622"),chromeoption);
		driver.manage().window().maximize();
		driver.get("https://www.selenium.dev/");
		System.out.println("chrome2");
		driver.quit();
	}
}
