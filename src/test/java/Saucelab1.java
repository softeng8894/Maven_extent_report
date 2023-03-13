import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Saucelab1 {
	
	public static final String USERNAME = "oauth-softeng8894-b12f2";
	public static final String ACCESS_KEY = "8472fedc-18ee-486c-ae92-e7da7e6520e8";
	public static final String URL = "https://oauth-softeng8894-b12f2:8472fedc-18ee-486c-ae92-e7da7e6520e8@ondemand.eu-central-1.saucelabs.com:443/wd/hub";
	
	@Test(priority = 1)
	public void chrome() throws IOException
	{	
		ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.setPlatformName("Windows 11");
		browserOptions.setBrowserVersion("latest");

		URL url = new URL("https://oauth-softeng8894-b12f2:8472fedc-18ee-486c-ae92-e7da7e6520e8@ondemand.eu-central-1.saucelabs.com:443/wd/hub");
		RemoteWebDriver driver = new RemoteWebDriver(url, browserOptions);
		
		driver.manage().window().maximize();
		driver.get("https://www.selenium.dev/");
		System.out.println("chrome");
		driver.quit();
	}
}
