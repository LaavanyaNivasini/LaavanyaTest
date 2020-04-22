package week5.day2;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//This was created as a seperate class file to make us understand the code flow to get data from excel.
//Otherwise we use this code in the @Test java file itself under @Dataprovider only
public class ReadFromExcel {

	public static void main(String[] args) throws IOException 
	{ //if file is not present there might be excption
		XSSFWorkbook wbook = new XSSFWorkbook("./data/testdatalatest.xlsx");
		XSSFSheet sheet = wbook.getSheet("Sheet1");
			int lastRowNum = sheet.getLastRowNum();
			int lastCellNum = sheet.getRow(0).getLastCellNum();
			
		for (int j = 0; j <=lastRowNum ; j++)   //weuse <= since getLastRowNum by default assumes we have header in frst line and ignores it
		{
			XSSFRow row = sheet.getRow(j);
			for (int i = 0; i < lastCellNum; i++)
			{
				XSSFCell cell = row.getCell(i);
				String stringCellValue = cell.getStringCellValue();
				System.out.println(stringCellValue);
			} 
		}
		wbook.close();
	}

}
