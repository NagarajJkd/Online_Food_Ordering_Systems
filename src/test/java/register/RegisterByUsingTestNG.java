package register;

import org.apache.commons.codec.language.bm.Rule.RPattern;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.OFOS.generic.BaseClass;
import com.OFOS.generic.ExcellUtility;
import com.OFOS.generic.FileUtility;
import com.OFOS.pom.HomePage;
import com.OFOS.pom.RegisterPage;

public class RegisterByUsingTestNG extends BaseClass{

	@Test
	public void registerTest(String username1, String firstname1, String lastname1, String email1, String phonenumber1, String password1, String conpassword1, String description1) throws Throwable {

//		WebDriver driver=new ChromeDriver();
//		FileUtility fiu=new FileUtility();
//		ExcellUtility exu=new ExcellUtility();
//		
//		String url = fiu.readDataFromPropertyFile("user_url");
//		driver.get(url);
//		driver.manage().window().maximize();
//		
//		String username1 = exu.readDataFromExcell("registration", 0, 1);
//		String firstname1 = exu.readDataFromExcell("registration", 1, 1);

		HomePage hp=new HomePage(driver);
		hp.getRegisterElement().click();
		
//		HomePage hp=new HomePage(driver);
//		hp.getRegisterElement().click();
	
		RegisterPage rp=new RegisterPage(driver);
		rp.setCredentials(username1, firstname1, lastname1, email1, phonenumber1, password1, conpassword1, description1);
	}
	
	@DataProvider
	public Object[][] getdata() throws Throwable {
		Object[][] values = exu.readMultipleSetOfDataFromExcell("registter01");
		return values;
	}

	
}
