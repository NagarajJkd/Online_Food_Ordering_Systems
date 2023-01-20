package TestNG_Practice;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.OFOS.generic.BaseClass;

public class SampleTest_3 extends BaseClass{
	
	@Test(groups = "smoke")
	public void test5() {
		Reporter.log("Test5", true);
	}

	@Test(groups = {"smoke", "regrassion"})
	public void test6() {
		Reporter.log("Test6", true);
	}

}
