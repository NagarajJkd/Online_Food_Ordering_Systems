package TestNG_Practice;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PracticeAnnotations {
	@BeforeSuite
	public void configBDB() {
		Reporter.log("Connect to DB",true);
	}
	
	@BeforeTest
	public void executesc() {
		Reporter.log("test is running", true);
	}

	@BeforeClass
	public void configBC() {
		Reporter.log("Open the browser", true);
	}
	@BeforeMethod
	public void configBT() {
		Reporter.log("Login To The Application", true);
	}
	@Test(priority = 1)
	public void createAccount() {
		Reporter.log("Create A account for login", true);
	}
	@AfterMethod
	public void configAM() {
		Reporter.log("Log Out From Application", true);
	}
	@AfterClass
	public void configAC() {
		Reporter.log("Close the browser", true);
	}
	
	@AfterTest
	public void executed() {
		Reporter.log("test is running successfully", true);
	}
	
	@AfterSuite
	public void configADB() {
		Reporter.log("Disconnect The DB", true);
	}
	
	@Test(priority = 2)
	public void search() {
		Reporter.log("search a food", true);
	}

	@Test(priority = 3)
	public void order() {
		Reporter.log("order a food", true);
	}
	
	@Test(priority = 4)
	public void payForOreder() {
		Reporter.log("Order is recieved and paying", true);
	}

}
