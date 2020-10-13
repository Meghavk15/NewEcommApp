package tests;

import GenericLibrary.AutoConstants;
import GenericLibrary.GenericExcelLibrary;

public class TC002 implements AutoConstants {
	
	public static void main(String[] args) {
		
		Object[][] arr = GenericExcelLibrary.getExcelData(XL_PATH, "Sheet1");
		for(Object[] obj:arr)
		{
			for(Object o:obj)
			{
				System.out.print(o+"::");
			}
			System.out.println();
		}
		
	}

}
