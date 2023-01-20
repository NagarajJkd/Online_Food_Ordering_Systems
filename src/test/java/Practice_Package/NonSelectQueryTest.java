package Practice_Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class NonSelectQueryTest {

	public static void main(String[] args) throws SQLException {

		Connection con=null;
		int result=0;
		try {
			Driver driver=new Driver();
			
			// step 1 : Register the database
			DriverManager.registerDriver(driver);
			
			//Step 2 Get connection from data base
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet45", "root", "root");	
			
			// Step 3 : Issue create statement
			Statement state = con.createStatement();
			String query = "insert into studentInfo values('Sudip', 'BTM', 'JavaSelenium', 3);";
			
			// Step 4 : Update Query
			result = state.executeUpdate(query);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		finally {
			if (result==1) {
				
				System.out.println("Data is inserted sucessfully");
			}
			else {
				System.out.println("Data is not inserted sucessfully");
			}
			
			con.close();
		}
	}

}
