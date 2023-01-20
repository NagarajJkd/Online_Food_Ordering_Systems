package TestNG_Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PracticeDataProvider {
	
	@Test(dataProvider="data")
	public void travel(String scr, String dest, int price) {
		System.out.println("from "+scr+" ---------> "+"to "+dest+"------>"+price);
		System.out.println();
	}
	
	
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
