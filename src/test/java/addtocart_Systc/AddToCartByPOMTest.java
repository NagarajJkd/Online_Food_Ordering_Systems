package addtocart_Systc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.OFOS.generic.FileUtility;
import com.OFOS.generic.WebDriverUtility;
import com.OFOS.pom.DishesPage;
import com.OFOS.pom.HomePage;
import com.OFOS.pom.LogInPage;

public class AddToCartByPOMTest {

	public static void main(String[] args) throws Throwable {

		WebDriver driver=new ChromeDriver();
		WebDriverUtility wdu=new WebDriverUtility();
		FileUtility fiu=new FileUtility();
		String url = fiu.readDataFromPropertyFile("muser_url");
		String username1 = fiu.readDataFromPropertyFile("musername");
		String password1 = fiu.readDataFromPropertyFile("mpassword");
		
		driver.get(url);
		driver.manage().window().maximize();
		
		wdu.waitForPageToLoad(driver, 10);
		
		HomePage hp=new HomePage(driver);
		hp.getLoginElement().click();
		
		LogInPage lp=new LogInPage(driver);
		lp.setlogin(username1, password1);
		
		hp.getOrderNow().click();
		DishesPage d=new DishesPage(driver);
		d.getAddToCartbtn().click();
		boolean result = d.getCheckoutbtn().isEnabled();
		
		if (result) {

			System.out.println("Add to Cart Button is working");
		}
		else {

			System.out.println("Add to Cart Button is not working");
		}
		
		driver.close();
		
	}

}
