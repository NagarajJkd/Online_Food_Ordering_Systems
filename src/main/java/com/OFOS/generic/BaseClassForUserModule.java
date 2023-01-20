package com.OFOS.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.OFOS.pom.AdminLoginPage;
import com.OFOS.pom.AdminPanelPage;

public class BaseClassForUserModule {

public WebDriver driver;
	
	public DataBaseUtility dbu=new DataBaseUtility();
	public ExcellUtility exu=new ExcellUtility();
	public FileUtility fiu=new FileUtility();
	public WebDriverUtility wdu=new WebDriverUtility();
	public JavaUtility ju=new JavaUtility();
	
	@BeforeSuite
	public void connectToDB() throws Throwable {
		Reporter.log("Connect to Database", true);
		dbu.connectToDB();
	}
	
	@BeforeClass
	public void openTheBrowser() throws Throwable
	{
		Reporter.log("Open the browser", true);
		String BROWSER = fiu.readDataFromPropertyFile("browser");
		String URL = fiu.readDataFromPropertyFile("admin_url");
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		else {
			Reporter.log("Invalid Browser", true);
		}
		
		driver.manage().window().maximize();
		wdu.waitForPageToLoad(driver, 10);
		driver.get(URL);
	}
	
	@BeforeMethod
	public void logIn() throws Throwable {
		Reporter.log("LogIn to the Application", true);
//		String USERNAME = fiu.readDataFromPropertyFile("username");
//		String PASSWORD = fiu.readDataFromPropertyFile("password");
//		AdminLoginPage ap=new AdminLoginPage(driver);
//		ap.setLogIn(USERNAME, PASSWORD);
	}
	
	@AfterMethod
	public void logOut() {
		Reporter.log("Logout from the Application", true);
		AdminPanelPage app=new AdminPanelPage(driver);
		app.setlogout();
	}
	
	@AfterClass
	public void closeBrowser() {
		Reporter.log("Close the browser", true);
		driver.quit();
	}
	
	
	@AfterSuite
	public void closeDatabase() throws Throwable {
		Reporter.log("Closed the DataBase", true);
		dbu.closeConnectOfDB();
	}

}
