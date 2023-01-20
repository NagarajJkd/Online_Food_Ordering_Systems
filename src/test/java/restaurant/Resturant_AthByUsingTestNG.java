package restaurant;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.OFOS.generic.BaseClass;
import com.OFOS.pom.DishesPage;
import com.OFOS.pom.HomePage;
import com.OFOS.pom.RestaurantPage;

public class Resturant_AthByUsingTestNG extends BaseClass{
	
	@Test
	public void resturantTest() {
		HomePage hp=new HomePage(driver);
		hp.getAuthRestaurant().click();
		
		RestaurantPage rp=new RestaurantPage(driver);
		rp.getRestaurantname().click();
		
		DishesPage dp=new DishesPage(driver);
		dp.getAddtocardElement().click();
		dp.getCheckoutbtn().click();
		
		String text = driver.getTitle();
		
		SoftAssert s=new SoftAssert();
		
		s.assertNotEquals(text, "Checkout");
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		String atitle = driver.switchTo().alert().getText();
		s.assertNotEquals(atitle, "Do you want to confirm the order?");
		driver.switchTo().alert().accept();
		String btitle = driver.switchTo().alert().getText();
		s.assertNotEquals(btitle, "Thank you. Your Order has been placed!");
		driver.switchTo().alert().accept();
		String title = driver.getTitle();
		Reporter.log(title+" Page is displayed and System testing is passed", true);
		
	}

}
