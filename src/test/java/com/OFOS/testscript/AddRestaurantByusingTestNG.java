package com.OFOS.testscript;

import java.io.File;
import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.OFOS.generic.BaseClass;
import com.OFOS.generic.ExcellUtility;
import com.OFOS.generic.FileUtility;
import com.OFOS.generic.JavaUtility;
import com.OFOS.generic.WebDriverUtility;
import com.OFOS.pom.AddRestaurantPage;
import com.OFOS.pom.AdminPanelPage;


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
//@Listeners(com.OFOS.generic.ListnerImplimentation.class)
public class AddRestaurantByusingTestNG extends BaseClass{
	
	@Test(retryAnalyzer = com.OFOS.generic.RetryImplimentation.class)
	public void AddResturantTest() throws Throwable {
		
		
		AdminPanelPage ap=new AdminPanelPage(driver);
		ap.getRestaurantbtn().click();
		ap.getAddRestaurantbtn().click();
		AddRestaurantPage arp=new AddRestaurantPage(driver);
		arp.credentials("New Tea", "newtea@gmail.com", "9979652314", "www.newtea.com");
		
		wdu.selectt(arp.getOpenHours(), "9am");
		wdu.selectt(arp.getCloseHours(), "9pm");
		wdu.selectt(arp.getOpendays(), "Mon-Fri");
		wdu.selectt(arp.getCategoryName(), "Indian");
		
		File f=new File("./src/test/resources/data/User Login.png");
		String absolute = f.getAbsolutePath();
		driver.findElement(By.id("lastName")).sendKeys(absolute);
		
		arp.getAddress().sendKeys("Udupi Garden");
		arp.getSavebtn().click();
		
		
		wdu.waitForPageToLoadForJSElement(driver, 10);
		Thread.sleep(3000);
		ap.allrest();
		String expectedrestaurant = driver.findElement(By.xpath("//td[text()='"+"New Tea"+"']")).getText();
		
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(expectedrestaurant, "New Tea");
		System.out.println("Restaurant added successfully");	

	}

}
