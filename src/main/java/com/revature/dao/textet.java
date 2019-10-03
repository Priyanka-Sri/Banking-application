package com.revature.dao;

import java.util.Scanner;

public class textet {

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);

		System.out.print("Enter a string: ");
		String s = in.next();

		while (true) {
			System.out.print(s);
			System.out.print("  ");
			Thread.sleep(1);

			// s = s.substring(1) + s.substring(0,1);
		}

	}
}
