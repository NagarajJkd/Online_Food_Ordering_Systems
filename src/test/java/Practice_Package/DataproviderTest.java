package Practice_Package;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataproviderTest {
	
	@Test(dataProvider = "getdata")
	public void test(Object obj) {
		System.out.println(obj);
	}
	
	@DataProvider
	public Object[][] getdata() {
		Object[][] obj= {{1}, {2}};
		return obj;	
	}

}
