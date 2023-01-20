package Practice_Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class AddProjectToTYProjectManagement {

	public static void main(String[] args) throws SQLException {

		Connection con=null;
		int result=0;
		try {
		Driver driver= new Driver();
		DriverManager.registerDriver(driver);//register database
		con=DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");//get connection
		Statement state = con.createStatement();//issue create statement
		String query = "insert into project values('OFOS_01', 'Nagaraj', '21/12/2021', 'OnlineFoodOrderingSystem', 'created', 3);";
		result=state.executeUpdate(query);//update query
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (result==1) {
				System.out.println("Updated successfully");
			}
			else {
				System.out.println("Not updated");
			}
		}
		
	}

	
}
