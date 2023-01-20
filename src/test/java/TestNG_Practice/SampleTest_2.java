package TestNG_Practice;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.OFOS.generic.BaseClass;

public class SampleTest_2 extends BaseClass{
	@Test(groups = {"smoke", "regrassion"})
	public void test3() {
		Reporter.log("Test3", true);
	}

	@Test(groups = "regrassion")
	public void test4() {
		Reporter.log("Test4", true);
	}

}
