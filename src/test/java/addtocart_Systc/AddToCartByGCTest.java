package addtocart_Systc;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.OFOS.generic.FileUtility;
import com.OFOS.generic.WebDriverUtility;

public class AddToCartByGCTest {

	public static void main(String[] args) throws Throwable {

		WebDriver driver=null;
		FileUtility fiu=new FileUtility();
		String url = fiu.readDataFromPropertyFile("muser_url");
		String username = fiu.readDataFromPropertyFile("musername");
		String password = fiu.readDataFromPropertyFile("mpassword");
		String browser = fiu.readDataFromPropertyFile("browser");
		
		if (browser.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else if(browser.equals("Firefox")){
			driver=new FirefoxDriver();
		}
		
		driver.get(url);
		driver.manage().window().maximize();
		
		WebDriverUtility wdu=new WebDriverUtility();
		wdu.waitForPageToLoad(driver, 10);
		
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.xpath("(//a[@href=\"dishes.php?res_id=1\"and@class=\"btn theme-btn-dash pull-right\"])[1]")).click();
		driver.findElement(By.xpath("(//div[@class=\"row\"]/child::div[2]/input[@value=\"Add To Cart\"])[1]")).click();
		boolean enable = driver.findElement(By.xpath("//a[text()='Checkout']")).isEnabled();
		if (enable) {
			System.out.println("Add to Cart Button is enabled and smoke testing is pass");
		}
		else {
			System.out.println("Add to Cart Button is not enabled and smoke testing is failed");
		}

		driver.close();
	}

}
