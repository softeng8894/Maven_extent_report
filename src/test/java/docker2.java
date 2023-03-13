import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class docker2 {
	
	@Test(priority = 1)
	public void firefox() throws IOException
	{	
		FirefoxOptions firefoxoption = new FirefoxOptions();
		firefoxoption.setCapability("browserName","firefox");
		
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),firefoxoption);
		driver.manage().window().maximize();
		driver.get("https://www.selenium.dev/");
		System.out.println("firefox");
		driver.quit();
	}
}
