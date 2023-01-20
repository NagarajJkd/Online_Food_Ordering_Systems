package restaurant;

import java.io.File;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.commons.collections4.Put;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.OFOS.generic.ExcellUtility;
import com.OFOS.generic.FileUtility;
import com.OFOS.generic.JavaUtility;
import com.OFOS.generic.WebDriverUtility;

public class AddRestaurantByGCM {

	public static void main(String[] args) throws Throwable {

		FileUtility fiu=new FileUtility();
		WebDriverUtility wdu=new WebDriverUtility();
		ExcellUtility exu=new ExcellUtility();
		JavaUtility ju=new JavaUtility();
		int ran = ju.randomNumber(50);
		String url = fiu.readDataFromPropertyFile("admin_url");
		String username = fiu.readDataFromPropertyFile("username");
		String password = fiu.readDataFromPropertyFile("password");
		
		WebDriver driver=new ChromeDriver();
		driver.get(url);
		
		driver.manage().window().maximize();
		
		wdu.waitForPageToLoad(driver, 10);
		
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("submit")).click();
		
		driver.findElement(By.xpath("//span[text()='Restaurant']")).click();
		driver.findElement(By.xpath("//a[text()='Add Restaurant']")).click();
		
		int count = exu.getLastRowNumberFromExcell("addRestaurant");
		System.out.println(count);
		
		String atualresturant = exu.readDataFromExcell("addRestaurant", 1, 1);
		
		for (int i = 1; i <=count; i++) {
			String path = exu.readDataFromExcell("addRestaurant", i, 0);
			String value = exu.readDataFromExcell("addRestaurant", i, 1);
			driver.findElement(By.name(path)).sendKeys(value);
		
		}
		HashMap<String, String> hs=new HashMap<String, String>();
		hs.put("o_hr", "9am");
		hs.put("c_hr", "9pm");
		hs.put("o_days", "Mon-Fri");
		hs.put("c_name", "Indian");
		
		for(Entry<String, String> set:hs.entrySet()) {
			WebElement ele = driver.findElement(By.name(set.getKey()));
			wdu.selectt(ele, set.getValue());
		}
		
		File f=new File("./src/test/resources/data/User Login.png");
		String absolute = f.getAbsolutePath();
		driver.findElement(By.id("lastName")).sendKeys(absolute);
		
		driver.findElement(By.name("submit")).click();
		
		//wdu.waitForPageToLoadForJSElement(driver, 10);
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a[.='All Restaurants']")).click();
		Thread.sleep(3000);
		
		driver.close();
			String expectedrestaurant = driver.findElement(By.xpath("//td[text()='"+atualresturant+"']")).getText();
		
		if (atualresturant.equals(expectedrestaurant)) {
			
			System.out.println("Restaurant added successfully");	
		}
		else {

			System.out.println("Restaurant not added");
		}
		
	}

}
