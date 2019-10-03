package com.revature.Register;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.revature.util.ConnectionUtil;

import java.util.Date;
import java.text.SimpleDateFormat;
public class Withdraw {
	
	
	
	 public static void function() throws SQLException, ClassNotFoundException 
     {
  	   
     
	    Connection con = ConnectionUtil.getConnection();
	    Scanner scn =new Scanner(System.in);
		System.out.println("Enter Account Number: ");
	    int accno =scn.nextInt();
	    
	    String sql="select bal from Customer_Details where AccountNumber='"+accno+"'";
	    PreparedStatement pst = con.prepareStatement(sql);
	    ResultSet rs = pst.executeQuery();
	    Double bal = null;
	    while(rs.next())
		
		 bal = rs.getDouble("bal");
	  Double bal1 =bal;
		 
		
    
	    String sql1="select AccountNumber from Customer_Details where AccountNumber='"+accno+"'" ;
	    PreparedStatement pst1 = con.prepareStatement(sql1);
	    ResultSet rs1 = pst1.executeQuery();
		
	    Integer AccountNumber = null;
	   
			while(rs1.next())
			{
	    	  AccountNumber= rs1.getInt("AccountNumber");
	        
			
			
	    
			}
			
			
		if(AccountNumber!=null && AccountNumber.equals(accno))
		{System.out.println("Your Balance=" + bal);
		System.out.print("Enter Amount To WithDraw:");
		Double withdraw;
			
			
	 	     withdraw =scn.nextDouble();
		
		
		
		if (bal1 <  withdraw) {
		System.out.println("Insufficient Balance.");
		
		}
		if ( withdraw < 0) {
		System.out.println("Invalid Amount");
		
		}
		Double bal2= bal1 -  withdraw;
		
		
		String sql3 = "update  Customer_Details set Bal=? where AccountNumber='"+accno+"'";
        PreparedStatement pst3 = con.prepareStatement(sql3);
        
        pst3.setDouble(1,bal2);
        int row = pst3.executeUpdate();
        
		
		
      //Date and Time
		SimpleDateFormat stm=new SimpleDateFormat("dd/MM/yyyy  HH:mm:ss");
        Date date=new Date();
       String DT= (stm.format(date));
        
       
            int Toacc=0;
			Double CR=0.0;
			Double Fund=0.0;
		String code="----";
		String Action="DR";
		String sql2 = "insert into Transaction_Details(AccNo,ToAcc,Date,Functions,Deposit,WithDraw,IFSC,FundTransfer,Balance) values (?,?,?,?,?,?,?,?,?)";
        PreparedStatement pst2 = con.prepareStatement(sql2);
       
        
        pst2.setInt(1,accno);
        pst2.setInt(2,Toacc);
        pst2.setString(3, DT);
        pst2.setString(4,Action);
        pst2.setDouble(5, CR);
        pst2.setDouble(6,  withdraw);
        pst2.setString(7,code);
        pst2.setDouble(8, Fund);
        pst2.setDouble(9, bal2);
        
        System.out.println("WithDraw successfully");
        System.out.println("balance    "+bal2);
        int rows = pst2.executeUpdate();
        System.out.println("Number Of Rows Inserted    "+rows);
			
		}
     }
}

	


