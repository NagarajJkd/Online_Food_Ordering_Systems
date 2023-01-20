package Practice_Package;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SelectaDate {

	public static void main(String[] args) {

		WebDriver driver =new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[text()='Create New Account']")).click();
		driver.findElement(By.xpath("//select[@id=\"day\"]/child::option[17]")).click();
		WebElement ele = driver.findElement(By.xpath("//select[@id=\"day\"]"));
		Actions actions=new Actions(driver);
		actions.moveToElement(ele, 0, 10).click().perform();
		driver.findElement(By.xpath("//div[@class=\"_3ixn\"]")).click();
		
	}

}
