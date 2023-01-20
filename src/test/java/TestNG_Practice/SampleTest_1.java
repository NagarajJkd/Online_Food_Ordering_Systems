package TestNG_Practice;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.OFOS.generic.BaseClass;

public class SampleTest_1 extends BaseClass{
	@Test(groups = "smoke")
	public void test1() {
		Reporter.log("Test1", true);
	}

	@Test(groups = "regrassion")
	public void test2() {
		Reporter.log("Test2", true);
	}
}
