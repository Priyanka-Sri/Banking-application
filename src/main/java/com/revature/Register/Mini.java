package com.revature.Register;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class Mini {
	
	
	public static void main(String args[]) throws SQLException, ClassNotFoundException {
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
	    	  System.out.println("Deposit info");
			    
	    	  System.out.print("accno     ");
				
				System.out.print("damt    ");
				
				
				
				System.out.println("bal   ");
			
			
	    
			
		if(AccountNumber!=null && AccountNumber.equals(accno))
		{
			
			String sql1="select accno,damt,bal from Deposit where   accno='"+accno+"'";
			PreparedStatement pst1 = con.prepareStatement(sql1);
		    ResultSet rs1 = pst1.executeQuery();
		    while(rs1.next())
		    {
		    	
				
					Integer accno1=rs1.getInt("accno");
					
					Double damt=rs1.getDouble("damt");
					
					Double bal=rs1.getDouble("bal");
					
		    	
					
	System.out.println(accno1+"       "+damt+"       "+bal);
							
		    }
	
		    System.out.println("Withdraw info");
		    
			String sql2="select accno,amt,bal from Withdraw where   accno='"+accno+"'";
			PreparedStatement pst2 = con.prepareStatement(sql2);
		    ResultSet rs2 = pst2.executeQuery();
		    System.out.print("accno     ");
			
			System.out.print("wamt    ");
			
			
			
			System.out.println("   bal   ");
			
		    while(rs2.next())
		    {
               
				
					Integer accno2=rs2.getInt("accno");
					Double wamt=rs2.getDouble("amt");
					//Double amt=rs1.getDouble("amt");
					Double bal1=rs2.getDouble("bal");
					//String bal1=rs1.getString("bal");
					
					
	System.out.println(accno2+"       "+wamt+"       "+bal1);
		    }			
System.out.println("Fundtransfer info");
		    
			String sql3="select * from Fund  where   Fromacc='"+accno+"'";
			PreparedStatement pst3 = con.prepareStatement(sql3);
		    ResultSet rs3 = pst3.executeQuery();
		    System.out.print("Fromacc     ");
			
			System.out.print("Toacc    ");
			System.out.print("Tamt     ");
			
			System.out.println("   bal   ");
			
		    while(rs3.next())
		    {
               
				
					Integer Fromacc=rs3.getInt("Fromacc");
					Integer Toacc=rs3.getInt("Toacc");
					Double Tamt=rs3.getDouble("Tamt");
					//Double amt=rs1.getDouble("amt");
					Double bal1=rs3.getDouble("bal");
					//String bal1=rs1.getString("bal");
					
					
	System.out.println(Fromacc+"   "+Toacc+"      "+Tamt+"       "+bal1);
		    }					
		
		
	
}
	}
	}
	
	
	
	
	
	
	
	
	

}
