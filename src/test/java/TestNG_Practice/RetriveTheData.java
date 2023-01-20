package TestNG_Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class RetriveTheData {

	public static void main(String[] args) throws Throwable {

		FileInputStream fis=new FileInputStream("./src/test/resources/data/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int lastrow = wb.getSheet("DataProvider").getLastRowNum()+1;
		int count = 0;
		
		for (int i = 0; i <lastrow; i++) {
			String data = wb.getSheet("DataProvider").getRow(i).getCell(0).getStringCellValue();
			System.out.println(data);
			count++;
		}
		
		System.out.println(count);
	}

}
