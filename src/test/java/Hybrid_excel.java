import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Hybrid_excel {

	static XSSFWorkbook workbbok;
	static XSSFSheet sheet;
	
	public static void setExcelFile(String path,String sheetname) throws IOException
	{
		FileInputStream fis = new FileInputStream(path);
		workbbok = new XSSFWorkbook(fis);
		sheet =  workbbok.getSheet(sheetname);
	}
	public static String getcelldata(int row,int column)
	{
		Cell cell= sheet.getRow(row).getCell(column);
		String celldata = cell.getStringCellValue();
		return celldata;
	}
}
