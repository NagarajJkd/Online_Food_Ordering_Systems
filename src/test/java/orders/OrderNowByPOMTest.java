package orders;

import org.bouncycastle.crypto.ec.ECNewPublicKeyTransform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.OFOS.generic.FileUtility;
import com.OFOS.generic.WebDriverUtility;
import com.OFOS.pom.CheckOutPage;
import com.OFOS.pom.DishesPage;
import com.OFOS.pom.HomePage;
import com.OFOS.pom.LogInPage;

public class OrderNowByPOMTest {

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
		
		HomePage hp=new HomePage(driver);
		hp.getLoginElement().click();
		
		LogInPage lp=new LogInPage(driver);
		lp.setlogin(username, password);
		
		hp.getOrderNow().click();
		
		DishesPage dp=new DishesPage(driver);
		dp.getAddtocardElement().click();
		dp.getCheckoutbtn().click();
		
		CheckOutPage cp=new CheckOutPage(driver);
		cp.getOrderNowBtn().click();
		
		String orderconfirm = driver.switchTo().alert().getText();
		
		String alertText = "Do you want to confirm the order?";
		
		if (orderconfirm.contains(alertText)) {
			driver.switchTo().alert().accept();
		}
		
		String greeting = driver.switchTo().alert().getText();
		String alertText2 = "Thank you. Your Order has been placed!";
		
		if (greeting.contains(alertText2)) {
			driver.switchTo().alert().accept();
		}
		
		String title = driver.getTitle();
		
		if (title.equals("My Orders")) {
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
