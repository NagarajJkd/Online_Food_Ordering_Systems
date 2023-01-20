package com.OFOS.testscript;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
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
public class AddMenuTest extends BaseClass{

	@Test(dataProvider = "getdata", retryAnalyzer = com.OFOS.generic.RetryImplimentation.class)
	public void addMenu(String DishName, String Description, String Price, String Path, String Value) throws Throwable {
		
		AdminPanelPage aP=new AdminPanelPage(driver);
		aP.getMenu().click();
		aP.getAddMenu().click();
		
		AddMenuPage am=new AddMenuPage(driver);
		Assert.fail();
		am.getFile().sendKeys(Path);
		wdu.selectt(am.getSelectrest(),Value);
		
		am.setvalues(DishName, Description, Price);
		am.getSavebtn().click();
		
		 
		SoftAssert s=new SoftAssert();
		
		aP.getAllMenu().click();
			AllMenuPage alm=new AllMenuPage(driver);
			String dishname = alm.getDish().getText();
			
		s.assertEquals(dishname, DishName);
		Reporter.log("Menu is added Successfullychrome", true);
		s.assertAll();
		
	}
	
	@DataProvider
	public Object[][] getdata() throws Throwable {
		Object[][] value = exu.readMultipleSetOfDataFromExcell("addMenu01");
		return value;
	}
	
}
