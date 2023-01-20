package restaurant;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

public class AddRestaurant {

	public static void main(String[] args) throws Throwable {
		// get data from common file
		FileInputStream fis=new FileInputStream("./src/test/resources/data/commondata.properties");
		Properties properties=new Properties();
		properties.load(fis);
		String url = properties.getProperty("admin_url");
		String un=properties.getProperty("username");
		String pwd=properties.getProperty("password");
		
		//get data from excell
		FileInputStream fi=new FileInputStream("./src/test/resources/data/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		//String data = wb.getSheet("addRestaurant").getRow(1).getCell(0).getStringCellValue();
		
		WebDriver driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.name("username")).sendKeys(un);
		driver.findElement(By.name("password")).sendKeys(pwd);
		driver.findElement(By.name("submit")).click();
		
		Random random=new Random();
		int ran = random.nextInt(50);
		String atualresturant = "SpotTea"+ran;
		
		driver.findElement(By.xpath("//span[text()='Restaurant']")).click();
		driver.findElement(By.xpath("//a[text()='Add Restaurant']")).click();
		
	/*	ArrayList<String> list = new ArrayList<String>();
		list.add("res_name");
		list.add("email");
		//list.add("phone");
		//list.add("url");
		Sheet sh = wb.getSheet("addRestaurant");
		int count = sh.getLastRowNum();
		
		for (int i = 0; i <= 1; i++) {
			String data = wb.getSheet("addRestaurant").getRow(i).getCell(1).getStringCellValue()+ran;
			driver.findElement(By.name(list.get(i))).sendKeys(data);
			
		}
		//String data1 = wb.getSheet("addRestaurant").getRow(2).getCell(1).getStringCellValue();
		//String data2 = wb.getSheet("addRestaurant").getRow(3).getCell(1).getStringCellValue();*/
		
		HashMap<String, String> hs = new HashMap<String, String>();
		hs.put("name", "res_name");
		
		Collection<String> vl = hs.values();
		String l = hs.get("name");
		System.out.println(l);
		
		driver.findElement(By.name(l)).sendKeys(atualresturant);
		driver.findElement(By.name("email")).sendKeys("cofeeday@gmail.com");
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("9876451230");
		driver.findElement(By.xpath("//input[@name='url']")).sendKeys("www.cofeeday.com");
		
		WebElement ele = driver.findElement(By.name("o_hr"));
		Select s=new Select(ele);
		s.selectByVisibleText("9am");
		WebElement ele1 = driver.findElement(By.name("c_hr"));
		Select s1=new Select(ele1);
		s1.selectByVisibleText("9pm");
		WebElement ele2 = driver.findElement(By.name("o_days"));
		Select s2=new Select(ele2);
		s2.selectByVisibleText("Mon-Fri");
		
		File f=new File("./src/test/resources/data/User Login.png");
		String absolute = f.getAbsolutePath();
		driver.findElement(By.id("lastName")).sendKeys(absolute);
		
		WebElement ele3 = driver.findElement(By.name("c_name"));
		Select s3=new Select(ele3);
		s3.selectByVisibleText("Indian");
		
		driver.findElement(By.xpath("//textarea[@name='address']")).sendKeys("BTM 2nd Stage");
		
		driver.findElement(By.name("submit")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a[@href=\"all_restaurant.php\"]")).click();
		Thread.sleep(3000);
		String expectedrestaurant = driver.findElement(By.xpath("//td[text()='"+atualresturant+"']")).getText();
		
		if (atualresturant.equals(expectedrestaurant)) {
			
			System.out.println("Restaurant added successfully");	
		}
		else {

			System.out.println("Restaurant not added");
		}
		
		driver.close();
	
	}

}
