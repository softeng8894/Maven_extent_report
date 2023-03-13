import java.io.IOException;
import org.testng.annotations.Test;

public class Keyword_script {

	@Test
	public void test1() throws IOException, InterruptedException
	{
		String spath = "C:\\java\\Excel\\Keyword.xlsx";
		Keyword_excel.setExcelFile(spath, "Sheet1");

		for(int i=1;i<=7;i++)
		{
			String key = Keyword_excel.getcelldata(i, 0);
			if(key.equals("openbrowser"))
			{
				Keyword_action.openbrowser();
			}
			else if(key.equals("gotourl"))
			{
				Keyword_action.gotourl();
			}
			else if(key.equals("username"))
			{
				Keyword_action.username();
			}
			else if(key.equals("password"))
			{
				Keyword_action.password();
			}
			else if(key.equals("click"))
			{
				Keyword_action.click();
			}
			else if(key.equals("logout"))
			{
				Keyword_action.logout();
			}
			else if(key.equals("closebrowser"))
			{
				Keyword_action.closebrowser();
			}
		}
	}
}
