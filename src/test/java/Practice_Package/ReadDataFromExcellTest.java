package Practice_Package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcellTest {

	public static void main(String[] args) throws Throwable {

		FileInputStream fileInputStream=new FileInputStream(".\\src\\test\\resources\\data\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fileInputStream);
		Sheet sh = wb.getSheet("addCategories");
		Cell rc = sh.getRow(0).getCell(0);
		String data = rc.getStringCellValue();
		System.out.println(data);
	}

}
