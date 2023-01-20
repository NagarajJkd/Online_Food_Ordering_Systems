package orders;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrderNowTest {

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
				driver.findElement(By.xpath("//a[text()='Checkout']")).click();
				driver.findElement(By.xpath("//input[@name=\"submit\"]")).click();
				driver.switchTo().alert().accept();
				driver.switchTo().alert().accept();
				Thread.sleep(3000);
				String text = driver.getTitle();
				//System.out.println(text);
				if (text.equals("My Orders")) {
					System.out.println("My orders page is displayed");
					System.out.println("System testing is passed");
				}
				else {
					System.out.println("My orders page is not displayed");
					System.out.println("System testing is failed");
				}
					
				
	}

}
