package orders;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.OFOS.generic.FileUtility;
import com.OFOS.generic.WebDriverUtility;

public class OrdersByGCMTest {

	public static void main(String[] args) throws Throwable {
		
		FileUtility fiu=new FileUtility();
		WebDriverUtility wdu=new WebDriverUtility();
		
		//user login credentials
		String URL = fiu.readDataFromPropertyFile("user_url");
		String USERNAME = fiu.readDataFromPropertyFile("user");
		String PASSWORD = fiu.readDataFromPropertyFile("pwd");
		
		//admin login credentials
		String url = fiu.readDataFromPropertyFile("admin_url");
		String username = fiu.readDataFromPropertyFile("username");
		String password = fiu.readDataFromPropertyFile("password");
		
		WebDriver driver=new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		
		wdu.waitForPageToLoad(driver, 10);
		
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
		
		System.out.println("I have placed an order please deliver the order ASAP");
		
		Thread.sleep(3000);
		
		WebDriver driver2=new ChromeDriver();
		driver2.get(url);
		driver2.manage().window().maximize();
		driver2.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver2.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
		driver2.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver2.findElement(By.xpath("//input[@name='submit']")).click();
		
		driver2.findElement(By.xpath("//span[text()='Orders']")).click();
		
		String user = driver2.findElement(By.xpath("//tr/child::td[text()='raj']")).getText();

		if(USERNAME.equals(user)) {
			System.out.println("Your Order is placed Successfully Thank You");
		}
		else {
			System.out.println("Your Order is not placed please re-order it");
		}
		driver2.close();

	}

}
