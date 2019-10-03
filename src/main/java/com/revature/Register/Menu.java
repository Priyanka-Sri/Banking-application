package com.revature.Register;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.revature.util.ConnectionUtil;

public class Menu {
	
	public static  void function() throws SQLException, ClassNotFoundException 
	{
	
	
	
	{
		 Scanner input = new Scanner(System.in);
		 Connection con = ConnectionUtil.getConnection();
		int menu;
		System.out.println("Menu");
		System.out.println("1. Deposit Amount");
		System.out.println("2. Withdraw Amount");
		System.out.println("3. Fund Transfer");
		System.out.println("4. View Balance");
		System.out.println("5. Mini Statement ");
		System.out.println("6. Exit");
		
		boolean quit = false;
		
		
		do {
			System.out.print("Please enter your choice: ");
			menu = input.nextInt();
			switch (menu) {
			
case 1:
				
				Deposit.function();
				
				break;

case 2:
				Withdraw.function();	
				
				break;
				
				
case 3:
	
				FundTransfer.function();
				
				break;
					
				
case 4:
				ViewBalance.function();
				
				break;
				
				
				
case 5:
				Statement.function();
				break;

case 6:
				quit = true;
				
				break;
			}
			
		} 
		
		while (!quit);
	

			
			
          }		

        }
     }

	
	
	
	
	


