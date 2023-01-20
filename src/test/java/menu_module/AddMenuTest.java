package menu_module;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;

public class AddMenuTest {

	public static void main(String[] args) throws Throwable {

		// get common data
		FileInputStream fis=new FileInputStream("./src/test/resources/data/commondata.property");
		Properties p=new Properties();
		p.load(fis);
		String URL = p.getProperty("admin_url");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		
		//GET data from excell
		FileInputStream fi=new FileInputStream("./src/test/resources/data/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet("addMenu");
		//String data = sh.getRow(0).getCell(1).getStringCellValue();
		int count = sh.getLastRowNum();
		
		Random ran=new Random();
		int r = ran.nextInt(500);
		
		WebDriver driver=new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		
		driver.findElement(By.xpath("//span[text()='Menu']")).click();
		driver.findElement(By.xpath("//a[text()='Add Menu']")).click();
		
		ArrayList<String> list=new ArrayList<String>();
		list.add("d_name");
		list.add("about");
		list.add("price");
		list.add("file");
		list.add("res_name");
		//list.add("submit");
		
		for (int i = 0; i <list.size() ; i++) {
			String data = sh.getRow(i).getCell(1).getStringCellValue();
			driver.findElement(By.name(list.get(i))).sendKeys(data);
		}
	
		driver.findElement(By.name("submit")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//a[text()='All Menues']")).click();		
		String cat = driver.findElement(By.xpath("//tr[@role='row']/child::td[2]")).getText();
		System.out.println(cat);
		String dishname = sh.getRow(0).getCell(1).getStringCellValue();
		//String dishname="Emmy and testy";
		if (dishname.equals(cat)) {
			System.out.println("Dish is get added successfully "+dishname);
		}
		else {
			System.out.println("Dish is not get added");
		}
		
		driver.close();
		
	}

}
