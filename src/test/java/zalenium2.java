import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class zalenium2 {
	
	@Test(priority = 1)
	public void chrome3() throws IOException
	{
		ChromeOptions chromeoption = new ChromeOptions();
		chromeoption.addArguments("--disable-dev-shm-usage");
		
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),chromeoption);
		driver.manage().window().maximize();
		driver.get("https://www.selenium.dev/");
		System.out.println("chrome3");
		driver.quit();
	}
	@Test(priority = 2)
	public void firefox3() throws IOException
	{
		FirefoxOptions firefoxoption = new FirefoxOptions();
		firefoxoption.addArguments("--disable-dev-shm-usage");
		
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),firefoxoption);
		driver.manage().window().maximize();
		driver.get("https://www.youtube.com/");
		System.out.println("firefox3");
		driver.quit();
	}
}
