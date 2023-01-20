package user;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.OFOS.generic.ExcellUtility;
import com.OFOS.generic.FileUtility;
import com.OFOS.generic.WebDriverUtility;

public class User_ModuleByGCM {

	public static void main(String[] args) throws Throwable {

		FileUtility fiu=new FileUtility();
		WebDriverUtility wdu=new WebDriverUtility();
		ExcellUtility exu=new ExcellUtility();
		
		String url = fiu.readDataFromPropertyFile("user_url");
		String username = fiu.readDataFromPropertyFile("user");
		String password = fiu.readDataFromPropertyFile("pwd");
		
		WebDriver driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
		wdu.waitForPageToLoad(driver, 10);
		
		driver.findElement(By.xpath("//a[text()='Register']")).click();
		
		HashMap<String, String> reglist = exu.getList("registration", 0, 5);
		
		for(Entry<String, String> set:reglist.entrySet()) {
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
		}
		
		driver.findElement(By.name("submit")).click();
		Thread.sleep(3000);
		
		String actualtitle = driver.getTitle();

		String expectedtitle="Login";
		
		if (actualtitle.equals(expectedtitle)) {
			System.out.println("Login page displayed successfully and system testing is passed");
		}
		else {
			System.out.println("Login page is not displayed and system testing is fail");
		}
		
		driver.close();
		
		
	}

}
