package com.FinTrackImplementation;
import java.util.Scanner;

public class FinTrackDone{
		Scanner sc = new Scanner(System.in);
		public void exe(){
			System.out.printf("Kindly choose your account type to proceed (Admin or Customer).\nEnter 1 for ADMIN, 2 for CUSTOMER: ");
			int choice1 = sc.nextInt();
			System.out.println();
			if(choice1==1) {
				
			}
			else if(choice1==2) {
				System.out.println("Welcome to the Customer Panel..");
			}
			else {
				System.out.println("Invalid input. Please enter 1 for Admin or 2 for Customer.");
			}
		}
		
}
