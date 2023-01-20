package Practice_Package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadDataFromPropertyFileTest {

	public static void main(String[] args) throws Throwable {
		
		// Object representation for external file
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\data\\commondata.properties");
		
		// Open the file in read mode
		Properties properties=new Properties();
		
		// load the file
		properties.load(fis);
		
		// Read the data from external file
		String url = properties.getProperty("admin_url");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");
		
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);
	
	
	
	}

}
