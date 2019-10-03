package com.revature.Register;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class FoundTransfer 
{
      // public static void main(String args[]) throws SQLException, ClassNotFoundException 
	public static  void function() throws SQLException, ClassNotFoundException 
	{
	   
	
    	   {
        
       int acc2;
       Double famt;
	    Connection con = ConnectionUtil.getConnection();
	    Scanner scn2 =new Scanner(System.in);
		System.out.println("Enter AccountNumber: ");
	    int accno3 =scn2.nextInt();
	    
	    String sql="select bal from register where AccountNumber='"+accno3+"'";
	    //retriveing the balance from register table 
	    
	    
	    PreparedStatement pst = con.prepareStatement(sql);
	    ResultSet rs = pst.executeQuery();
	    
	   Double bal = null;
	    while(rs.next())
		
		 bal = rs.getDouble("bal");
	  Double bal1 =bal;
		 
		
		
      
	    String sql3="select AccountNumber from register where AccountNumber='"+accno3+"'" ;
	    //verifying the account number
	    PreparedStatement pst3 = con.prepareStatement(sql3);
	   
	    ResultSet rs3 = pst3.executeQuery();
		
	    Integer AccountNumber2 = null;
	   
			while(rs3.next())
			{
	    	  AccountNumber2= rs3.getInt("AccountNumber");
	        
			
			
	    
			}
			
			
		if(AccountNumber2!=null && AccountNumber2.equals(accno3))
		{
		//	System.out.println("");
			
				Scanner sc=new Scanner(System.in);

				

				System.out.println("bal:"+bal1);
				 
				
				
				System.out.println("To AccountNumber:");
				 acc2=sc.nextInt();

				

				System.out.print("Transfer Amount:");
				 famt=sc.nextDouble();
				{
				if(bal1 >= famt && bal1>0)
				{
				    

				   System.out.println("Transfer Sucessfully");
				   bal1=bal1-famt;
				   
				   System.out.println("ramining balance "+bal1);
				}
				   else 
				{  
				   System.out.println("insufficient balance"); 
				    famt = 0.0;
				} 
				}
				
				String sql5 = "update  register set Bal=? where AccountNumber='"+accno3+"'";
		        PreparedStatement pst5 = con.prepareStatement(sql5);
		        
		       pst5.setDouble(1,bal1);
		      int row = pst5.executeUpdate();
		        System.out.println("Number Of Rows     "+row);
		
			
			
		        Double wamt=0.0;
				Double damt=0.0;
			String sql1 = "insert into Fun(accno,damt,wamt,famt,bal) values (?,?,?,?,?)";
	        PreparedStatement pst1 = con.prepareStatement(sql1);
	        
	        
	        pst1.setInt(1,accno3 );
	        //pst1.setString(2,deposit1 );
	        pst1.setDouble(2, damt);
	        pst1.setDouble(3, wamt);
	        pst1.setDouble(4, famt);
	        pst1.setDouble(5, bal1);
	        System.out.println("deposit success");
	       
	        int rows = pst1.executeUpdate();
	        System.out.println("Number Of Rows Inserted    "+rows);
			
			
	        System.out.println("your balance   "+bal1);
		}
		
       
		
		else
		{
			
			
			System.out.println("Login not Successfully....?????");
		}
       }
}
}


    
	        
	


	    
	
