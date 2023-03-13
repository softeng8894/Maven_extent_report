import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Pom_script {

	public WebDriver driver;

	@BeforeMethod
	public void before()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://192.53.170.95/everywherelive-admin-api/admin");
	}

	@Test
	public void pom() throws InterruptedException
	{
		Pom_object_repository repo = PageFactory.initElements(driver,Pom_object_repository.class);
		repo.Test1();
		Thread.sleep(2000);
	}

	@AfterMethod
	public void after()
	{
		driver.quit();
	}

}
