import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class docker {

	public static void main(String[] args) throws MalformedURLException{
		System.setProperty("webdriver.chrome.driver","C:\\java\\chromedriver_win32\\chromedriver.exe");
		
		ChromeOptions chromeoption = new ChromeOptions();
		chromeoption.setCapability("browserName","chrome");
		
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),chromeoption);
		driver.manage().window().maximize();
		driver.get("https://www.selenium.dev/");
		System.out.println("done");
		driver.quit();
	}

}
