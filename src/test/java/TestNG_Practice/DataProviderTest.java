package TestNG_Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.OFOS.generic.ExcellUtility;

public class DataProviderTest {
	
	@Test(dataProvider = "getdata")
	public void traveller(String src, String dest, String price) throws Throwable
	{
		System.out.println(src+"------>"+dest+"------>"+price);
		ExcellUtility exu=new ExcellUtility();
		int v = exu.getLastRowNumberFromExcell("DataProvider");
		System.out.println(v);
		
	}
	
	@DataProvider
	public Object[][] getdata() throws Throwable
	{
		ExcellUtility exu=new ExcellUtility();
		Object[][] value = exu.readMultipleSetOfDataFromExcell("DataProvider");
		return value;
	}

}
