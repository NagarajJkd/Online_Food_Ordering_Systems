package TestNG_Practice;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class SampleTest {
	
	@Test
	public void create() {
		Reporter.log("Created", true);
	}
	
	
	@Test(priority = -1, dependsOnMethods = "update")
	public void delete() {
		Reporter.log("Delete",true);
	}
	
	@Test
	public void update() {
		Reporter.log("Update",true);
	}

}
