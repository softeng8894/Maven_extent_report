import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class docker1 {
	
	@Test(priority = 1)
	public void chrome() throws IOException
	{		
		ChromeOptions chromeoption = new ChromeOptions();
		chromeoption.setCapability("browserName","chrome");
		
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),chromeoption);
		driver.manage().window().maximize();
		driver.get("https://www.selenium.dev/");
		System.out.println("chrome");
		driver.quit();
	}
}
