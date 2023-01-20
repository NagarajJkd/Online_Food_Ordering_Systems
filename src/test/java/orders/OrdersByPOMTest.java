package orders;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.OFOS.generic.FileUtility;
import com.OFOS.generic.WebDriverUtility;
import com.OFOS.pom.AdminLoginPage;
import com.OFOS.pom.AdminPanelPage;
import com.OFOS.pom.AllOrders;
import com.OFOS.pom.CheckOutPage;
import com.OFOS.pom.DishesPage;
import com.OFOS.pom.HomePage;
import com.OFOS.pom.LogInPage;
import com.OFOS.pom.RestaurantPage;

public class OrdersByPOMTest {
	
	public static void main(String[] args) throws Throwable {
		
		FileUtility fiu=new FileUtility();
		WebDriverUtility wdu=new WebDriverUtility();
		
		//user login credentials
		String URL = fiu.readDataFromPropertyFile("user_url");
		String USERNAME = fiu.readDataFromPropertyFile("user");
		String PASSWORD = fiu.readDataFromPropertyFile("pwd");
				
		WebDriver driver=new ChromeDriver();
		driver.get(URL);
		
		driver.manage().window().maximize();
		wdu.waitForPageToLoad(driver, 10);
		
		HomePage hp=new HomePage(driver);
		hp.getLoginElement().click();
		
		LogInPage lp=new LogInPage(driver);
		lp.setlogin(USERNAME, PASSWORD);
		
		hp.getAuthRestaurant().click();
		
		RestaurantPage rp=new RestaurantPage(driver);
		rp.getRestaurantname().click();
		
		DishesPage dp=new DishesPage(driver);
		dp.getAddToCartbtn().click();
		dp.getCheckoutbtn().click();
		
		CheckOutPage cp=new CheckOutPage(driver);
		cp.getOrderNowBtn().click();
		
		driver.switchTo().alert().accept();
		
		driver.switchTo().alert().accept();
		
		hp.getLogoutElement().click();
		
		System.out.println("I have placed an order");
		
		Thread.sleep(3000);
		
		//admin login credentials
		String url = fiu.readDataFromPropertyFile("admin_url");
		String username1 = fiu.readDataFromPropertyFile("username");
		String password1 = fiu.readDataFromPropertyFile("password");
		
		driver.navigate().to(url);
		
		AdminLoginPage ap=new AdminLoginPage(driver);
		ap.setLogIn(username1, password1);
		
		AdminPanelPage app=new AdminPanelPage(driver);
		app.getOrdersElement().click();
		
		AllOrders ao=new AllOrders(driver);
		String user = ao.getUsername().getText();
		
		if(USERNAME.equals(user)) {
			System.out.println("Your Order is placed Successfully Integration testing is passed");
		}
		else {
			System.out.println("Your Order is not placed and Integration testing is failed");
		}
		driver.close();
		
		
	}

}
