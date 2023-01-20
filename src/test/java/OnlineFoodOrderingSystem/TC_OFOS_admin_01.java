package OnlineFoodOrderingSystem;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TC_OFOS_admin_01 {

	public static void main(String[] args) throws Throwable {
		
		//Get data from property file
		FileInputStream fis=new FileInputStream("./src/test/resources/data/commondata.property");
		
		Properties properties=new Properties();
		properties.load(fis);
		
		String url = properties.getProperty("admin_url");
		String un = properties.getProperty("username");
		String pwd = properties.getProperty("password");

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get(url);
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(un);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		
		driver.close();
		
	}

}
