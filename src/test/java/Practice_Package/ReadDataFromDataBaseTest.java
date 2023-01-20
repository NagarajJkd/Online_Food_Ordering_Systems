package Practice_Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;


public class ReadDataFromDataBaseTest {

	public static void main(String[] args) throws SQLException {
		
		Connection con=null;
		try {
			
			Driver driver=new Driver();
			
			//Step1 : Register the data base
			DriverManager.registerDriver(driver);
			
			//Step2 : Get connection to the database
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet45", "root", "root");
			
			//Step 3 : Issue create statement
			Statement state = con.createStatement();
			String query = "select * from studentInfo;";
			
			//step 4 : Execute Query
			ResultSet result = state.executeQuery(query);
			
			while(result.next()) {
				System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(4));
			}
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		finally {
			// Step 5: close the database
			
			con.close();
			
			System.out.println("Closed the database connection succesfully");
			
		}


		
	}

}
