package com.revature.Register;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionUtil {
	public static void main(String[] args) {
		getConnection();
	}
	public static Connection getConnection() {
	String driverClassName = "com.mysql.jdbc.Driver";
			String url =  "jdbc:mysql://localhost:3306/BankingApp";
			String username = "root";
			String password  = "root";
			Connection con =null;
   try {
			Class.forName(driverClassName);
			con = DriverManager.getConnection(url,username,password);
			System.out.println(con);
       } 
   catch (ClassNotFoundException e)
   {
	   e.printStackTrace();
	   throw new RuntimeException("unable to load the drive class");
	   
   }
   catch (SQLException e)
   {
	   e.printStackTrace();
			   throw new RuntimeException("unable to get DB Connection");
   }
   
			return con;

}
}
