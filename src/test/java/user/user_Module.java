package user;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections4.Put;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class user_Module {

	public static void main(String[] args) throws EncryptedDocumentException, IOException, Throwable {
		// get common data
				FileInputStream fis=new FileInputStream("./src/test/resources/data/commondata.property");
				Properties p=new Properties();
				p.load(fis);
				String URL = p.getProperty("user_url");
				String USERNAME = p.getProperty("user");
				String PASSWORD = p.getProperty("pwd");
				
				//GET data from excell
				FileInputStream fi=new FileInputStream("./src/test/resources/data/TestData.xlsx");
				Workbook wb = WorkbookFactory.create(fi);
				Sheet sh = wb.getSheet("Sheet1");
				//String data = sh.getRow(0).getCell(1).getStringCellValue();
				int count = sh.getLastRowNum();
				
				WebDriver driver=new ChromeDriver();
				driver.get(URL);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElement(By.xpath("//a[text()='Register']")).click();
				HashMap<String, String> hs=new HashMap<String, String>();
				/*hs.put("username", "JohnD");
				hs.put("firstname", "John");
				hs.put("lastname", "Dere");
				hs.put("email", "john@gmail.com");
				hs.put("phone", "9698979594");
				hs.put("password", "John258");
				hs.put("cpassword", "John258");
				hs.put("address", "South Tomriver NJ");*/
				
				for (int i = 0; i <=count; i++) {

					String key = sh.getRow(i).getCell(0).getStringCellValue();
					String value = sh.getRow(i).getCell(5).getStringCellValue();
					hs.put(key, value);
				}
				for(Entry<String, String> set:hs.entrySet()) {
					driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
				}
				
				driver.findElement(By.name("submit")).click();
				Thread.sleep(3000);
				String actualtitle = driver.getTitle();
				//System.out.println(actualtitle);
				String expectedtitle="Login";
				
				if (actualtitle.equals(expectedtitle)) {
					System.out.println("Login page displayed successfully");
				}
				else {
					System.out.println("Login page is not displayed");
				}
				
				driver.close();
				
	}

}
