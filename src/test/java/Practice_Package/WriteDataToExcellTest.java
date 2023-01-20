package Practice_Package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataToExcellTest {

	public static void main(String[] args) throws Throwable {

		FileInputStream fileInputStream=new FileInputStream("src/test/resources/data/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fileInputStream);
		Sheet sh = wb.getSheet("addCategories");
		Cell rc = sh.getRow(6).getCell(1);
		rc.setCellValue("1225");
		FileOutputStream fileOutputStream=new FileOutputStream("src/test/resources/data/TestData.xlsx");
		wb.write(fileOutputStream);
		wb.close();
		System.out.println("done");
		
		
	}

}
