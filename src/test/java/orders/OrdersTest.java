package orders;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrdersTest {

	public static void main(String[] args) throws Throwable {

		// get common data
		FileInputStream fis=new FileInputStream("./src/test/resources/data/commondata.properties");
		Properties p=new Properties();
		p.load(fis);
		String URL = p.getProperty("user_url");
		String USERNAME = p.getProperty("user");
		String PASSWORD = p.getProperty("pwd");
		
		//GET data from excell
		FileInputStream fi=new FileInputStream("./src/test/resources/data/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet("addMenu");
		//String data = sh.getRow(0).getCell(1).getStringCellValue();
		int count = sh.getLastRowNum();
		
		WebDriver driver=new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		
		driver.findElement(By.name("username")).sendKeys(USERNAME);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		driver.findElement(By.name("submit")).click();
		
		driver.findElement(By.xpath("//a[text()='Restaurants ']")).click();
		driver.findElement(By.xpath("//a[text()='North Street Tavern']")).click();
		driver.findElement(By.xpath("(//input[@value=\"Add To Cart\"])[1]")).click();
		driver.findElement(By.xpath("//a[text()='Checkout']")).click();
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		driver.switchTo().alert().accept();
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		driver.close();
		
		Thread.sleep(3000);
		
		// get common data
		FileInputStream fis1=new FileInputStream("./src/test/resources/data/commondata.properties");
		Properties p1=new Properties();
		p1.load(fis1);
		String URL1 = p1.getProperty("admin_url");
		String USERNAME1 = p1.getProperty("username");
		String PASSWORD1 = p1.getProperty("password");
		
	
		WebDriver driver2=new ChromeDriver();
		driver2.get(URL1);
		driver2.manage().window().maximize();
		driver2.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver2.findElement(By.xpath("//input[@name='username']")).sendKeys(USERNAME1);
		driver2.findElement(By.xpath("//input[@name='password']")).sendKeys(PASSWORD1);
		driver2.findElement(By.xpath("//input[@name='submit']")).click();
		driver2.findElement(By.xpath("//span[text()='Orders']")).click();
		
		String user = driver2.findElement(By.xpath("//tr/child::td[text()='raj']")).getText();
		System.out.println(user);
		if("raj".equals(user)) {
			System.out.println("Order is placed Successfully");
		}
		else {
			System.out.println("Order is not placed");
		}
		driver2.close();
	}

}
// TC_OFOS_07 Restaurant(authorized)