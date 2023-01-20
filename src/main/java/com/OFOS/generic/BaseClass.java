package com.OFOS.generic;

import org.bouncycastle.crypto.ec.ECNewPublicKeyTransform;
import org.openqa.selenium.ElementNotSelectableException;
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
import org.testng.annotations.Ignore;
import org.testng.annotations.Parameters;

import com.OFOS.pom.AdminLoginPage;
import com.OFOS.pom.AdminPanelPage;
import com.OFOS.pom.HomePage;
import com.OFOS.pom.LogInPage;
import com.beust.jcommander.Parameter;

public class BaseClass {
	
	public static WebDriver driver;
	public static WebDriver edriver;
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
	//@Parameters("login")
	@BeforeClass
	public void openTheBrowser() throws Throwable
	{
		Reporter.log("Open the browser", true);
		String BROWSER = fiu.readDataFromPropertyFile("browser");
		String URL = fiu.readDataFromPropertyFile("admin_url");
		String url = fiu.readDataFromPropertyFile("user_url");
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		else {
			Reporter.log("Invalid Browser", true);
		}
//		edriver=driver;
		driver.manage().window().maximize();
		wdu.waitForPageToLoad(driver, 10);
		String login = fiu.readDataFromPropertyFile("loginas");
		if (login.equals("admin")) {
			driver.get(URL);
		}
		else {
			driver.get(url);
		}
		
	}
	
	//@Parameters("login")
	@BeforeMethod
	public void logIn() throws Throwable {
		Reporter.log("LogIn to the Application", true);
		String login = fiu.readDataFromPropertyFile("loginas");
		
		if(login.equals("admin")) {
		String USERNAME = fiu.readDataFromPropertyFile("username");
		String PASSWORD = fiu.readDataFromPropertyFile("password");
		AdminLoginPage ap=new AdminLoginPage(driver);
		ap.setLogIn(USERNAME, PASSWORD);
		}
		else {
			String USERNAME = fiu.readDataFromPropertyFile("user");
			String PASSWORD = fiu.readDataFromPropertyFile("pwd");
			
			wdu.waitForPageToLoad(driver, 10);
			
			HomePage hp=new HomePage(driver);
			hp.getLoginElement().click();
			
			LogInPage lp=new LogInPage(driver);
			lp.setlogin(USERNAME, PASSWORD);
		}
	}
	
	@AfterMethod
	public void logOut() throws Throwable {
		Reporter.log("Logout from the Application", true);
		
		String option = fiu.readDataFromPropertyFile("loginas");
		if (option.equals("admin")) {
			AdminPanelPage app=new AdminPanelPage(driver);
			app.setlogout();
		}
		else {
			HomePage hp=new HomePage(driver);
			hp.getLogoutElement().click();
		}
		
		
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
