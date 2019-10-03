package com.revature.Register;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.revature.util.ConnectionUtil;
public class Statement {
	
	
	public static void function() throws SQLException, ClassNotFoundException {
		Connection con = ConnectionUtil.getConnection();
	
	
		Scanner sc =new Scanner(System.in);
	
	
	
	
		System.out.println("Enter Account Number");
	    int accno =sc.nextInt();
	    
	                  
	    String sql="select AccountNumber from Customer_Details where AccountNumber='"+accno+"'" ;
	    
	    
	    PreparedStatement pst = con.prepareStatement(sql);
	    ResultSet rs = pst.executeQuery();
		
	    Integer AccountNumber = null;
	   
			while(rs.next())
			{
	    	  AccountNumber= rs.getInt("AccountNumber");
	    	
		if(AccountNumber!=null && AccountNumber.equals(accno))
		{
			System.out.println(" ");
		    System.out.println("               **** DEPOSIT DETAILS *****");
		    System.out.println(" ");
		    
		    System.out.print("ACC/NO    ");
		    
			System.out.print("   DATE        TIME    ");
			System.out.print("   FUNTION   ");
			
			System.out.print("  DEPOSIT_AMOUNT   ");
		
			System.out.println("  CURRENT_BALANCE   ");
			
			
			String sql1="select AccNo,Date,Functions,Deposit,Balance from Transaction_Details where AccNo='"+accno+"'&& Functions='CR'";
			PreparedStatement pst1 = con.prepareStatement(sql1);
		    ResultSet rs1 = pst1.executeQuery();
		    while(rs1.next())
		    {
		    	
				
					Integer accno1=rs1.getInt("AccNo");
					
					String date=rs1.getString("Date");
					String Action=rs1.getString("Functions");
					Double dep=rs1.getDouble("Deposit");
					
					Double bal=rs1.getDouble("Balance");
					
		    	
					
	System.out.println(accno1+"  "+date+"      "+Action+"          "+dep+"              "+bal);
							
		    }
		    System.out.println(" ");
		    System.out.println("                 **** WITHDRAW DETAILS *****");
		    System.out.println(" ");
		    
		    System.out.print("ACC/NO    ");
		   
			System.out.print("  DATE        TIME    ");
			System.out.print("   FUNTION   ");
			
			
			System.out.print("  WITHDRAW AMOUNT   ");
			
			System.out.println("  CURRENT_BALANCE   ");
			
			
			String sql2="select AccNo,Date,Functions,WithDraw,Balance from Transaction_Details where AccNo='"+accno+"'&& Functions='DR'";
			PreparedStatement pst2 = con.prepareStatement(sql2);
		    ResultSet rs2 = pst2.executeQuery();
		    while(rs2.next())
		    {
		    	
				
					Integer accno1=rs2.getInt("AccNo");
					
					String date=rs2.getString("Date");
					String Action=rs2.getString("Functions");
					
					Double with=rs2.getDouble("WithDraw");
					
					Double bal=rs2.getDouble("Balance");
		    	
	System.out.println(accno1+"   "+date+"      "+Action+"            "+with+"         "+bal);
	
							
		    }
		    
		    System.out.println(" ");
		    System.out.println("                 **** FUNDTRANSFER DETAILS *****");
		    System.out.println(" ");
		    
		    System.out.print("ACC/NO    ");
		    System.out.print("  To/Ac    ");
			System.out.print("DATE        TIME    ");
			System.out.print("  FUNTION   ");
			
			
			System.out.print("IFSC   ");
			System.out.print("TRANSFER AMOUNT   ");
			System.out.println("CURRENT_BALANCE   ");
			
			
			String sql3="select AccNo,ToAcc,Date,Functions,IFSC,FundTransfer,Balance from Transaction_Details where AccNo='"+accno+"'&& Functions='FT'";
			PreparedStatement pst3 = con.prepareStatement(sql3);
		    ResultSet rs3 = pst3.executeQuery();
		    while(rs3.next())
		    {
		    	
				
					Integer accno1=rs3.getInt("AccNo");
					Integer accno2=rs3.getInt("ToAcc");
					String date=rs3.getString("Date");
					String Action=rs3.getString("Functions");
					
					String code=rs3.getString("IFSC");
					
					Double fund=rs3.getDouble("FundTransfer");
					Double bal=rs3.getDouble("Balance");
		    	
	System.out.println(accno1+"   "+accno2+" "+date+"      "+Action+"      "+code+"       "+fund+"         "+bal);
	
							
		    }					
		
		
	
}
	}
	}
}
	
	
	
	
	
	
	
	


