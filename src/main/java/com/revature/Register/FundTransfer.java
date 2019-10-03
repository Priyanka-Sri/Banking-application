package com.revature.Register;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.revature.util.ConnectionUtil;

import java.util.Date;
import java.text.SimpleDateFormat;
public class FundTransfer 
{
       public static void function() throws SQLException, ClassNotFoundException 
       {
    	   {
       
	    Connection con = ConnectionUtil.getConnection();
	    Scanner scn =new Scanner(System.in);
		
	    System.out.println("Enter Account Number: ");
	    int accno =scn.nextInt();
	    
	    
	    	//retrieve the bal from customer details  
	    String sql="select bal from Customer_Details where AccountNumber='"+accno+"'";
	    
	    
	    PreparedStatement pst = con.prepareStatement(sql);
	    ResultSet rs = pst.executeQuery();
	    
	    Double balance = null;
	    while(rs.next())
		
		 balance = rs.getDouble("bal");
	     Double balance1 =balance;
		 
		
		
	     	//verifying the account number
	    String sql1="select AccountNumber from Customer_Details where AccountNumber='"+accno+"'" ;
	   
	    PreparedStatement pst1 = con.prepareStatement(sql1);
	   
	    ResultSet rs1 = pst1.executeQuery();
		
	    Integer AccountNumber = null;
	   
			while(rs1.next())
			{
	    	  AccountNumber= rs1.getInt("AccountNumber");
	        
			}
			
			
		if(AccountNumber!=null && AccountNumber.equals(accno))
		{
	
			
				Scanner sc=new Scanner(System.in);

				System.out.println("Avaliable Balance:"+balance1);
				 
				System.out.println("To AccountNumber:");
				 
				int Toacc=sc.nextInt();
				System.out.println("EnterIFSC Code:");
				 
				 String code=sc.next();

				System.out.print("Enter Transfer Amount:");
				
			double Fund=sc.nextDouble();
			{
			if(balance1 >= Fund && balance1>0)
				{
				       balance1=balance1-Fund;
				   
				   System.out.println("Transfer Sucessfully");
				   
				   System.out.println("ramining balance "+balance1);
				}
				   
				
			else 
				{  
				   System.out.println("insufficient balance"); 
				    Fund = 0.0;
				} 
			}
				
				String sql2 = "update  Customer_Details set Bal=? where AccountNumber='"+accno+"'";
		        PreparedStatement pst2 = con.prepareStatement(sql2);
		        
		       pst2.setDouble(1,balance1);
		      int row = pst2.executeUpdate();
		      
		    //Date and Time
				SimpleDateFormat stm=new SimpleDateFormat("dd/MM/yyyy  HH:mm:ss");
		        Date date=new Date();
		       String DT= (stm.format(date));
		        
		        
		        Double CR=0.0;
				
		        Double DR=0.0;
				
		        String Action="FT";
			
			String sql3 = "insert into Transaction_Details(AccNo,ToAcc,Date,Functions,Deposit,WithDraw,IFSC,FundTransfer,Balance) values (?,?,?,?,?,?,?,?,?)";
	        PreparedStatement pst3 = con.prepareStatement(sql3);
	       
	        
	        pst3.setInt(1,accno);
	        
	        pst3.setInt(2,Toacc);
	        
	        pst3.setString(3, DT);
	        
	        pst3.setString(4,Action);
	        
	        pst3.setDouble(5, CR);
	        
	        pst3.setDouble(6,  DR);
	        
	        pst3.setString(7,code);
	        
	        pst3.setDouble(8, Fund);
	        
	        pst3.setDouble(9, balance1);
	       
	     
	        
	        System.out.println("balance    "+balance1);
	        
	        int rows = pst3.executeUpdate();
	        System.out.println("Number Of Rows Inserted    "+rows);
		}
		
       
		
	else
		{
			
			System.out.println("Invaild Account Number.... ");
		
		}
       }
      }
}


    
	        
	


	    
	
