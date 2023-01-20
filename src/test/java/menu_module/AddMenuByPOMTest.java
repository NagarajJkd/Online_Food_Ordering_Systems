package menu_module;

import java.io.File;
import java.util.ArrayList;

import org.bouncycastle.crypto.ec.ECNewPublicKeyTransform;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.OFOS.generic.ExcellUtility;
import com.OFOS.generic.FileUtility;
import com.OFOS.generic.JavaUtility;
import com.OFOS.generic.WebDriverUtility;
import com.OFOS.pom.AddMenuPage;
import com.OFOS.pom.AdminLoginPage;
import com.OFOS.pom.AdminPanelPage;
import com.OFOS.pom.AllMenuPage;

import net.bytebuddy.implementation.bind.annotation.Super;


public class AddMenuByPOMTest {
	
public static void main(String[] args) throws Throwable {
	WebDriver driver = new ChromeDriver();
	FileUtility fu=new FileUtility();
	WebDriverUtility wdU=new WebDriverUtility();
	ExcellUtility exu=new ExcellUtility();
	JavaUtility ju=new JavaUtility();
	
	driver.manage().window().maximize();
	
	wdU.waitForPageToLoad(driver, 10);
	
	String url = fu.readDataFromPropertyFile("admin_url");
	String username = fu.readDataFromPropertyFile("username");
	String password = fu.readDataFromPropertyFile("password");
	
	driver.get(url);
	AdminLoginPage al=new AdminLoginPage(driver);
	al.getAdusername().sendKeys(username);
	al.getAdpassword().sendKeys(password);
	al.getAdloginBtn().click();
	
	AdminPanelPage aP=new AdminPanelPage(driver);
	aP.getMenu().click();
	aP.getAddMenu().click();
	
	int ran = ju.randomNumber(50);
	
	AddMenuPage am=new AddMenuPage(driver);

	String dname = exu.readDataFromExcell("addMenu", 0, 1)+ran;
	String description = exu.readDataFromExcell("addMenu", 1, 1);
	String price = exu.readDataFromExcell("addMenu", 2, 1);
	String path = exu.readDataFromExcell("addMenu", 3, 1);
	File f=new File(path);
	String Absolute = f.getAbsolutePath();
	am.getFile().sendKeys(Absolute);
	String value = exu.readDataFromExcell("addMenu", 4, 1);
	wdU.selectt(am.getSelectrest(),value);
	
	am.setvalues(dname, description, price);
	am.getSavebtn().click();
	
	 String msg = am.getSuccessmsg().getText();
	 String actmsg="New Dish Added Successfully.";
	
	if (msg.contains(actmsg)) {
		
		aP.getAllMenu().click();
		AllMenuPage alm=new AllMenuPage(driver);
		String dishname = alm.getDish().getText();
		
		if (dishname.equals(dname)) {
			System.out.println("Menu is added Successfully");
		}
		
	}
	else {
		System.out.println("Menu is not added");
	}
	
	driver.close();
	
}
}
