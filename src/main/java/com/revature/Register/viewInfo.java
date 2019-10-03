package com.revature.Register;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class viewInfo {

	
	public static void function() throws SQLException, ClassNotFoundException {
		Connection con = ConnectionUtil.getConnection();
	
	
		Scanner sc =new Scanner(System.in);
	
	
	
	
		System.out.println("enter acc no");
	    int accno =sc.nextInt();
	    
	                  
	    String sql="select AccountNumber from register where AccountNumber='"+accno+"'" ;
	    PreparedStatement pst = con.prepareStatement(sql);
	    ResultSet rs = pst.executeQuery();
		
	    Integer AccountNumber = null;
	   
			while(rs.next())
			{
	    	  AccountNumber= rs.getInt("AccountNumber");
	        
			
			
	    
			
		if(AccountNumber!=null && AccountNumber.equals(accno))
		{
			String sql1="select AccountNumber,UserName,Bal from register where AccountNumber='"+accno+"'";
			PreparedStatement pst1 = con.prepareStatement(sql1);
		    ResultSet rs1 = pst1.executeQuery();
		    while(rs1.next())
		    {
		    	System.out.print("AccountNumber     ");
				
				System.out.print("Username        ");
				
				System.out.println("Your balance   ");
				
					Integer AccountNumber1=rs1.getInt("AccountNumber");
					String UserName=rs1.getString("UserName");
					Double Bal=rs1.getDouble("bal");
					
					
					
					
					System.out.println(AccountNumber1+"                "+UserName+"              "+Bal+"       ");
							
		}
	
	
	
}
	}
	}
}


