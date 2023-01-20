package TestNG_Practice;

import org.testng.annotations.DataProvider;

public class SetOfData {

	@DataProvider
	public Object[][] data() {
		Object[][] obj=new Object[2][3];
		obj[0][0]="Bengaluru";
		obj[0][1]="Jamakhandi";
		obj[0][2]=650;
		
		obj[1][0]="Jamakhandi";
		obj[1][1]="Bengaluru";
		obj[1][2]=1500;
		
		return obj;
	}
	
}
