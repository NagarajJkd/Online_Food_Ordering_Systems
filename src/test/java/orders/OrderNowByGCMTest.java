package orders;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.OFOS.generic.FileUtility;
import com.OFOS.generic.WebDriverUtility;

public class OrderNowByGCMTest {

	public static void main(String[] args) throws Throwable {

		FileUtility fiu=new FileUtility();
		WebDriverUtility wdu=new WebDriverUtility();
		
		String url = fiu.readDataFromPropertyFile("muser_url");
		String username = fiu.readDataFromPropertyFile("musername");
		String password = fiu.readDataFromPropertyFile("mpassword");
		
		WebDriver driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
		wdu.waitForPageToLoad(driver, 10);
		
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("submit")).click();
		
		driver.findElement(By.xpath("(//a[@href=\"dishes.php?res_id=1\"and@class=\"btn theme-btn-dash pull-right\"])[1]")).click();
		driver.findElement(By.xpath("(//div[@class=\"row\"]/child::div[2]/input[@value=\"Add To Cart\"])[1]")).click();
		driver.findElement(By.xpath("//a[text()='Checkout']")).click();
		driver.findElement(By.xpath("//input[@name=\"submit\"]")).click();
		driver.switchTo().alert().accept();
		wdu.waitForPageToLoadForJSElement(driver, 10);
		driver.switchTo().alert().accept();
		wdu.waitForPageToLoadForJSElement(driver, 10);
		String text = driver.getTitle();
	
		if (text.equals("My Orders")) {
			System.out.println("My orders page is displayed");
			System.out.println("System testing is passed");
			driver.close();
		}
		else {
			System.out.println("My orders page is not displayed");
			System.out.println("System testing is failed");
			driver.close();
		}
		
		
	}

}
