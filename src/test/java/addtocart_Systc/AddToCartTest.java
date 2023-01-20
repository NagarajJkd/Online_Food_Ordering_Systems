
// Smoke
package addtocart_Systc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mysql.cj.jdbc.Driver;

public class AddToCartTest {

	public static void main(String[] args) throws Throwable {

		//get common data
		FileInputStream fileInputStream=new FileInputStream("./src/test/resources/data/commondata.property");
		Properties properties=new Properties();
		properties.load(fileInputStream);
		String url = properties.getProperty("muser_url");
		String username = properties.getProperty("musername");
		String password = properties.getProperty("mpassword");
		
		WebDriver driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("submit")).click();
		
		driver.findElement(By.xpath("(//a[@href=\"dishes.php?res_id=1\"and@class=\"btn theme-btn-dash pull-right\"])[1]")).click();
		driver.findElement(By.xpath("(//div[@class=\"row\"]/child::div[2]/input[@value=\"Add To Cart\"])[1]")).click();
		boolean enable = driver.findElement(By.xpath("//a[text()='Checkout']")).isEnabled();
		System.out.println(enable);
		if (enable) {
			System.out.println("Add to Cart Button is working");
		}
		else {
			System.out.println("Add to Cart Button is not working");
		}
	}

}
