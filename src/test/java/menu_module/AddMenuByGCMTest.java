package menu_module;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.OFOS.generic.ExcellUtility;
import com.OFOS.generic.FileUtility;
import com.OFOS.generic.WebDriverUtility;

public class AddMenuByGCMTest {
	public static void main(String[] args) throws Throwable {
	
		WebDriverUtility wdu=new WebDriverUtility();
		FileUtility fiu=new FileUtility();
		ExcellUtility exc=new ExcellUtility();
		
		String url = fiu.readDataFromPropertyFile("admin_url");
		String username = fiu.readDataFromPropertyFile("username");
		String password = fiu.readDataFromPropertyFile("password");
		
		WebDriver driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
		wdu.waitForPageToLoad(driver, 10);
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		
		driver.findElement(By.xpath("//span[text()='Menu']")).click();
		
		driver.findElement(By.xpath("//a[text()='Add Menu']")).click();
		
//		ArrayList<String> list=new ArrayList<String>();
//		list.add("d_name");
//		list.add("about");
//		list.add("price");
//		list.add("file");
//		list.add("res_name");
//		//list.add("submit");

		ArrayList<String> path = exc.getArrayList("addMenu", 0, 2);
		
		for (int i = 0; i <exc.getLastRowNumberFromExcell("addMenu") ; i++) {
			String data = exc.readDataFromExcell("addMenu", i, 1); 
			driver.findElement(By.name(path.get(i))).sendKeys(data);
		}
		
		WebElement ele = driver.findElement(By.name("res_name"));
		wdu.select(ele, "1");
	
		driver.findElement(By.name("submit")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//a[text()='All Menues']")).click();	
		
		String cat = driver.findElement(By.xpath("//tr[@role='row']/child::td[2]")).getText();
		System.out.println(cat);
		String dishname = exc.readDataFromExcell("addMenu", 0, 1);
		//String dishname="Emmy and testy";
		if (dishname.equals(cat)) {
			System.out.println("Dish is get added successfully "+dishname);
		}
		else {
			System.out.println("Dish is not get added");
		}

	}
}
