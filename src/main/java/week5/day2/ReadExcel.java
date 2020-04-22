package week5.day2;

import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static String[][] fillTheArray(String fileName) throws IOException
	{
		FileInputStream fis=new FileInputStream(new File("./data/" +fileName+ ".xls"));  
		HSSFWorkbook wbook= new HSSFWorkbook(fis);
		HSSFSheet sheet = wbook.getSheetAt(0);
		int numberOfRows = sheet.getPhysicalNumberOfRows();
		int numberOfCells = sheet.getRow(0).getPhysicalNumberOfCells();
		String[][] excelData = new String[numberOfRows-1][numberOfCells];
		
		for (int i = 1; i < numberOfRows; i++)
		{
			HSSFRow row = sheet.getRow(i);
			
			for (int j = 0; j < numberOfCells; j++)
			{
				HSSFCell cell = row.getCell(j);
				excelData[i-1][j]=cell.getStringCellValue();
			} 
		}
		return excelData;
	}

}
