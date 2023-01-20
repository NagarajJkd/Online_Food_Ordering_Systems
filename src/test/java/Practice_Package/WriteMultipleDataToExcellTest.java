package Practice_Package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteMultipleDataToExcellTest {

	public static void main(String[] args) throws Throwable {

		FileInputStream fileInputStream=new FileInputStream("./src/test/resources/data/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fileInputStream);
		String[] rst={"ChatStreet", "Cofee-Day", "Nest-Cafe", "Street-point", "Small-Canteen", "Tea-Point"};
		for(int i=0; i<10; i++) {
			
			for(int j=i; j<rst.length; j++) {
				
		wb.getSheet("addRestaurant").createRow(i).createCell(0).setCellValue(rst[i]);
			}
			
		}
		
		FileOutputStream fileOutputStream=new FileOutputStream("./src/test/resources/data/TestData.xlsx");
		wb.write(fileOutputStream);
		wb.close();
		System.out.println("Done");
		
		
	}

}
