package com.OFOS.generic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {

	Connection con=null;
	
	public void connectToDB() throws Throwable {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		con = DriverManager.getConnection(IPathConstantUtility.DBURL, IPathConstantUtility.DBUSERNAME, IPathConstantUtility.DBPASSWORD);
	}
	
	public String executeQueryAndGetbackData(String query, int columindex, String expdata) throws Throwable {
		ResultSet result = con.createStatement().executeQuery(query);
		boolean flag = false;
		while (result.next()) {
			String data = result.getString(columindex);
			if (data.equals(expdata)) {
				flag=true;
				break;
		}
		}
		if (flag) {
			System.out.println(expdata+"project is created successfully");
			return expdata;
		}
		else {
			System.out.println("project is not created");
			return "";
		}
	}
	
	public void updateQueryAndGetBackData(String query) throws Throwable {
		int result = con.createStatement().executeUpdate(query);
		if (result==1) {
			System.out.println("Data is inserted sucessfully");
		}
		else {
			System.out.println("Data is not inserted sucessfully");
		}
	}
	
	public void closeConnectOfDB() throws Throwable {
		con.close();
		System.out.println("Connection is closed successfully");
	}
}
