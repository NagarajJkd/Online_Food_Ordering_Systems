package TestNG_Practice;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.OFOS.generic.BaseClass;

public class SampleTest_4 extends BaseClass {
	
	@Test(groups = "regrassion")
	public void test7() {
		Reporter.log("Test7", true);
	}

	@Test
	public void test8() {
		Reporter.log("Test8", true);
	}

}
