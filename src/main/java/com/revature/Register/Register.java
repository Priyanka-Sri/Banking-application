package com.revature.Register;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.util.Scanner;


import com.revature.dao.CustomerDAO;
import com.revature.model.CustomerDetails;
import com.revature.util.ConnectionUtil;

public class Register {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		Connection con = ConnectionUtil.getConnection();
		System.out.println(" ");
		
		System.out.println("************** WELCOME TO INDIAN BANK ************  ");
		System.out.println(" ");
		
        Scanner scn =new Scanner(System.in);
           
        
        System.out.println("1.Login Here.......");
        
        System.out.println("2 Register Here..!!!");
        
        System.out.println(" Enter The Your choice ");
                int select=scn.nextInt();
                
 switch(select) {
                
                
 case 1:
	 			System.out.println("Login..!!!"); 
                
	 			System.out.println("Enter the CustomerID");
                int Cstid=scn.nextInt();
                
                System.out.println("Enter the Password");
                String pass =scn.next();
                
                CustomerDetails det=new CustomerDetails();
                det= CustomerDAO.login(Cstid, pass);
				
                if(det != null)
				{
					System.out.println("Login Successfully");
		
					Menu.function();
				
				}
                else
					System.out.println("Invalid PassWord");
               
                break;
                
           
case 2:
        	  
		System.out.println("Register Here..!!!");
                 
         System.out.println("Enter the User Name");
                 
         		String UserName=scn.next();
                 System.out.println("Enter the customer ID:");
                 int Cno1=scn.nextInt();
               
                 
                 System.out.println("Enter the PassWord:");
                 String PassWord1=scn.next();
                 
                 System.out.println("Enter the EmailID:");
	             String Email1 =scn.next();
                 
	             System.out.println("Enter the Mobile Number:");
                 long MobileNumber=scn.nextLong();
                 
                 System.out.println("Enter the AccountNumber:");
                 long AccountNumber=scn.nextLong();
	             
                 System.out.println("Enter the AccountType:");
	             String AccountType=scn.next();
	             
	             System.out.println("Enter the Initial Balance:");
                 Double Bal=scn.nextDouble();
                 
                 System.out.println("Enter the PanNumber:");
                 String PanNumber=scn.next();
                 
                 System.out.println("Enter the AadharNumber:");
                 long AadharNumber=scn.nextLong();        
                
                 String sql1 = "insert into Customer_Details(UserName,Cno,PassWord,Email,MobileNumber,AccountNumber,AccountType,bal,PanNumber,AadharNumber) values ( ?,?,?,?,?,?,?,?,?,?)";
                 PreparedStatement pst1 = con.prepareStatement(sql1);
                 
                 pst1.setString(1, UserName);
                 pst1.setInt(2, Cno1);
                 pst1.setString(3, PassWord1);
                 pst1.setString(4, Email1);
                 pst1.setLong(5, MobileNumber);
                 pst1.setLong(6, AccountNumber);
                 pst1.setString(7, AccountType );
                 pst1.setDouble(8, Bal);
                 pst1.setString(9, PanNumber);
                 pst1.setLong(10, AadharNumber);
                 
                 int rows = pst1.executeUpdate();
                 System.out.println("Number Of Rows Inserted    "+rows);
                 
                 break;
                   
         default:System.out.println("Invalid Selection..!!!");
                                   
                
       } 
               
	} 
}   

