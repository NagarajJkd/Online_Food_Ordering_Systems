package com.OFOS.testscript;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.OFOS.generic.BaseClass;
import com.OFOS.generic.FileUtility;
import com.OFOS.generic.WebDriverUtility;
import com.OFOS.pom.CheckOutPage;
import com.OFOS.pom.DishesPage;
import com.OFOS.pom.HomePage;
import com.OFOS.pom.LogInPage;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.OFOS.generic.BaseClass;
import com.OFOS.generic.ExcellUtility;
import com.OFOS.generic.FileUtility;
import com.OFOS.generic.JavaUtility;
import com.OFOS.generic.WebDriverUtility;
import com.OFOS.pom.AddMenuPage;
import com.OFOS.pom.AdminLoginPage;
import com.OFOS.pom.AdminPanelPage;
import com.OFOS.pom.AllMenuPage;
@Listeners(com.OFOS.generic.ListnerImplimentation.class)
public class OrderNowByUsingTestNG extends BaseClass{
	
	@Test(groups = "regrassion")
	public void orderNow() {
		
		HomePage hp=new HomePage(driver);
		
		LogInPage lp=new LogInPage(driver);
		
		hp.getOrderNow().click();
		
		DishesPage dp=new DishesPage(driver);
		dp.getAddtocardElement().click();
		dp.getCheckoutbtn().click();
		
		CheckOutPage cp=new CheckOutPage(driver);
		cp.getOrderNowBtn().click();
		
		String orderconfirm = driver.switchTo().alert().getText();
		
		String alertText = "Do you want to confirm the order?";
		
		SoftAssert s=new SoftAssert();
		s.assertEquals(orderconfirm, alertText);
		
		driver.switchTo().alert().accept();
		
		String greeting = driver.switchTo().alert().getText();
		String alertText2 = "Thank you. Your Order has been placed!";
		
		s.assertEquals(greeting, alertText2);
		
		driver.switchTo().alert().accept();
		
		String title = driver.getTitle();
		
		s.assertEquals(title, "My Orders");
		
		Reporter.log("My orders page is displayed and System testing is passed");
		
		s.assertAll();
	}
	
	
	
	
	
}