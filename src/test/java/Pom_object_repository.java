import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Pom_object_repository {

	@FindBy(how = How.XPATH,using="//*[@type='email']") @CacheLookup WebElement email;
	@FindBy(how = How.XPATH,using="//*[@type='password']") @CacheLookup WebElement password;
	@FindBy(how = How.XPATH,using="//*[@id='submit']") @CacheLookup WebElement button;

	public void Test1()
	{
		email.sendKeys("admin@everywherelive.com");
		password.sendKeys("Admin@123");
		button.click();
	}
}
