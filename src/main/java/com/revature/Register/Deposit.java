package com.revature.Register;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.revature.util.ConnectionUtil;

import java.util.Date;
import java.text.SimpleDateFormat;
public class Deposit {

	
	  public static void function() throws SQLException, ClassNotFoundException 
      {
   	   
	
   		
        
        
 	    Connection con = ConnectionUtil.getConnection();
 	   
 	    Scanner scn =new Scanner(System.in);
 		
 	    System.out.println("Enter Account Number");
 	    int accno =scn.nextInt();
 	    
 	    //retrieve the balance from customer details
 	    String sql="select bal from Customer_Details where AccountNumber='"+accno+"'";
 	   
 	    PreparedStatement pst = con.prepareStatement(sql);
 	    ResultSet rs = pst.executeQuery();
 	    
 	    Double bal = null;
 	    while(rs.next())
 		
 		 bal = rs.getDouble("bal");
 	  Double bal1 =bal;
 		
 		
 		
       //verifying the account number
 	    String sql3="select AccountNumber from Customer_Details where AccountNumber='"+accno+"'" ;
 	    PreparedStatement pst3 = con.prepareStatement(sql3);
 	    ResultSet rs3 = pst3.executeQuery();
 		
 	    Integer AccountNumber = null;
 	   
 			while(rs3.next())
 			{
 	    	  AccountNumber= rs3.getInt("AccountNumber");
 	        
 			
 			
 	    
 			}
 			
 			
 		if(AccountNumber!=null && AccountNumber.equals(accno))
 		{
 			{
 				
 				System.out.print("Enter amount to deposit:");
 				Double deposit;
 				
 				
 		 		deposit =scn.nextDouble();
 				
 				if (deposit < 0) {
 				System.out.println("Invalid Amount");
 				
 				}
 			
 				bal = bal1 + deposit;
 				
 				String sql2 = "update  Customer_Details set bal=? where AccountNumber='"+accno+"'";
		        PreparedStatement pst2 = con.prepareStatement(sql2);
		        
		        pst2.setDouble(1,bal);
		        int row = pst2.executeUpdate();
		       
		        
		        int Toac=0;
 				Double DR=0.0;
 				Double Fund=0.0;
				String Action="CR";
				String code="----";
				
				//Date and Time
				SimpleDateFormat stm=new SimpleDateFormat("dd/MM/yyyy  HH:mm:ss");
		        Date date=new Date();
		       String DT= (stm.format(date));
		        
 			  
				
				
				String sql1 = "insert into Transaction_Details(AccNo,ToAcc,Date,Functions,Deposit,WithDraw,IFSC,FundTransfer,Balance) values (?,?,?,?,?,?,?,?,?)";
		        PreparedStatement pst1 = con.prepareStatement(sql1);
		       
		        
		        pst1.setInt(1,accno);
		        pst1.setInt(2,Toac);
		        pst1.setString(3, DT);
		        pst1.setString(4,Action);
		        pst1.setDouble(5, deposit);
		        pst1.setDouble(6, DR);
		        pst1.setString(7,code);
		        pst1.setDouble(8, Fund);
		        pst1.setDouble(9, bal);
		        
		        
		        System.out.println("deposit successfully");
		        System.out.println("balance    "+bal);
		        int rows = pst1.executeUpdate();
                System.out.println("Number Of Rows Inserted    "+rows);
 				
 			
 			}
	
	
	
	
	
	
	
	
 		}
   	   }
   	   
	
	
}
