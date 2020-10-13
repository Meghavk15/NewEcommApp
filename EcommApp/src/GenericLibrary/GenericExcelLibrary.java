package GenericLibrary;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Reporter;

public class GenericExcelLibrary {
	
	public static String getDataFromExcel(String path,String sh,int r,int c) {
		
		String value = null;
		try {
		FileInputStream fin = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fin);
		value = wb.getSheet(sh).getRow(r).getCell(c).getStringCellValue();
			}
		catch(Exception e)
		{
			Reporter.log("Not able to read the data",true);
		}
		return value;
		
	}
	
	public static Object[][] getExcelData(String path,String sheetName)
	{
		Object[][] arr = null;
		try {
			FileInputStream fin = new FileInputStream(path);
			Workbook wb = WorkbookFactory.create(fin);
			Sheet sheet = wb.getSheet(sheetName);
			int rows = sheet.getPhysicalNumberOfRows();
			arr = new Object[rows][3];
			for(int i = 1;i<=rows-1;i++)
			{
				int cells = sheet.getRow(i).getPhysicalNumberOfCells();
				for(int j = 0;j<=cells-1;j++)
				{
					arr[i][j] = sheet.getRow(i).getCell(j).toString();
				}
			}
				}
			catch(Exception e)
			{
				Reporter.log("Not able to read the data",true);
			}
		return arr;
	}

}
