import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class docker3 {
	
	@Test(priority = 1)
	public void edge() throws IOException
	{	
		EdgeOptions edgeoption = new EdgeOptions();
		edgeoption.setCapability("browserName","MicrosoftEdge");
		
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),edgeoption);
		driver.manage().window().maximize();
		driver.get("https://www.selenium.dev/");
		System.out.println("edge");
		driver.quit();
	}
}
