import java.io.IOException;
import org.testng.annotations.Test;

public class Hybrid_script {

	@Test
	public void test1() throws IOException, InterruptedException
	{
		String spath = "C:\\java\\Excel\\hybrid.xlsx";
		Hybrid_excel.setExcelFile(spath, "Sheet1");

		for(int i=1;i<=7;i++)
		{
			String key = Hybrid_excel.getcelldata(i, 0);
			String testdata = Hybrid_excel.getcelldata(i, 1);
			String locator = Hybrid_excel.getcelldata(i, 2);
			if(key.equals("openbrowser"))
			{
				Hybrid_action.openbrowser();
			}
			else if(key.equals("gotourl"))
			{
				Hybrid_action.gotourl(testdata);
			}
			else if(key.equals("username"))
			{
				Hybrid_action.username(testdata,locator);
			}
			else if(key.equals("password"))
			{
				Hybrid_action.password(testdata,locator);
			}
			else if(key.equals("click"))
			{
				Hybrid_action.click(locator);
			}
			else if(key.equals("logout"))
			{
				Hybrid_action.logout();
			}
			else if(key.equals("closebrowser"))
			{
				Hybrid_action.closebrowser();
			}
		}
	}

}
