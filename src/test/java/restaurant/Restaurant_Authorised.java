package restaurant;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Restaurant_Authorised {

	public static void main(String[] args) throws Throwable {

	// Get data from common data
		FileInputStream fileInputStream=new FileInputStream("./src/test/resources/data/commondata.properties");
		Properties properties=new Properties();
		properties.load(fileInputStream);
		String url = properties.getProperty("muser_url");
		String username = properties.getProperty("musername");
		String password = properties.getProperty("mpassword");
		
		WebDriver driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("submit")).click();
		
		driver.findElement(By.xpath("//a[text()='Restaurants ']")).click();
		driver.findElement(By.xpath("//a[text()='View Menu'and@href=\"dishes.php?res_id=1\"]")).click();
		driver.findElement(By.xpath("(//input[@value=\"Add To Cart\"and@type=\"submit\"])[1]")).click();
		driver.findElement(By.xpath("//a[text()='Checkout']")).click();
		Thread.sleep(3000);
		String text = driver.getTitle();
		System.out.println(text);
		if (text.equals("Checkout")) {
			
			driver.findElement(By.xpath("//input[@name='submit']")).click();
			String atitle = driver.switchTo().alert().getText();
			if (atitle.equals("Do you want to confirm the order?")) {
				driver.switchTo().alert().accept();
			}
			String btitle = driver.switchTo().alert().getText();
			if (btitle.equals("Thank you. Your Order has been placed!")) {
				driver.switchTo().alert().accept();
			}
			Thread.sleep(3000);
			String title = driver.getTitle();
			System.out.println(title+" Page is displayed and System testing is passed");
		}
		else {
			System.out.println("System testing is failed");
		}
		
	//	driver.close();
			
	}

}
