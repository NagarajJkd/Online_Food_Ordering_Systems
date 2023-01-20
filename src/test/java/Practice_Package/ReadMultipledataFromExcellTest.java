package Practice_Package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import io.github.bonigarcia.wdm.WdmAgent;

public class ReadMultipledataFromExcellTest {

	public static void main(String[] args) throws Throwable {

		FileInputStream fileInputStream=new FileInputStream("src\\test\\resources\\data\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fileInputStream);
		Sheet sh = wb.getSheet("addCategories");
		int count = sh.getLastRowNum();
		int count1=sh.getRow(count).getLastCellNum();
		for(int i=0; i<=count; i++) {
			
			for(int j=0; j<count1; j++) {
			//String data = sh.getRow(i).getCell(0).getStringCellValue();
			String data1=sh.getRow(i).getCell(j).getStringCellValue();
			
			System.out.print(data1+" ");
			
			}
			
			System.out.println();
		}
		
	}

}
